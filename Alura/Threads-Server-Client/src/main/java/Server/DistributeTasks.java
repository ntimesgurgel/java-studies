package Server;

import Server.Commands.CommandOne;
import Server.Commands.CommandTwoCallsBank;
import Server.Commands.CommandTwoCallsWS;
import Server.Commands.JoinFutureResults;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class DistributeTasks implements Runnable {
    private final BlockingQueue<String> commandQueue;
    private final ExecutorService threadPool;
    private final Socket socket;
    private final ServerTasks server;

    public DistributeTasks(BlockingQueue<String> commandQueue, ExecutorService threadPool, Socket socket, ServerTasks server) {
        this.commandQueue = commandQueue;
        this.threadPool = threadPool;
        this.socket = socket;
        this.server = server;
    }

    @Override
    public void run() {
        System.out.println("Giving task to " + socket);
        try {
            Scanner inputClient = new Scanner(socket.getInputStream());
            PrintStream outputClient = new PrintStream(socket.getOutputStream());

            while (inputClient.hasNextLine()){
                String command = inputClient.nextLine();
                switch (command) {
                    case "c1" -> {
                        outputClient.println("confirmation command c1");
                        CommandOne c1 = new CommandOne(outputClient);
                        this.threadPool.execute(c1);
                        break;
                    }
                    case "c2" -> {
                        outputClient.println("confirmation command c2");
                        CommandTwoCallsWS c2WS = new CommandTwoCallsWS(outputClient);
                        CommandTwoCallsBank c2Bank = new CommandTwoCallsBank(outputClient);
                        Future<String> futureWS = this.threadPool.submit(c2WS);
                        Future<String> futureBank = this.threadPool.submit(c2Bank);

                        this.threadPool.submit(new JoinFutureResults(futureWS, futureBank, outputClient));

                        break;
                    }
                    case "c3" -> {
                        outputClient.println("Command c3 added to queue");
                    }
                    case "end" -> {
                        this.commandQueue.put(command);
                        outputClient.println("Shutting down server");
                        this.server.stop();
                        break;
                    }
                    default -> {
                        outputClient.println("confirmation generic command");
                        break;
                    }
                }
            }
            outputClient.close();
            inputClient.close();

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

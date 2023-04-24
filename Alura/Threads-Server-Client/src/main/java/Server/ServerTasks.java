package Server;

import Server.Exceptions.ExceptionTreatment;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.concurrent.*;

public class ServerTasks {

    private final ServerSocket server;
    private final ExecutorService threadPool;
    private volatile boolean running = true;
    private BlockingQueue<String> commandQueue;

    public ServerTasks() throws IOException {
        System.out.println("Starting server");
        this.server = new ServerSocket(4321);
        this.threadPool = Executors.newFixedThreadPool(4, (server)->{
            int number = 1;
            Thread thread = new Thread(server,"Thread Server " + number);
            thread.setUncaughtExceptionHandler(new ExceptionTreatment());
            return thread;
        });
        this.commandQueue = new ArrayBlockingQueue<String>(3);
        initConsumer();
    }

    public static void main(String[] args) throws IOException {
        ServerTasks serverTasks = new ServerTasks();
        serverTasks.run();
        serverTasks.stop();
    }

    public void stop() throws IOException {
        this.running = false;
        this.server.close();
        this.threadPool.shutdown();
    }

    public void run() throws IOException {
        while (this.running) {
            try {
                Socket socket = server.accept();
                System.out.println("Accepting new client at port " + socket.getPort());
                System.out.println(socket.getInputStream().toString());
                threadPool.execute(new DistributeTasks(commandQueue, threadPool, socket, this));
            } catch (SocketException e) {
                System.out.println("SocketException, is the server running? " + this.running);
            }
        }
    }

    private void initConsumer() {


        int qtdConsumers = 2;
        for (int i = 0; i < qtdConsumers; i++) {
            ConsumeTasks task = new ConsumeTasks(commandQueue);
            this.threadPool.execute(task);
        }
    }
}

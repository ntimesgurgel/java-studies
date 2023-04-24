package Server.Commands;

import java.io.PrintStream;

public class CommandOne implements Runnable {
    private final PrintStream outputClient;

    public CommandOne(PrintStream outputClient) {
        this.outputClient = outputClient;
    }

    @Override
    public void run() {
        System.out.println("Executing command c1");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        outputClient.println("Command c1 successfully executed");
    }
}

package Server.Commands;

import java.io.PrintStream;
import java.util.Random;
import java.util.concurrent.Callable;

public class CommandTwoCallsWS implements Callable<String> {
    private final PrintStream outputClient;
    public CommandTwoCallsWS(PrintStream outputClient) {
        this.outputClient = outputClient;
    }

    @Override
    public String call() throws Exception {
        System.out.println("Executing command c2 - WS");
        outputClient.println("Processing command c2");

        Thread.sleep(1000);
        int number = new Random().nextInt(100);

        System.out.println("Command c2 successfully executed");

        return Integer.toString(number);
    }
}

package Server.Commands;

import java.io.PrintStream;
import java.util.concurrent.*;

public class JoinFutureResults implements Callable<Void> {
    private final PrintStream outputClient;
    private final Future<String> futureBank;
    private final Future<String> futureWS;

    public JoinFutureResults(Future<String> futureWS, Future<String> futureBank, PrintStream outputClient) {
        this.futureWS = futureWS;
        this.futureBank = futureBank;
        this.outputClient = outputClient;
    }

    @Override
    public Void call() {
        System.out.println("Waiting results");
        try {
            String magicNumber1 = this.futureWS.get(15, TimeUnit.SECONDS);
            String magicNumber2 = this.futureBank.get(15, TimeUnit.SECONDS);

            this.outputClient.println("Result command c2 " + magicNumber1 + ", " + magicNumber2);

        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            this.outputClient.println("Execution timeout at command c2");
            this.outputClient.println("Interrupting executions");
            this.futureWS.cancel(true);
            this.futureBank.cancel(true);
        }

        return null;
    }
}

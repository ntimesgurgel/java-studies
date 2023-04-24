package Server.Exceptions;

public class ExceptionTreatment implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("Exception at: " + t.getName() + ", " + e.getMessage());
    }
}

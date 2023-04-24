package Server;

import Server.Exceptions.ExceptionTreatment;

import java.util.concurrent.ThreadFactory;

public class threadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setUncaughtExceptionHandler(new ExceptionTreatment());
        return thread;
    }
}

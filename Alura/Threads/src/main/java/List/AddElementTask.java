package List;

import java.util.List;

public class AddElementTask implements Runnable {
    private final Lista list;
    private final int threadNumber;

    public AddElementTask(Lista list, int threadNumber) {
        this.list = list;
        this.threadNumber = threadNumber;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            list.addElements("Thread " + threadNumber + " - " + i);
        }
    }
}

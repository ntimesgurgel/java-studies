package List;

public class PrintTask implements Runnable {
    private final Lista list;

    public PrintTask(Lista list) {
        this.list = list;
    }

    @Override
    public synchronized void run() {
        try {
            list.wait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        for (int i = 0; i < list.length(); i++) {
            System.out.println(i + " - " + list.getElement(i));
        }
    }
}

package Bathroom;

public class Clean implements Runnable {
    private final Bathroom bath;

    public Clean(Bathroom bath) {
        this.bath = bath;
    }

    @Override
    public void run() {
        while (true){

            this.bath.clean();
            try {
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

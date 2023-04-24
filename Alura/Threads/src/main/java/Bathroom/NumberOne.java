package Bathroom;

public class NumberOne implements Runnable {
    private final Bathroom bath;

    public NumberOne(Bathroom bath) {
        this.bath = bath;
    }

    @Override
    public void run() {
        this.bath.numberOne();
    }
}

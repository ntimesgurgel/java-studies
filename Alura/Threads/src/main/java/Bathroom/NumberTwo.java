package Bathroom;

public class NumberTwo implements Runnable {
    private final Bathroom bath;

    public NumberTwo(Bathroom bath) {
        this.bath = bath;
    }

    @Override
    public void run() {
        this.bath.numberTwo();
    }
}

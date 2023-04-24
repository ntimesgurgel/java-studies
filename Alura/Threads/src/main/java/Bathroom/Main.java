package Bathroom;

public class Main {
    public static void main(String[] args) {

        Bathroom bath = new Bathroom();

        Thread guest1 = new Thread(new NumberOne(bath), "John");
        Thread guest2 = new Thread(new NumberTwo(bath), "Mark");
        Thread cleaning = new Thread(new Clean(bath), "Cleaning service");
        cleaning.setDaemon(true);
        cleaning.setPriority(Thread.MAX_PRIORITY);
        guest1.start();
        guest2.start();
        cleaning.start();
    }
}

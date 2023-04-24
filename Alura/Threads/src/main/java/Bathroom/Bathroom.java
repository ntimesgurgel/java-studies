package Bathroom;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bathroom {
    private final Lock lock = new ReentrantLock();
    private boolean isDirty = true;
    public synchronized void numberOne(){

        System.out.println("Enter bathroom");

        while(isDirty){
            this.waitOutside();
        }

        System.out.println("Doing quick");

        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        this.isDirty = true;

        System.out.println("Flushing");
        System.out.println("Washing hands");
        System.out.println("Leaving");
    }

    public synchronized void numberTwo(){

        System.out.println("Enter bathroom");

        while(isDirty){
            this.waitOutside();
        }

        System.out.println("Doing slow");

        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        this.isDirty = true;

        System.out.println("Flushing");
        System.out.println("Washing hands");
        System.out.println("Leaving");

    }

    private void waitOutside(){
        System.out.println("the bathroom is dirty!");
        try {
            this.wait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public void clean(){
        String name = Thread.currentThread().getName();

        System.out.println(name + " knocking on door");

        synchronized (this) {

            System.out.println(name + " entering bathroom");

            if (!this.isDirty) {
                System.out.println(name + ", isn't clean, i'm out");
                return;
            }

            System.out.println(name + " cleaning bathroom");
            this.isDirty = false;

            try {
                Thread.sleep(13000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            this.notifyAll();

            System.out.println(name + " leaving bathroom");
        }
    }
}

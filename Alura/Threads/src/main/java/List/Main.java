package List;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Lista list = new Lista();

        for (int i = 0; i < 100; i++) {

            Thread thread = new Thread(new AddElementTask(list, i));
            thread.start();

        }

        new Thread(new PrintTask(list)).start();
    }
}

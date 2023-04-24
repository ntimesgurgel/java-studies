package Client;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientTasks {
    public static void main(String[] args) throws IOException, InterruptedException {
        Socket socket = new Socket("localhost", 4321);
        System.out.println("Stablished connection");

        Thread sendCommandThread = new Thread(()->{
                PrintStream output = null;
                try {
                    output = new PrintStream(socket.getOutputStream());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                Scanner keyboard = new Scanner(System.in);
                while(keyboard.hasNextLine()){
                    String line = keyboard.nextLine();
                    if(line.trim().equals("")){
                        break;
                    }
                    output.println(line);
                }
            output.close();
            keyboard.close();

        });

        System.out.println("Receiving server response");

        Thread receiveServerResponseThread = new Thread(()->{
            Scanner serverResponse = null;
            try {
                serverResponse = new Scanner(socket.getInputStream());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            while (serverResponse.hasNextLine()){
                String line = serverResponse.nextLine();
                System.out.println(line);
            }
            serverResponse.close();
        });

        sendCommandThread.start();
        receiveServerResponseThread.start();

        receiveServerResponseThread.join();

        socket.close();
    }
}

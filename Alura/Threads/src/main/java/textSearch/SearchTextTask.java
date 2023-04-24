package textSearch;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Scanner;

public class SearchTextTask implements Runnable {

    private final String archiveName;
    private final String name;

    public SearchTextTask(String archiveName, String name) {
        this.archiveName = archiveName;
        this.name = name;
    }

    @Override
    public void run() {

        synchronized (this){
            try {
                Thread actual = Thread.currentThread();

                Scanner scanner = new Scanner(
                        new File(
                                this.archiveName
                        )
                );

                int numberLine = 1;

                while(scanner.hasNextLine()){
                    String line = scanner.nextLine();

                    if(line.contains(this.name)){
                        System.out.println(archiveName + " - " + numberLine + " - " + line);
                    }

                    numberLine++;
                }
                scanner.close();

            } catch (FileNotFoundException e) {
                throw new RuntimeException("Arquivo não encontrado");
            }
        }
    }
}

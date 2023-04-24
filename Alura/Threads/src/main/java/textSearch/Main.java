package textSearch;

public class Main {

    public static void main(String[] args) {
        String name = "Jon";
        Thread threadSignatures1 = new Thread(new SearchTextTask("assinaturas1.txt", name));
        Thread threadSignatures2 = new Thread(new SearchTextTask("assinaturas2.txt", name));
        Thread threadSignatures3 = new Thread(new SearchTextTask("autores.txt", name));

        threadSignatures1.start();
        threadSignatures2.start();
        threadSignatures3.start();
    }
}

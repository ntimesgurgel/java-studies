public class VectorTest {
    public static void main(String[] args) {
        Student s1 = new Student("Nathan");
        Student s2 = new Student("Rayanne");

        Vector list = new Vector();

        list.add(s1);
        list.add(s2);

        System.out.println(list);
    }
}

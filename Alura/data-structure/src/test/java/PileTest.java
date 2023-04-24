public class PileTest {

    public static void main(String[] args) {
        Pile pile = new Pile();

        pile.insert("Nathan");

        System.out.println(pile);

        pile.insert("Rayanne");

        System.out.println(pile);

        String r1 = pile.remove();
        System.out.println(r1);

        String r2 = pile.remove();
        System.out.println(r2);
    }
}

import java.util.LinkedList;
import java.util.List;

public class Pile {

    private List<String> names = new LinkedList<String>();

    public void insert(String name){
        names.add(name);
    }

    public String remove(){
        return names.remove(names.size()-1);
    }

    public boolean empty(){
        return names.isEmpty();
    }

    @Override
    public String toString() {
        return "Pile{" +
                "names=" + names +
                '}';
    }
}

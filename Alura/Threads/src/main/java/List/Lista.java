package List;

public class Lista {
    private String[] elements = new String[1000];
    private int index = 0;

    public void addElements(String element) {
        synchronized (this){
            this.elements[index] = element;
            this.index++;

            if(this.index == this.length()){
                System.out.println("list is full, notifying");
                this.notify();
            }

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public int length() {
        return this.elements.length;
    }

    public String getElement(int position) {
        return this.elements[position];
    }
}

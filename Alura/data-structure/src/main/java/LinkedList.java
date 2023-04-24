public class LinkedList {

    private Cell first = null;
    private Cell last = null;
    private int totalElements = 0;

    public void addOnBeginning(Object element){
        this.first = new Cell(element, first);

        if(this.totalElements==0){
            this.last = this.first;
        }

        this.totalElements++;
    }

    public void add(Object element){

        if(this.totalElements==0){
            this.addOnBeginning(element);
            this.totalElements++;
            return;
        }

        Cell newCell = new Cell(element, null);
        this.last.setNext(newCell);
        this.last=newCell;
        this.totalElements++;
    }

    public void add(int position, Object element){}

    private boolean positionOccupied(int position){
        return position >= 0 && position <= this.totalElements;
    }

    public Object get(int position){
        if(!positionOccupied(position)){
            throw new IllegalArgumentException("position out of linked list length");
        }

        Cell thisCell = this.first;

        for(int i = 0; i<position; i++){
            thisCell = thisCell.getNext();
        }

        return thisCell;
    }

    public int length(){
        return this.totalElements;
    }

//    public boolean has(Object o){}

    @Override
    public String toString() {

        if(this.totalElements==0){
            return "[]";
        }

        Cell actual = this.first;

        StringBuilder builder = new StringBuilder("[");

        for(int i=0; i<totalElements;i++){
            builder.append(actual.getElement());
            builder.append(",");

            actual = actual.getNext();
        }

        builder.append("]");

        return builder.toString();
    }
}

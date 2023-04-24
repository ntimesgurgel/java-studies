import java.util.Arrays;

public class Vector {
    private Student[] students = new Student[100];
    private int totalStudents = 0;

    private void guaranteeSpace(){
        if(totalStudents == this.students.length){
            Student[] newArray = new Student[this.students.length*2];
            System.arraycopy(this.students, 0, newArray, 0, this.students.length);
            this.students = newArray;
        }
    }
    public void add(Student student){
        this.guaranteeSpace();
        this.students[totalStudents] = student;
        totalStudents++;
    }

    private boolean validPosition(int position){
        return position >= 0 && position <= totalStudents;
    }

    public void addInPosition(Student student, int position){
        this.guaranteeSpace();

        if(!validPosition(position)){
            throw new IllegalArgumentException("Invalid position, expected a number equal to" + totalStudents + "or less");
        }

        for(int i = totalStudents -1; i >= position; i--){
            this.students[i+1]=this.students[i];
        }

        this.students[position] = student;
        totalStudents++;
    }
    private boolean positionOccupied(int position){
        return position >= 0 && position <= totalStudents;
    }

    public Student getStudent(int position){
        if(!positionOccupied(position)){
            throw new IllegalArgumentException("Invalid Position");
        }
        return this.students[position];
    }

    public  void remove(int position){
        if(!validPosition(position)){
            throw new IllegalArgumentException("Invalid position, expected a number equal to" + totalStudents + "or less");
        }

        for(int i = position; i <this.totalStudents-1; i++){
            this.students[i] = this.students[i+1];
        }
        this.students[totalStudents]=null;
    }

    public boolean has(Student student){
        for(int i=0; i<totalStudents; i++){
            if( student.equals(students[i]) ){
                return true;
            }
        }
        return false;
    }

    public int length(){
        return totalStudents;
    }

    public String toString() {
        return Arrays.toString(students);
    }
}

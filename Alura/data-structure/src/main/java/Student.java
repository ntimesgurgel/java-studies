public class Student {
    private String name;

    public Student(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        Student other = (Student) obj;
        return this.name.equals(other.name);
    }

    @Override
    public String toString() {
        return this.name;
    }
}

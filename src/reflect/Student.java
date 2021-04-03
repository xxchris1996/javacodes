package reflect;

public class Student {
    private String name;
    private int age;

    public Student() {

    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public void sleep(){
        System.out.printf("sleep...");
    }
}

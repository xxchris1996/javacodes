package demo;

public class Person {
    String name = "gf";
    private int age;

    public void show(String name){
        System.out.println("我叫："+name+"，年龄："+this.name);
    }

    public void setAge(int num){
        age = num;
    }

    public int getAge(){
        return age;
    }
}

package demo;

public class DemoPerson {


    public static void main(String[] args) {
        Person newperson = new Person();
        newperson.show("xjj");
        newperson.name = "gf";
        newperson.setAge(10);
        int count = newperson.getAge();
        System.out.println(count);
        newperson.show("xjj");
    }

}

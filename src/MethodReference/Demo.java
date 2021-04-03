package MethodReference;

public class Demo {
    public static void printName(String name, PersonBuilder pb){
        Person person = pb.builderPerson(name);
        System.out.println(person.getName());
    }

    public static void main(String[] args) {
        printName("hasker",name->new Person(name));
        printName("chris",Person::new);
    }
}

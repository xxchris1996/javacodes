package MethodReference;

public class Demo01Print {
    public static void printString(Printable p){
        p.print("hello");
    }

    public static void main(String[] args) {
        printString(s-> System.out.println(s));
        printString(System.out::println);
    }
}

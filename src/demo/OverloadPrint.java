package demo;

public class OverloadPrint<pout> {
    public static void main(String[] args) {
        myPrint(100);
        myPrint("hello");

    }
    public static void myPrint(byte num) {
        System.out.println(num);
    }

    public static void myPrint(short num) {
        System.out.println(num);
    }

    public static void myPrint(float num) {
        System.out.println(num);
    }
    public static void myPrint(String  num) {
        System.out.println(num);
    }
}

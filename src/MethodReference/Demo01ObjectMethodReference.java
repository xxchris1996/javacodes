package MethodReference;

public class Demo01ObjectMethodReference {
    public static void printString(Printable p){
        p.print("hello");
    }

    public static int method(int num, Calcable c){
        return c.calsAbs(num);
    }

    public static void main(String[] args) {
        printString((s)->{
            MethodRerObject obj = new MethodRerObject();
            obj.printUpperCaseString(s);
        });
//        printString(MethodRerObject::printUpperCaseString);
//        printString(MethodRerObject::printUpperCaseString);
        MethodRerObject obj = new MethodRerObject();
        printString(obj::printUpperCaseString);

        int method = method(-10, (num) -> {
            return Math.abs(num);
        });
        int method1 = method(-10, Math::abs);
        System.out.println(method+method1);
    }
}

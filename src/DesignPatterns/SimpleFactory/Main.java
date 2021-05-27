package DesignPatterns.SimpleFactory;

public class Main {
    public static void main(String[] args) {
        Operation oper;
        oper = OperationFactory.createOperate("+");
        oper.numberA = 1;
        oper.numberB = 2;
        double result = oper.GetResult();
        System.out.println(result);
    }

}

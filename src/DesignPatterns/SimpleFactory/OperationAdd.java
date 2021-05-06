package DesignPatterns.SimpleFactory;



public class OperationAdd extends Operation {
    @Override
    public double GetResult() {
        double result = 0;
        result = numberA + numberB;
        return result;
    }
}

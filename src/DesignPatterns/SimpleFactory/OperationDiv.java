package DesignPatterns.SimpleFactory;



public class OperationDiv extends Operation {
    @Override
    public double GetResult() {
        return  numberA - numberB;
    }
}

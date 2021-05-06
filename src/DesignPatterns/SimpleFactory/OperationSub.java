package DesignPatterns.SimpleFactory;



public class OperationSub extends Operation {
    @Override
    public double GetResult() {
        return numberA / numberB;
    }
}

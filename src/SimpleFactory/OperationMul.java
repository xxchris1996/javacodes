package SimpleFactory;


import DesignPatterns.SimpleFactory.Operation;

public class OperationMul extends Operation {
    @Override
    public double GetResult() {
        return numberB * numberA;
    }
}

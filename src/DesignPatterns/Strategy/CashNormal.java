package DesignPatterns.Strategy;

class CashNormal extends CashSuper {
    @Override
    public double acceptCash(double money) {
        return money;
    }
}

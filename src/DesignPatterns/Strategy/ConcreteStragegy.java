package DesignPatterns.Strategy;

public class ConcreteStragegy {
    class CashNormal extends CashSuper {
        @Override
        public double acceptCash(double money) {
            return money;
        }
    }
    class CashRebate extends CashSuper {
        private double moneyRebate = 1.0;
        public CashRebate(String moneyRebate){
            this.moneyRebate = Double.parseDouble(moneyRebate);
        }
        @Override
        public double acceptCash(double money) {
            return money * moneyRebate;
        }
    }
    class CashReturn extends CashSuper {
        private double moneyCondition = 0.0;
        private double moneyReturn = 0.0;

        public CashReturn(String moneyCondition, String moneyReturn) {
            this.moneyCondition = Double.parseDouble(moneyCondition);
            this.moneyReturn = Double.parseDouble(moneyReturn);
        }

        @Override
        public double acceptCash(double money) {
            double result = money;
            if(money >= moneyCondition) return money - Math.floor(money/moneyCondition) * moneyReturn;
            return  money;
        }
    }
}

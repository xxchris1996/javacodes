package DesignPatterns.Strategy;

import java.util.Scanner;

public class CashContext {
    private CashSuper cs;

//    public CashContext(CashSuper csSuper) {
//        this.cs = csSuper;
//    }
    public CashContext(String type){
        Scanner sc = new Scanner(System.in);
        switch (type){
            case "1":
                CashNormal normal = new CashNormal();
                cs = normal;
                break;
            case "2":
                String moneyRebate = sc.next();
                CashRebate rebate = new CashRebate(moneyRebate);
                cs = rebate;
                break;
            case "3":
                String moneyCondition = sc.next();
                String moneyReturn = sc.next();
                CashReturn cashReturn = new CashReturn(moneyCondition,moneyReturn);
                cs = cashReturn;
                break;
        }
    }
    public double GetResult(double money){
        return cs.acceptCash(money);
    }
}

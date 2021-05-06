package DesignPatterns.Strategy;

import java.util.Scanner;

public class Client {
    static double total = 0.0;

    public static void main(String[] args) {
        CashContext cashContext;
        Scanner sc = new Scanner(System.in);
        String money = sc.next();
        System.out.println("请输入策略模式：1 Normal 2 Rebate 3 Return");
        String strategy = sc.next();


        cashContext = new CashContext(strategy);
        total = cashContext.GetResult(Double.parseDouble(money));


//        switch (strategy){
//            case "1" :
//                cashContext = new CashContext(new CashNormal());
//                total = cashContext.GetResult(Double.parseDouble(money));
//                break;
//            case "2":
//                String moneyRebate = sc.next();
//                cashContext = new CashContext(new CashRebate(moneyRebate));
//                total = cashContext.GetResult(Double.parseDouble(money));
//                break;
//            case "3":
//                String moneyCondition = sc.next();
//                String moneyReturn = sc.next();
//                cashContext = new CashContext(new CashReturn(moneyCondition, moneyReturn));
//                total = cashContext.GetResult(Double.parseDouble(money));
//                break;
//        }
        System.out.println(total);
    }
}

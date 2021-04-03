package demo;

import java.util.Scanner;

public class Demowhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true){
//            System.out.println("1");
//            while (sc.hasNextInt()){
//                System.out.println("2");
//                System.out.println(sc.nextInt());
//                System.out.println("3");
//            }
//            System.out.println("4");
            String str = sc.nextLine();
            try{

                int i = Integer.parseInt(str);
            }catch (Exception ex){
//                System.out.println(ex);
                continue;
            }
            System.out.println(str);


        }


    }
}

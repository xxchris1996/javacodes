package demo;

import java.io.Console;
import java.util.Scanner;

public class DemoScanner {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        System.out.println("please print");
//        String string1 = in.nextLine();
//        System.out.println(string1);
        Console cons = System.console();
        String username = cons.readLine("User name：");
        char[] passwd = cons.readPassword("Passwd:");
        System.out.println(username+String.valueOf(passwd));
    }
}

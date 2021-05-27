package demo;

public class DemoOverride {
    public static void main(String[] args) {
        Person p = new Man();
        System.out.println(p.type);        //返回结果为P
        System.out.println(p.getName());   //返回结果为Person

    }


    static class Person {

        String type = "P";

        public static String getName() {
            String name = "Person";
            return name;
        }
    }

    static class Man extends Person {

        String type = "M";

        public static String getName() {
            String name = "Man";
            return name;
        }
    }
}

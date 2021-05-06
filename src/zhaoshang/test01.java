package zhaoshang;

public class test01 {

    public static void main(String[] args) {
        System.out.println(method());
//        method();
    }
    static int method(){
        try {
            int i = 1/0;
            return 0;
        } catch (Exception ex){
//            System.out.println(1);
            return 1;
        } finally {
            System.out.println(2);
//            return 2;
        }
    }
}

package demo;

public class StringPratice {
    public static void main(String[] args) {
        int[] array = {1, 2, 3};
        System.out.println(fromArrayToString(array));
    }

    public static String fromArrayToString(int[] array) {
        String str = "[";
        for( int i = 0; i < array.length; i++) {
            if (i == array.length - 1){
                str += "word" + array[i] + "]";
            } else{
            str += "word" + array[i] + "#";
        }
    }
        return str;
}
}

package demo;

import java.util.ArrayList;
import java.util.Random;

public class ArrayListReturn {
    public static void main(String[] args) {
        ArrayList<Integer> bigList = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < 20; i++){
            int num = r.nextInt(100) + 1;
            bigList.add(num);
        }
        System.out.println(getSmallList(bigList));
    }

    public static ArrayList<Integer> getSmallList(ArrayList<Integer> bigList){
        ArrayList<Integer> smallList = new ArrayList<>();
        for (int i = 0; i < bigList.size(); i++){
            if(bigList.get(i) % 2 ==0){
                smallList.add(bigList.get(i));
            }
        }
        return smallList;
    }
}

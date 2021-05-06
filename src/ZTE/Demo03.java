//package ZTE;
//
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Scanner;
//import java.util.Stack;
//
//public class Demo03 {
//    public static void main(String[] args) {
//        HashMap<Integer, Stack<Integer>> map = new HashMap<>();
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();//10;
//        int idx = 0;
//        while(n != 0){
//            n--;
//            idx++;
//            int cur = sc.nextInt();
//            if(!map.containsKey(cur)) {
//                map.put(cur, new Stack<>());
//                map.get(cur).push(idx);
//            } else {
//                map.get(cur).push(idx);
//            }
//            if (map.size() >= 5){
//                for(Map.Entry<Integer, Stack<Integer>> entry : map.entrySet()){
//                    System.out.print(entry + " ");
//                    int key = entry.getKey();
//                    int value = map.get(key).pop();
////                    System.out.print(value+" ");
//                    System.out.print(entry.getValue() + " ");
//                    if(map.get(key).size() == 0) map.remove(entry.getKey()key);
//                }
////                for(int i = 1; i <= 5; i++){
////                    int value = map.get(i).pop();
////                    System.out.print(value + " ");
////                    if(map.get(i).size() == 0) map.remove(i);
////                }
//                System.out.println();
//            } else {
//                System.out.println(-1);
//            }
//
//        }
//    }
//}

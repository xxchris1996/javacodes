package myHash;

import java.util.ArrayList;
import java.util.LinkedList;

public class MyHash {
    private int size = 8;
    private int number = 0;

    private ArrayList<LinkedList> array_head = new ArrayList<>(size);

    public MyHash(){
        for(int i = 0; i < size; i++){
            LinkedList myList = new LinkedList();
            array_head.add(myList);
        }
    }

    public void put(Object key, Object value){
        if(number/size == 10){
            rehash();
        }
        if(get(key) == null){
            number++;
            Node new_Node = new Node(key, value);
            int code = hashCode(key.toString());
            int position = locate(code);
            LinkedList list_head = (LinkedList) array_head.get(position);
            list_head.add(new_Node);
        } else {
            replace(key,value);
        }

    }

    private void rehash() {
    }

    public Object get(Object key){
        int code = hashCode(key.toString());
        int position = locate(code);

        LinkedList list_head = (LinkedList) array_head.get(position);
        for(int i = 0; i < list_head.size(); i++){
            Node head = (Node) list_head.get(i);
            Node node = head;
                if(node.getKey().equals(key)){
                    System.out.println("node.getValue() :" + node.getValue());
                    return node.getValue();
                }
        }
        return null;
    }

    public Object remove(Object key){
        number--;
        int code = hashCode(key.toString());
        int postition = locate(code);

        LinkedList list_head = (LinkedList) array_head.get(postition);

        for(int i = 0; i < list_head.size(); i++){
            Node head = (Node) list_head.get(i);
            Node node = head;
                if(node.getKey().equals(key)){
                    Object value = node.getValue();
                    list_head.remove(node);
                    return value;
                }
        }
        return null;
    }

    public Object replace(Object key, Object newValue){
        System.out.println("replace");
        int code = hashCode(key.toString());
        int postition = locate(code);

        LinkedList list_head = (LinkedList) array_head.get(postition);
        for(int i = 0; i < list_head.size(); i++){
            Node head = (Node) list_head.get(i);
            Node node = head;
                if(node.getKey().equals(key)){
                    Object oldValue = node.getValue();
                    node.setValue(newValue);
                    return oldValue;
                }
            }
        return null;
    }
    public boolean containsKey(Object key){
        int code = hashCode(key.toString());
        int position = locate(code);

        LinkedList list_head = (LinkedList) array_head.get(position);

        for(int i = 0; i < list_head.size(); i++){
            Node head = (Node) list_head.get(i);
            Node node = head;
                if(node.getKey().equals(key)){
                    return true;
                }
        }
        return false;
    }
    public Object containValue(Object value){
        for(int k = 0; k < size; k++){
            LinkedList list_head = (LinkedList) array_head.get(k);
            for(int i = 0; i < list_head.size(); i++){
                Node head = (Node) list_head.get(i);
                Node node = head;
                    if(node.getValue().equals(value)){
                        return true;
                    }
            }
        }
        return false;
    }

    public void show(){
        System.out.println("打印哈希表");
        for(int k = 0; k < size; k++){
            LinkedList list_head = (LinkedList) array_head.get(k);
            System.out.println("链表："+ (k+1));
            for(int i = 0; i < list_head.size(); i++){
                Node head = (Node) list_head.get(i);
                Node node = head;
                    System.out.print("节点"+(i+1)+":("+node.getKey()+":"+node.getValue()+")");
            }
            System.out.println();
        }
        System.out.println();
    }
    public int size(){
        return number;
    }
    public void clear(){
        for(int k = 0; k < size; k++){
            LinkedList list_head = (LinkedList) array_head.get(k);
            list_head.clear();
        }
        number = 0;
    }

    public int locate(int k ){
        int m = k%size;
//        int m = k&(size-1);
        return m;
    }
    public int hashCode(String s) {
        int k = 0;
        for(int i = 0; i < s.length(); i++){
            k += s.charAt(i);
        }
        return k;
    }

    public static void main(String[] args) {
        MyHash myhash = new MyHash();
        myhash.put("abc",123);
        myhash.put("abc",234);
        myhash.put("a",1);
        myhash.put("b",2);
        myhash.put("c",3);
        myhash.put("d",4);
        myhash.put("e",5);
        myhash.put(234,5);
        myhash.get("abc");
        Object v = myhash.remove("abc");
        System.out.println(v);
        Object o = myhash.containValue(1);
        System.out.println(o);
        myhash.clear();
        myhash.show();
    }
}

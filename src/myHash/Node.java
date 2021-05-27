package myHash;

public class Node {
    private Object value;
    private Object key;

    public Node(){}

    public Node(Object key, Object value){
        this.key = key;
        this.value = value;
    }
    public Object getValue(){
        return value;
    }
    public void setValue(Object value){
        this.value = value;
    }
    public Object getKey(){
        return key;
    }
    public void setKey(){
        this.key = key;
    }
}

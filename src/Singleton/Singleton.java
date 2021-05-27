package Singleton;

/*饿汉式
public class Singleton {
    private static Singleton instance = new Singleton();
    private Singleton(){};
    public static Singleton getInstance(){
        return instance;
    }
}
*/
/*饿汉变种
public class Singleton {
    private static Singleton instance = null;
    static {
        instance = new Singleton();
    }
    private Singleton(){};
    public static Singleton getInstance(){
        return instance;
    }
}
*/
/*懒汉式
public class Singleton{
    private static Singleton instance = null;
    private Singleton(){};
    public static Singleton getInstance(){
        if(instance == null){
            instance = new Singleton();
        }
        return instance;
    }
}
*/
/*懒汉式-线程安全
public class Singleton{
    private static Singleton instance = null;
    private Singleton(){};
    public static synchronized Singleton getInstance(){
        if(instance == null){
            instance = new Singleton();
        }
        return instance;
    }
}*/
/*双重检查-不安全
public class Singleton{
    private static Singleton instance = null;
    private Singleton(){}
    public static Singleton getInstance(){
        if(instance == null){
            synchronized (Singleton.class){
                if(instance == null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}*/
/*双重检查-安全
public class Singleton{
    private static volatile Singleton instance = null;
    private Singleton(){}
    public static Singleton getInstance(){
        if (instance == null){
            synchronized (Singleton.class){
                if (instance == null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
*/
//public class Singleton {
//    private Singleton(){}
//    private static class InnerSingleton{
//        private static Singleton instance = new Singleton();
//    }
//    public static Singleton getInstance(){
//        return InnerSingleton.instance;
//    }
//}
//防止被反射破坏
public class Singleton{
    private static volatile Singleton instance = null;
    private Singleton(){
        synchronized (Singleton.class){
            if(ConstantClass.INSTANCECOINT > 0){
                throw new RuntimeException("This singleton pattern class can not create more object!");
            }
            ConstantClass.INSTANCECOINT++;
        }
    }
    public static Singleton getInstance(){
        if (instance == null){
            synchronized (Singleton.class){
                if (instance == null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
    static class ConstantClass{
        public static int INSTANCECOINT = 0;
        private ConstantClass(){}
    }
}
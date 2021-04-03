package Annotation.Demo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;

public class TestCheck {
    public static void main(String[] args) throws IOException {
        //创建计算器对象
        Calculator c = new Calculator();
        //获取字节码文件对象
        Class cls = c.getClass();
        //获取所有方法
        Method[] methods = cls.getMethods();

        int num = 0;
        BufferedWriter bw = new BufferedWriter(new FileWriter("bug.txt"));
        for (Method method : methods) {
            //判断方法上是否有check注解
            if(method.isAnnotationPresent(Check.class)){
                //有，执行
                try {
                    method.invoke(c);
                } catch (Exception e) {
                    //捕获异常
                    num++;
                    //记录到文件中
                    bw.write(method.getName()+"方法出异常了");
                    bw.newLine();
                    bw.write("异常的名称:"+e.getCause().getClass().getSimpleName());
                    bw.newLine();
                    bw.write("异常的原因:"+e.getCause().getMessage());
                    bw.newLine();
                    bw.write("--------------------------------");
                    bw.newLine();
                }
            }
        }
        bw.write("本次测试一共出现" + num + "次异常");
        bw.close();
    }
}

package A03Object类;

/**每一个类也隐藏调用Object*/
class Student {
    String name;
    int age;

    public  Student() {
        super();
    }

    public void learn() {
        System.out.println(name + "正在学习");
    }


    /**重写Object tostring方法*/
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}


/**
 *Object概述
 *object是所有类的根类，所有的类都是直接或者间接的去继承Object类。
 *类object是类层次结构的根类。每个类都使用Object作为超类。所有对象（包括数组）都实现这个类的方法。
 */

public class A01超类Object的toString方法 {
    public static void main(String[] args) {
        Student stu = new  Student();
        System.out.println("获取一个类的类对象 :" + stu.getClass());

        System.out.println("获取一个类的类对象地址返回的是十进制(每一次创建的对象地址也是不一样的) :" + stu.hashCode());

        System.out.println("Integer.toHexString()十进制转成十六进制  :" + Integer.toHexString(stu.hashCode()));
        /**要是打印真实的文字就要重写父类的toString方法*/
        System.out.println(stu.toString());


        stu. toString();
    }
}
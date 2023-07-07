public class A03抽象类abstract {
    public static void main(String[] args) {
        JavaTeacher javaTeacher = new JavaTeacher("周先生",19);
        javaTeacher.sleep();
        javaTeacher.Java();



    }
}

/**
 * public abtract [返回值][void]  方法名 (参数列表);
 * 没有方法体。如果在一个类中存在一个方法，那么这个类一定是抽象类。这个类上也要有abstract标识，
 * 抽象类的语法：
 * abstract class  类名{
 * 属性
 * 方法
 * }
 * 注意：抽象类中可以没有抽象方法，但是有抽象方法的类一定是抽象类
 */
 abstract   class  Teacher{
    String name;
    int age;
    public Teacher(String name, int age) {
        this.name = name;
        this.age = age;
    }
        /**抽象方法*/
    public abstract void sleep();

}
/**继承抽象类  必须实现抽象类的抽象方法*/
class JavaTeacher  extends Teacher{


    public JavaTeacher(String name, int age) {
        super(name, age);
    }

    /**实现抽象类的抽象方法*/
    @Override
    public void sleep() {
        System.out.println("实现抽象类的抽象方法");

    }

    /**子类的独有的方法*/
    public  void  Java() {
        System.out.println("子类的自己方法");
    }
}


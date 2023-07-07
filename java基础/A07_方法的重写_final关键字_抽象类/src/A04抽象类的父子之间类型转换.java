public class A04抽象类的父子之间类型转换 {
    public static void main(String[] args) {

      /**用法和普通类父子之间类型转换一样 请看A06继承_内存结构_super关键字\src\A01继承的讲解\A02类的父子类之间类型转换.java*/
        JavaTeacher1 javaTeacher1 = new JavaTeacher1();
        Teacher1  teacher1 = javaTeacher1;

    }
}
abstract class Teacher1 {
    public abstract void work();

    public abstract void sleep();

}

class JavaTeacher1 extends Teacher1 {
    @Override
    public void work() {
        System.out.println("工作");
    }

    @Override
    public void sleep() {
        System.out.println("睡觉");
    }

}

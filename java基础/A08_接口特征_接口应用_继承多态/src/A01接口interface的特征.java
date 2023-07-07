public class A01接口interface的特征 {
    public static void main(String[] args) {
        JavaTeacher javaTeacher = new JavaTeacher();
        javaTeacher.sleep();
        javaTeacher.teachSchool();


    }
}


/**定义一个接口*/
interface Teacher {
    /**
     * 这个属性默认是 public static final
     * 接口中定义的"属性"都是常量。常量的名字的规范,如果多个单词来表示常量名字用_分隔
     */
    public static final double PI = 3.14;
    public void teachSchool();

    /**jdk1.8以后可以添加default可以不默认实现此方法(但是会默认继承下去,子类的对象可以调用此方法)*/
    public default void sleep() {
        System.out.println("jdk1.8以后可以添加default可以不默认实现此方法");

    }

}
/**实现接口,必须实现接口的全部方法*/
class JavaTeacher implements Teacher {

    @Override
    public void teachSchool() {
        System.out.println("我是必须实现的方法");
    }




}
/**
 * 什么是接口：
 * 当一个抽象类，如果抽象类中的所有方法都是抽象的，那么我们就可以把它定义为一个接口，接口是对行为的抽象。类是对属性和行为的抽象。接口中没有属性的。
 * interface 接口名
 * {
 * public void[返回类型] 方法名();
 * }
 * 1.1接口的特点
 * 1.接口中的方法的定义不需要Abstract来修饰，默认就是抽象的
 * 2.接口是不可以实例化的，需要有类来实现接口实现接口的语法：
 * class 类名	implements 接口名，接口名,…{
 * //实现每一个接口中的方法
 * }
 * 一个类实现一个接口就必须要实现这个抽象类中的所有抽象方法。
 * 3.接口中的方法不能和private，static和final共存
 * 4.在接口中可以定义“属性“，可以通过接口的实现类的实例来访问，还可以通过接口名来访问（推荐大家	使用），
 * 接口中的属性不能修改，我们接口中的属性默认都是final static 的，
 * 通常在接口中来定义	属性把它作为常量，常量的名字规范是单词大写，而且多个单词之间用下划线来分隔。比如：	FILE_PATH
 * 5.接口可以继承接口， 可以多继承
 **/


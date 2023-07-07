package A18_彻底玩转单例模式_多线程下问题;


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.atomic.AtomicIntegerArray;

public class A02_反射破坏单例模式 {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Singleton1 singleton = Singleton1.getSingleton();
       // System.out.println(singleton);
        /**通过反射获取单例的构造器*/
        Constructor<Singleton1> declaredConstructor = Singleton1.class.getDeclaredConstructor(null);
        /**破坏单例*/
        declaredConstructor.setAccessible(true);
        /**通过反射创建对象*/
        Singleton1 singleton1 = declaredConstructor.newInstance();
       // System.out.println(singleton1);




    }


}

class Singleton1 {

    /**
     * 定义一个当前类的属性
     */
    static volatile Singleton1 singleton1;


    /**
     * 构造器的初始化
     */
    private Singleton1() {
        synchronized (Singleton1.this) {
            if (singleton1 != null) {

                System.out.println(new RuntimeException("不要使用反射来破坏单例"));
            }
        }

    }

    /**
     * 创建一个公有的方法返回一个Singleton这个类的对象的实例
     */
    public static  Singleton1 getSingleton() {
        /**判断singleton是否为空*/
        if (singleton1 == null) {
            /**双重检测锁模式*/
            synchronized(Singleton.class){
                if (singleton1 == null) {
                    /**为空就创建对象,,不是原子性操作,要把对象变成volatile,不能指令重排
                     *分配内存室间
                     * 执行构造方法，初始化对象
                     * 把这个对象指向这个空间
                     * */
                    singleton1 = new Singleton1();
                }


            }



        }
        /**返回对象*/
        return singleton1;
    }


}
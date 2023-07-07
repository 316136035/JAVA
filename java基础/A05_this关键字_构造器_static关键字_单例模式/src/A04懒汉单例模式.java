public class A04懒汉单例模式 {

    public static void main(String[] args) {
        /**打印的地址this是一样,所以是同一个对象*/
        Singleton singleton = Singleton.getSingleton();
        System.out.println(singleton);
        Singleton singleton1 = Singleton.getSingleton();
        System.out.println(singleton1);

    }


}

class Singleton {

    /**
     * 定义一个当前类的属性
     */
    static Singleton singleton;


    /**
     * 构造器的初始化
     */
    private Singleton() {
        System.out.println(this);
    }

    /**
     * 创建一个公有的方法返回一个Singleton这个类的对象的实例
     */
    public static Singleton getSingleton() {
        /**判断singleton是否为空*/
        if (singleton == null) {
            /**为空就创建对象*/
            singleton = new Singleton();
        }
        /**返回对象*/
        return singleton;
    }


}
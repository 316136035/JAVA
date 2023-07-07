package A18_彻底玩转单例模式_多线程下问题;



public class A01懒汉单例模式 {

    public static void main(String[] args) {

        for (int i = 0; i < 20; i++) {

            new Thread(()->{
                System.out.println(Singleton.getSingleton());
            }).start();
        }

    }


}

class Singleton {

    /**
     * 定义一个当前类的属性
     */
    static volatile Singleton singleton;


    /**
     * 构造器的初始化
     */
    private Singleton() {
        System.out.println(this);
    }

    /**
     * 创建一个公有的方法返回一个Singleton这个类的对象的实例
     */
    public static  Singleton getSingleton() {
        /**判断singleton是否为空*/
        if (singleton == null) {
            /**双重检测锁模式*/
            synchronized(Singleton.class){
                if (singleton == null) {
                    /**为空就创建对象,,不是原子性操作,要把对象变成volatile,不能指令重排
                     *分配内存室间
                     * 执行构造方法，初始化对象
                     * 把这个对象指向这个空间
                     * */
                    singleton = new Singleton();
                }


            }



        }
        /**返回对象*/
        return singleton;
    }


}
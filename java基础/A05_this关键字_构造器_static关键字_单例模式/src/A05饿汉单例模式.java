public class A05饿汉单例模式 {
    public static void main(String[] args) {

        /**打印的地址this是一样,所以是同一个对象*/
        SingletonText singleton1 = SingletonText.getSingleton1();
        System.out.println( singleton1);
        SingletonText singleton2 = SingletonText.getSingleton1();
        System.out.println(singleton2);




    }
}

class SingletonText {

  static   SingletonText SingletonText = new SingletonText();

    /**
     * 构造器的初始化
     */
    private SingletonText() {
        System.out.println(this);
    }

    /**
     * 创建一个公有的方法返回一个Singleton这个类的对象的实例
     */
    public static SingletonText getSingleton1() {
        return SingletonText;
    }


}
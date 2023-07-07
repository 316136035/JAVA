public class A04匿名对象 {
    String name;
    int age;

    public static void main(String[] args) {
        /**只能赋值一个,所以开发的时候尽量避免使用匿名对象
         * 匿名对象就是没有栈中的引用的对象，这种对象很快就会被gc（垃圾回收器）回收掉。*/
        new A04匿名对象().name = "name";


    }

    public void sleep() {
        System.out.println("正在睡觉");

    }
}

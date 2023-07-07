class Ppp {
    int a;
    int b;

    public void met(int a, int b) {
        System.out.println(a + b);

    }

}

class Java extends Ppp {


    /**
     * 重写的父类的方法
     */
    public void met(int a, int b) {
        System.out.println(a - b);

    }
}


public class A01方法的重写 {
    /**
     * 在子类继承父类时，
     * 子类的方法和父类的方法相同（访问修饰限制符，返回值类型，方法名，参数列表)，方法体不同。
     * 这种子类的方法将父类的方法覆盖叫做重写。
     * <p>
     * 重写和重载的区别:。
     * 重写( override):在父子类的继承中有相同的方法，唯一不同就是方法体，一般是父类的该方法满足不了子类的需求所以才发生重写。·
     * <p>
     * 重载（ overload):重载是在同一个类中，有着相同的方法名但是参数的数据类型或
     * 者参数的个数不同这两个方法就是重载。重载的目的:节省类中的命名资源和提高代码的可读性。.
     */
    public static void main(String[] args) {
        Java java = new Java();
        /**在这里只能调用子类的met，不能调用父类的met*/
        java.met(10, 20);


    }
}

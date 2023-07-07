public class A02方法的重载 {
    public static void main(String[] args) {

        /**在同一个类中函数（方法）名字，参数列表不一样（1参数个数不一样，或者对应索引位类型不一样）的两个方法是重载关系，
         * 跟返回值一点关系没有。
         目的：为了节约方法的功能命名和提高代码的可读性。*/

        System.out.println(add(1, 2));
        System.out.println(add(1, 2));
        System.out.println(add(1, 2, 3));

    }

    public static int add(int a ,int b) {


        return a+b;
    }
    public static long add(long a ,int b) {


        return a+b;
    }


    public static int add(int a ,int b ,int c) {


        return a+b+c;
    }


}

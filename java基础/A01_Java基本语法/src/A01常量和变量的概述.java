public class A01常量和变量的概述 {
    public static void main(String[] args) {
        变量();
        常量();
    }

    public static void 变量() {
// 程序在运行期间，不断发生变化的量就是变量-
        int intint = 100;
        for (int i = 0; i <= intint; i++) {
            System.out.println(i);
        }
    }

    public static void 常量() {
// 程序在运行期间，不能发生变化的量就是常量
      /*生活中的常量:
整数的常量:24小时，12月，60秒小数常量:重力系数9.8，圆周率3.14.字符串常量:“旺财”，
布尔类型的常量: true， false
，*/
        final double PI = 3.14;
        System.out.println(" 程序在运行期间，不能发生变化的量就是常量");
    }

}

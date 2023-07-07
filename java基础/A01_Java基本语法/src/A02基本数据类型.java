public class A02基本数据类型 {
    public static void main(String[] args) {
        整数类型();
        小数类型();
        字符类型();
        布尔类型();

    }

    public static void 整数类型() {
     /* byte(-128到127)
        <short(-32768到32767)
        <int(-2147483648到 2147483647)
        <long( -9223372036854775808到9223372036854775807)*/
        //定义一个byte类型
        byte byte1 = 10;
        //定义一个short类型
        short short1 = 32767;
        //定义一个int类型
        int int1 = 2147483647;
        //定义一个 long类型要就加上l
        long long1 = 9223372036854775807l;
        System.out.println("byte和short计算时产生的结果默认是int类型" + byte1 + "  " + short1 + "  " + int1 + "  " + long1);
    }


    public static void 小数类型() {
        /*float(单精度小数)<double(双精度小数)*/
        //定义一个 float类型要就加上f
        float float1 = 3.1f;
        //定义一个 double1类型
        double double1 = 0.1111111;
    }

    public static void 字符类型() {
        // 字符类型只能存放一个字符
        char char1 = '周';

    }

    public static void 布尔类型() {
        boolean b1 = true;
        boolean b2 = false;


    }
}

public class A05基本数据类型的强制转换 {
    public static void main(String[] args) {
        /*强制转换
         *当大容量类型的变量向小容量的类型去转换需要强制转换。语法:（目标类型）值
         *  */

//       数值类型的转换的前提是精度不会损失
        int int1 = 99;
        byte byte1 = (byte) 99;
        short short1 = (short) 99;
        char char1 = (char) 99;
        System.out.println(byte1);
        System.out.println(short1);
        System.out.println(char1);
//      『/转换成int,小数转换成整数，就是把小数点去掉|
        double double1 = 99.99;
        int int2 = (int) double1;
        System.out.println(int2);

        float float2 = (float) double1;
        System.out.println(float2);


    }
}

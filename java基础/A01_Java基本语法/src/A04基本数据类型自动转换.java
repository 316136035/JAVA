public class A04基本数据类型自动转换 {
    public static void main(String[] args) {
        //byte，short , int，char，四种类型只要是发生计算都会自动的把结果提升成int类型
        byte byte1 = 12;
        short short1 = 99;
        int int1 = byte1 + short1;
        System.out.println(int1);
        //定义一个char类型，字符和int类型可以自动的转换  对ascii码对照表
        char char1 = 'a';
        int intchar = char1 + 1;
        System.out.println(intchar);

        /*byte---→>short--→int----一 long--→>float---→>double
        #int和int运算的时候不会有类型的提升
        *1.所有的byte类型和short类型和char值运算的时候都会提供成int类型，int最大值2147483647.
        *2.如果计算中一个操作数据类型是long，另一个数的空间小于等于long，那么结果就是long
        * 3.如果计算中一个操作数据类型是float，另一个数的空间小于等于float，那么结果就是float
        *4.如果计算中一个操作数据类型是double，另一个数的空间小于等于double，那么结果就是double
    *int long float,double自身来计算的时候没有类型的提升，如果超出范围了就会出现精度的损失 */

    }

}

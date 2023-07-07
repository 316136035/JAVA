public class A07运算符后加加和减减 {
    public static void main(String[] args) {
        //++、--给数值变量自身加1或减一
        int i = 0;
        i++;
//        这个++是运行后的结果
        System.out.println(" 这个++是运行后的结果" + i);
//        这个++是运行的时候不计算的结果
        System.out.println("这个++是运行后再进行的计算," + i++);
        System.out.println("这个++是运行后的结果," + i);

        int ii = 10;
        ii--;
        System.out.println(" 这个--是运行后的结果" + ii);
        System.out.println("这个--是运行后再进行的计算," + ii--);
        System.out.println("这个--是运行后的结果," + ii);

    }
}

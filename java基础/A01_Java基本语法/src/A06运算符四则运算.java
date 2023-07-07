public class A06运算符四则运算 {
    public static void main(String[] args) {

        //+，-，*，/  //%取余数
        int int1 = 11;
        int int2 = 22;
        int int12 = int1 + int2;
        System.out.println("int1 + int2加法" + int12);
        int int11 = int1 - int2;
        System.out.println("int1 - int2;减法" + int11);
        int int22 = int1 * int2;
        System.out.println("int1 * int2乘法" + int22);
        int int33 = int1 / int2;
        System.out.println("int1 / int2除法" + int33);

        //%取余数

        int ii = 10;
        int iii = 3;
        int i = ii % iii;
        System.out.println("余数" + i);


    }
}

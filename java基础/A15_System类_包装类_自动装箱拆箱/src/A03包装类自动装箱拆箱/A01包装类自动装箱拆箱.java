package A03包装类自动装箱拆箱;

public class A01包装类自动装箱拆箱 {
    public static void main(String[] args) {

        int i = 11;
        //包装类自动装箱
        Integer integer = i;


        //包装类自动拆箱
        int ii=new Integer(22);


        /**当自动装箱拆箱小于127 的话==比较的是值*/
        Integer i1=127;
        Integer i2=127;
        System.out.println(i1==+i2);

        /**当自动装箱拆箱大于127 的==话比较的是地址*/
        Integer i3=128;
        Integer i4=128;
        System.out.println(i3==i4);
        System.out.println(i3.equals(i4));









    }
}

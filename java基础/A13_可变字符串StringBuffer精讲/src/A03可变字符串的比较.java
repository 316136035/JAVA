public class A03可变字符串的比较 {

    public static void main(String[] args) {


        /**StringBuffer没有重写equals方法**/
        StringBuffer stringBuffer1 = new StringBuffer("stringBuffer");
        StringBuffer stringBuffer2 = new StringBuffer("stringBuffer");


        /**建议转换成String来比较*/
        boolean equals = stringBuffer1.equals(stringBuffer2);
        System.out.println( equals);


        System.out.println(stringBuffer1.toString().equals(stringBuffer2.toString()));


    }
}

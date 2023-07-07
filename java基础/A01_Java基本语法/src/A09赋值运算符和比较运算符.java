public class A09赋值运算符和比较运算符 {
    public static void main(String[] args) {
        /**赋值运算符
         * "=","+=","-=","*=","/=","%="  */
//        这是赋值运算符
        int i = 10;

        //+=同等于i = i + 10; 不会提升数据类型,四则运算是有类型的提升的
        i = i + 10;
        System.out.println(" i = i + 10;" + i);
        i += 10;
        System.out.println(" i +=10;" + i);

        System.out.println("=============" + i);
        //-=同等于i = i - 10; 不会提升数据类型,四则运算是有类型的提升的
        i = i - 10;
        System.out.println(" i = i - 10;" + i);
        i -= 10;
        System.out.println(" i -=10;" + i);

//     "*=","/=","%="  也是一样
        /**14.运算符只能比较数字
         比较运算符
         ==，!=,>,>=,<,<=
         ==
         等于
         !=不等于
         >大于
         >=大于等于
         <小于
         <=小于等于
         * */

        int int1 = 10;
        int int2 = 20;

        System.out.println(int1 == int2);
        System.out.println(int1 != int2);
        System.out.println(int1 < int2);
        System.out.println(int1 > int2);
        System.out.println(int1 <= int2);
        System.out.println(int1 >= int2);


    }
}

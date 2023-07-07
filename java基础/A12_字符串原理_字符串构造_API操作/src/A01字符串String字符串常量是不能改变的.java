public class A01字符串String字符串常量是不能改变的 {
    public static void main(String[] args) {
        /**基本数据类型的变量存储位置是在栈中,引用数据类型实例存储在堆里面,引用在栈中，.,
         * Null是针对于引用数据类型的，没有指向堆中任何对象的时候就是null，基本数据类型没有这个概念。·
         *
         * String:在String类中没有用来改变已有字符串中的某个字符的方法，
         * 由于不能改变一个java字符串中的某个单独字符，所以在JDK文档中称String类的对象是不可改变的。
         *
         * */

        char[] chars = {'我', '是', '中',  '国', '人'};
        String string = new String(chars);
        System.out.println(string + ":" + "字符串拼接:字符串常量是不能改变的，如果对字符串常量来拼接不是在原有的字符串常量上追加，而是新产生一个字符串。.");
        char[] chars1 = string.toCharArray();
        System.out.println(chars1);


    }
}

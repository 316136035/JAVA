import org.w3c.dom.ls.LSOutput;

public class A03数组的使用 {
    public static void main(String[] args) {
        /**数组的定义 (数组的定义只能是基本数据类型,索引是固定的)
         基本数据类型的变量都存储在栈中，栈的特点是存储空间小，但是存取速度快，先进后出。
         引用数据类型所占的空间比较大，存储在堆中，堆的特点，空间大，存取的速度比较慢。

         整数类型（byte, short, int, long）的默认值都是	0
         小数(float, double)的默认值都是					0.0
         布尔数据类型(boolean)的默认值是				false
         字符数据类型(char)的默认值是 					‘ ’

         数组定义的第一种方式:
         int[] arr = new int[8];
         arr是数组类型的变量（如果是引用数据类型习惯上叫引用）， new int[8]真正的数据数据存储在堆中，新创建的数据的每一个位置上的值都是其所属数据类型的默认值，数组的索引是从0开始。

         数组定义的第二种方式:
         语法：数据类型[] 数组变量名 = {值1， 值2，……}
         Int [] array = {12, 34, 56,…..};
         数组的长度由value的数量来决定

         数组的定义的第三种方式：
         语法：数据类型[] 数组变量名 = new 数据类型[]{值1，值2，值3，……}
         数组的长度由value的数量来决定
         */
        arr1();
        add2();
        add3();
    }

    /**创建数组第一种方式*/
    public static void arr1() {
        int[] ints = new int[10];//创建数组第一种方式
        for (int i = 0; i < ints.length; i++) {
            ints[i]=i+100;//设置数组索引的值
        }
        println( ints);

    }

    /**创建数组第二种方式*/
    public static void add2() {
        int[] ints = new int[]{0,1,2,3,4,5,6,7,8,9,10};//创建数组第二种方式

        println( ints);
    }
    /**创建数组第三种方式*/
    public static void add3() {
      char[] ints =  {'A','B','C','D'};//创建数组第三种方式
        for (char anInt : ints) {
            System.out.println(anInt);
        }


    }

    public static void println(int[] arr) {
        for (int i : arr) {
            System.out.println(i);
        }
    }

}

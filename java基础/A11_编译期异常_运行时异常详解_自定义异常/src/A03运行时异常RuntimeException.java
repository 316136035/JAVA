class T {
    String name;

    public void sleep() {
        System.out.println("睡觉");
    }
}


/**
 * RuntimeException 下面的子类全部是运行时异常
 */
public class A03运行时异常RuntimeException {
    public static void main(String[] args) {
        /**空指针异常 NullPointerException   对象没有办法引用*/
        T t = null;
        t.sleep();/**空指针异常**/
        /**数学异常*/
//        System.out.println(1/0);
        /**数组抛出以表示使用非法索引访问数组*/
//       int[] arr={1,2,3};
//      System.out.println(arr[4]);


    }
}

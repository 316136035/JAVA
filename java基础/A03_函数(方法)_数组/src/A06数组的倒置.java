public class A06数组的倒置 {
    public static void main(String[] args) {
        /**
         *获得中间索引: length/2 .
         *
         * 获得前半段的对称索引: length-1一i.
         * */

         int []  arr={999,454,684,1,61,684,54,684,561,8654,45};
        println( arr );
        System.out.println();
        数组的倒置(  arr);

        println( arr );
    }

    public static void 数组的倒置(  int []  arr) {
        for (int i = 0; i < arr.length/2; i++) {

            //获取前半段开始索引的值
            int BeginNum = arr[i];

            //获取后半段开始索引的值对应的值(赋值给前半段开始的索引的值)
            arr[i] =  arr[arr.length - 1 - i];

            //前半段开始索引的值赋值给后半段对应的值
            arr[arr.length - 1 - i]=BeginNum;


        }

    }

    public static void println( int []  arr) {
        for (int i : arr) {
            System.out.print(i+"    ");
        }
    }
}

public class A05冒泡排序 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4874, 48716565, 48, 484, 561, 81, 6, 789, 763, 168, 486, 1, 9864, 654};
        大_小排序(arr );

        println( arr );
        System.out.println();
        小_大排序( arr );
        println( arr );



    }


    public static void 大_小排序(int[] arr) {
        /**外层是循环的是轮数*/
        for (int i = 0; i < arr.length - 1; i++) {
            /**内层是循环的每一轮比较的次数*/
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] < arr[j + 1]) {
                    /*定义一个变价*/
                    int ii = arr[j];
                    //赋值
                    arr[j] = arr[j + 1];
                    //赋值
                    arr[j + 1] = ii;}}}}

    public static void 小_大排序(int[] arr) {
        /**外层是循环的是轮数*/
        for (int i = 0; i < arr.length - 1; i++) {
            /**内层是循环的每一轮比较的次数*/
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    /*定义一个变价*/
                    int ii = arr[j];
                    //赋值
                    arr[j] = arr[j + 1];
                    //赋值
                    arr[j + 1] = ii;}}}}


    public static void println( int[] arr) {
        for (int i : arr) {
            System.out.print(i+"    ");
        }
    }

}

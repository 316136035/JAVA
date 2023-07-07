import java.util.Arrays;

public class A07二维数组 {
    public static void main(String[] args) {


        /**定义3列 4行的二维数组第一种写法*/
        int[][] arr = new int[3][4];
        arr[0][0] = 00;
        arr[0][1] = 01;
        arr[0][2] = 02;
        arr[0][3] = 03;


        arr[1][0] = 10;
        arr[1][1] = 11;
        arr[1][2] = 12;
        arr[1][3] = 13;

        arr[2][0] = 20;
        arr[2][1] = 21;
        arr[2][2] = 22;
        arr[2][3] = 23;
        println(arr);
        /**定义二维数组第二种写法*/
        int[][]  chararr={{1,2,3},{4,5,6},{7,8,9}};
        println( chararr);

    }
    /***打印二维数组 */
    public static void println( int[][] arr) {
        //遍历获取每一列的数据
        for (int i = 0; i < arr.length; i++) {
            //遍历获取每一行的数据
            for (int i1 = 0; i1 < arr[i].length; i1++) {
                //打印每一行的数据
                System.out.print(arr[i][ i1]+"  ");

            }
            System.out.println();

        }

    }
}

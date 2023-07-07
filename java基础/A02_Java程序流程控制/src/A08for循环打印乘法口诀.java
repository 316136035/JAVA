public class A08for循环打印乘法口诀 {
    public static void main(String[] args) {

        int ii=9;
        /**外层循环作为行*/
        for (int i = 0; i <=ii ; i++) {
            /**内层循环作为列*/
            for (int j = 1; j <=i ; j++) {
                System.out.print(j+"*"+i+"="+j*i+"  ");
            }
            System.out.println();

        }











    }
}

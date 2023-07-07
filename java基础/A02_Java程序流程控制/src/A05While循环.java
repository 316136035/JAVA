public class A05While循环 {
    public static void main(String[] args) {
        /**语法：while(表达式){
         循环体
         }*/

        /**打印1-100之间的偶数和*/
        int i = 0; //变量参数
        int ii=0;//结果集
        while (i <= 100) {
            if (i%2==0)//判断i是否位偶数
            {
               ii+=  i;
           }
            System.out.println(i);

           i++;//

        }
        System.out.println("结果集--偶数和"+ii);


    }
}

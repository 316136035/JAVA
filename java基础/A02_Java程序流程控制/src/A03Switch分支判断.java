public class A03Switch分支判断 {
    public static void main(String[] args) {
        /** swtich的表达式只能是byte, short, char, int, String*/
        switch分支判断(6);
        Switch应用();

    }

    public static void Switch应用() {
        /**
         打印指定年月的天数。
         2019	 8

         31 : 1 3 5 7 8 10 12
         30 : 4 6 9 11
         28 : 2月    平年
         29 ：2月		闰年 如果年可以被400整除	或者如果年可以被4整除但是不能被100整除是闰年

         */
        //定义年和月
        int year = 2024;
        int month = 2;
        //定义一个未知的变量值
        int day = -1;

        switch(month){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                day = 31;//跳出switch(如果没有break就会穿透执行，后面的case即使不匹配也会执行，知道遇到一个break才会跳出switch)
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                day = 30;
                break;//跳出switch
            case 2:
                if(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)){
                    day = 29;
                }else{
                    day = 28;
                }
                break;//跳出switch
            default:////当没有配对的就会执行下面代码
                System.out.println("月份不合理");
                break;
        }
        if(day != -1){
            System.out.println(year+"年"+month+"月有"+day+"天");
        }





    }


   /**	根据工资级别打印不同的☆

    工资的等级
    1			2				3				4

    ☆			☆☆			☆☆☆			☆☆☆☆*/
    public static void switch分支判断(int i) {

        switch (i){
            case  1 :
                System.out.println("*");
                break;//跳出switch(如果没有break就会穿透执行，后面的case即使不匹配也会执行，知道遇到一个break才会跳出switch)
            case  2 :
                System.out.println("**");
                break;//跳出switch
            case  3 :
                System.out.println("***");
                break;//跳出switch
            case  4 :
                System.out.println("****");
                break;//跳出switch
            case  5 :
                System.out.println("*****");
                break;//跳出switch

            default://当没有配对的就会执行下面代码
                System.out.println("我是没有配对的");
                break;//跳出switch
        }

        System.out.println("程序结束");


    }
}

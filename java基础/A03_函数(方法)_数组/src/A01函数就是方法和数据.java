public class A01函数就是方法和数据 {
    public static void main(String[] args) {

        /**方法是一段能完成独立功能的代码块。我们只需要写一次方法，可以被多次调用，提高了代码的复用性。
         * <public>  <static>  返回值类型[void]  方法名（[数据类型 变量名, 数据类型1 变量名1，…..]）{
         * 	//方法体
         * 	[return  结果值];
         * }
         * <public>  <static>:后续详解
         * 返回值类型[void]：方法给调用者返回的数据类型，如果方法没有返回值，我们就使用void
         * 如果方法的返回值是void，那么return;是代表程序的终止，如果方法要是有返回值那么就不能有return;
         * 方法名: 见名之意，使用驼峰模式来规范方法名：xxxYyyZzz
         * 参数列表：方法的参数可有可无，参数列表中可以有多个参数，先指定参数数据类型，再指定参数的变量名，多个参数用逗号分隔。
         * Return：在方法有返回值的情况，返回的具体数据, 程序的返回值的值一定要和返回值类型匹配
         *
         * */

        /*静态方法可以直接调用*/
        textText();
        /*静态方法可以直接调用*/
        int i = textText(5, 6);
        System.out.println(i);


    }

    /**
     * 没有返回值的方法
     */
    public static void textText() {

        System.out.println("没有返回值");
    }

    /**
     * 有返回值的方法
     */
    public static int textText(int a, int b) {

        return a > b ? a : b;
    }
}

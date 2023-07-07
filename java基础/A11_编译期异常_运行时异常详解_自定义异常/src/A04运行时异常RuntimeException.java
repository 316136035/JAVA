class Text {

    public static void Div(int i, int ii) {
        int i1 = 0;
        try {
            i1 = i / ii;
        } catch (Exception e) {
            e.printStackTrace();
            /**获取异常的信息*/
            System.out.println(e.getMessage());
        } finally {
            System.out.println("不能除0");
        }
        System.out.println(i1);
    }
}

public class A04运行时异常RuntimeException {
    public static void main(String[] args) {
        /**程序在运行的过程中可能发生的异常，在编译的时候不会报错。·,
         *如果一个方法发生异常，那么这个方法如果不处理这个异常，后面的代码无法执行，
         * 并且调用这个方法的方法后面的代码也不能执行。· */
        Text.Div(10, 0);
        System.out.println("程序运行完毕");


    }
}

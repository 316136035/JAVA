import java.util.Arrays;

public class A05运行时异常多个RuntimeException {
    public static void main(String[] args) {

        div(1, 0);
    }


    /**
     * ArithmeticException
     * ArrayIndexOutOfBoundsException
     */
    public static void div(int a, int b) {
        int i = 0;
        int[] attr = new int[0];
        try {
            i = a / b;
            attr = new int[]{1};
        } catch (ArithmeticException e) {
            if (e instanceof ArithmeticException){
                e.printStackTrace();/**算术异常*/
            }

        } catch (ArrayIndexOutOfBoundsException e) {
            if (e instanceof ArrayIndexOutOfBoundsException){
                e.printStackTrace();/**数组索引越界异常*/
            }


        } finally {
            System.out.println("最终也会执行这段代码");

        }
        System.out.println(Arrays.toString(attr));
        System.out.println(i);

    }
}

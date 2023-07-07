/**
 * 异常的自定义  可以用快捷键 ctrl+O
 */
class 自定义异常 extends RuntimeException {
    /**
     * Constructs a new runtime exception with {@code null} as its
     * detail message.  The cause is not initialized, and may subsequently be
     * initialized by a call to {@link #initCause}.
     */
    public 自定义异常() {
        super();
    }

    /**
     * Constructs a new runtime exception with the specified detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public 自定义异常(String message) {
        super(message);
    }
}

class Text1 {
    public static void buy(int count) {
        int stock=5;
        if (count > 5) {

            throw new 自定义异常("库存不足"+"当前库存为: "+ stock);
        }
        System.out.println("购买成功");
    }

}


public class A08自定义异常 {
    public static void main(String[] args) {
        /**由于我们实际的项目中很多业务需要跟项且相关的异常，所以我们要自己来定义异常。
         * 我们定义的都是运行时的异常。[-*/


        try {
            Text1.buy(6);
        } catch (Exception e) {
            //打印异常信息
            System.out.println(e.getMessage());
            e.printStackTrace();
        }


    }
}

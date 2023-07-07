public class A10逻辑运算符 {
    public static void main(String[] args) {
        /**&，|，&&, ||，*/

        //&并的意识

        /**&当有多个表达式是ture就是ture*/
        System.out.println(true & true);

        /**|当有一个表达式是ture就是ture*/
        System.out.println(false | true);

        /**&当有1个表达式是false就是false*/
        System.out.println(true & false);

        /**|当有2个表达式是false就是false*/
        System.out.println(false | false);

        /**&&当有1个表达式是false就是false*/   //当运行有一个是false就不远行了
        System.out.println(true & true && true & false);

        /**||当有1个表达式是true就是true*/  //当运行有一个是ture就不远行了
        System.out.println(true & true || true & false);


        /** 取反*/
        boolean bb = !true;
        System.out.println(bb);


    }
}

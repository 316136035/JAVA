import java.io.Serializable;

public class A04三元运算符 {
    public static void main(String[] args) {
        /**逻辑表达式2？表达式3(值)：表达式43(值)   ,
         * 三元运算符的结果是由表达式的结果的类型决定， 表达式三和表达式四结果类型要一致*/

        int i = 0;
        char c = i == 0 ? '男' : '女';
        System.out.println(c);

        /**如果分数大于等于90A， 如果大于等于60B， 小于60C*/
        int ii =1;
         /*(表达式)？（表达式/值）：（（表达式/值）？（表达式/值） ：（表达式/值）） */
        Serializable serializable = ii >= 90 ? 'A' : (ii >= 60 ? 'B' : "C");
        System.out.println(serializable);


    }
}

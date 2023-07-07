import java.util.Arrays;

public class A04字符串API的获取功能 {
    public static void main(String[] args) {
        String str = "我是中国人我是中国人1";
        /**获取字符串的长度*/
        System.out.println("取字符串的长度" + str.length());
        /**通过索引获取对应的字符*/
        System.out.println("通过索引获取对应的字符" + str.charAt(2));
        /**获取指定字符第一次出现的索引(也可以通过ascii表中的数字代表)*/
        System.out.println("获取指定字符第一次出现的索引" + str.indexOf("国"));
        System.out.println("获取指定索引出第一次(正着数)开始出现指定字符的索引" + str.indexOf("国", 3));

        /**获取指定字符第一次出现的索引(倒着数)*/
        System.out.println("获取指定字符(倒着数)第一次出现的索引" + str.lastIndexOf("国"));
        System.out.println("获取指定索引出第一次(倒着数)开始出现指定字符的索引3" + str.lastIndexOf("国", 8));

        /**获取字符串的十进制编码*/
        byte[] bytes = str.getBytes();
        System.out.println("获取字符串的十进制编码:*"+Arrays.toString(bytes));
        /**获取字符串的每一个char值*/
        char[] chars = str.toCharArray();
        System.out.println("获取字符串的每一个char值:"+Arrays.toString(chars));

        /**获取字符串截取*/
        String substring = str.substring(1);
        System.out.println(substring);
        String substring1 = str.substring(5, str.length());
        System.out.println(substring1);

        String substring2 = str.substring(str.indexOf("我"), str.length());
        System.out.println(substring2);

        /**数字和字节数组等转成字符串(重载的好多方法)*/
        char[] chars1 = {'a', 'B', 'c', 'd', 'e'};
        String value = String.valueOf('A');
        String value1 = String.valueOf(19);
        String value2 = String.valueOf(chars1);
        System.out.println(value2);
        /**字节数组等转成字符串并截取(数组,开始索引,截取长度)*/
        String value3 = String.valueOf(chars1, 2, 2);
        System.out.println(value3);


    }
}

import java.io.UnsupportedEncodingException;

public class A02字符串的构造器 {
    public static void main(String[] args) throws UnsupportedEncodingException {
        /**初始化新创建的 String对象，使其表示空字符序列。字符串是"", 不是null*/
        String string = new String();
        /**通过使用平台的默认字符集解码指定的字节数组来构造新的 String 。 */
        byte[] bytes = {97, 98, 99, 100, 101, 102, 103};
        char[] chars = {'我', '是', '中', '国', '人'};    /**这里的字符串一样有这种方法*/
        String string1 = new String(bytes);

        /**通使用平台的默认字符集解码指定的字节数组来构造新的 String 。 */
        System.out.println(string1 + ":使用平台的默认字符集解码指定的字节数组来构造新的 String");

        /**使用平台指定字符编码来指定的字节数组来构造新的 String*/
        String string2 = new String(bytes, "UTF-8");
        System.out.println(string2 + ":使用平台指定字符编码来指定的字节数组来构造新的 String");

        /**使用平台指定字符编码来指定的字节数组来构造新的 (数组,offset是开始索引,length是要截取的长度)*/
        String string3 = new String(bytes, 0, 5);
        System.out.println(string3 + ":使用平台指定字符编码来指定的字节数组来构造新的 (数组,offset是开始索引,length是要截取的长度)");


    }
}







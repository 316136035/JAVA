package A03编码的讲解;


import java.io.*;
import java.util.Arrays;

public class A01字符串的编码解码 {
    public static void main(String[] args) throws UnsupportedEncodingException {

        String  str="中国人";
        byte[] GBKbytes = str.getBytes("GBK");
        System.out.println(Arrays.toString( GBKbytes ));
        System.out.println(new String(GBKbytes, "GBK"));


        byte[] UTF8bytes = str.getBytes("UTF-8");
        System.out.println(Arrays.toString( UTF8bytes));
        System.out.println(new String(UTF8bytes, "UTF-8"));


        try {
            /**创建IO字符流通向字节流的桥梁 OutputStreamWriter 写 指定编码*/
            new OutputStreamWriter(new FileOutputStream("新文件.txt"),"UTF-8");
            /**创建IO字符流通向字节流的桥梁 OutputStreamWriter 读 指定编码*/
            new InputStreamReader(new FileInputStream("新文件.txt"),"UTF-8");


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

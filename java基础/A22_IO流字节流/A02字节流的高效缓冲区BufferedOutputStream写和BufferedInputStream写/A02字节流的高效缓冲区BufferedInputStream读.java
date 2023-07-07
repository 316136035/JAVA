package A02字节流的高效缓冲区BufferedOutputStream写和BufferedInputStream写;


import java.io.*;

public class A02字节流的高效缓冲区BufferedInputStream读 {
    public static void main(String[] args) {
        /**获取项目绝对路径*/
        String property = System.getProperty("user.dir");
        /**创建高效缓冲字符流BufferedReader读取对象*/

        OutputStream outputStream=null;
        /**创建File文件对象,并不是创建文件*/
        File file = new File(System.getProperty("user.dir") + ".\\新文件.txt");
        BufferedInputStream bufferedInputStream=null;

        try {
            /***创建字节流的高效缓冲区BufferedInputStream读*/
            bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            /**定义数组的长度*/
           int i=-1;
            /**定义一个数据存放读取的内容*/
            byte[] bytes = new byte[1024];
            /**判断是否有下一组数组*/
            while ( (i= bufferedInputStream.read( bytes))!=-1){
                /**byte数组转String字符串(数组,开始索引,结束索引,编码)*/
                String s = new String(bytes ,0,i, "utf-8");
                System.out.println(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bufferedInputStream!=null){
                try {
                    bufferedInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}

package A02字节流的高效缓冲区BufferedOutputStream写和BufferedInputStream写;

import java.io.*;

public class A03字节流的高效缓冲区拷贝文件 {
    public static void main(String[] args) {
        BufferedInputStream bufferedInputStream=null;
        BufferedOutputStream bufferedOutputStream=null;

        /**获取项目绝对路径*/
        String property = System.getProperty("user.dir");
        /**创建高效缓冲字符流BufferedReader读取对象*/
        OutputStream outputStream=null;
        /**创建File文件对象,并不是创建文件*/
        File file读 = new File(System.getProperty("user.dir") + ".\\新图片.png");


        /**创建File文件对象,并不是创建文件*/
        File file写 = new File(System.getProperty("user.dir") + ".\\复制出的文件.png");


        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(file读));
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file写));


            /**定义数组的长度*/
            int i=-1;
            /**定义一个数据存放读取的内容*/
            byte[] bytes = new byte[1024];
            /**判断是否有下一组数组*/
            while ( (i= bufferedInputStream.read( bytes))!=-1){
                bufferedOutputStream.write(bytes ,0,i);
                bufferedOutputStream.flush();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {

        }


    }
}

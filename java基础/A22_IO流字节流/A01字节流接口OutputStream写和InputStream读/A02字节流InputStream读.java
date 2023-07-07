package A01字节流接口OutputStream写和InputStream读;

import java.io.*;
import java.util.Arrays;

public class A02字节流InputStream读 {
    public static void main(String[] args) {
        /**获取项目绝对路径*/
        String property = System.getProperty("user.dir");
        /**创建高效缓冲字符流BufferedReader读取对象*/

        InputStream inputStream=null;
        /**创建File文件对象,并不是创建文件*/
        File file = new File(System.getProperty("user.dir") + ".\\新文件.txt");
        try {
            /**创建   inputStream字节流的实现类 -----付给父类引用*/
            inputStream=new FileInputStream(file);
            /**定义数组的长度*/
            int i=-1;
            /**定义一个数据存放读取的内容*/
            byte[] bytes = new byte[1024];
            /**判断是否有下一组数组*/
            while ( (i=inputStream.read( bytes))!=-1){
                /**byte数组转String字符串(数组,开始索引,结束索引,编码)*/
                String s = new String(bytes ,0,i, "utf-8");
                System.out.println(s);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (inputStream!=null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }




    }
}

package A02高效缓冲字符流BufferedWrite写和BufferedReader读;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class A02高效缓冲字符流BufferedReader读 {
    public static void main(String[] args) {
        BufferedReader bufferedReader=null;
        try {
            /**创建2高效缓冲字符流BufferedReader读取对象*/
            bufferedReader = new BufferedReader(new FileReader(System.getProperty("user.dir") + "//新文件.txt"));
            /**判断是否有下一个行*/
          while ( bufferedReader.ready()){
              /**读取每一行*/
              String s = bufferedReader.readLine();
              System.out.println(s);
          }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            /**关闭外层的对象时候,内层的资源对象也会自动关闭*/
            if ( bufferedReader!=null){
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }



    }
}

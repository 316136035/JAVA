package A01字节流接口OutputStream写和InputStream读;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class A01字节流OutputStream写 {
    public static void main(String[] args) {
        /**获取项目绝对路径*/
        String property = System.getProperty("user.dir");
        /**创建2高效缓冲字符流BufferedReader读取对象*/

        OutputStream outputStream=null;
        /**创建File文件对象,并不是创建文件*/
        File file = new File(System.getProperty("user.dir") + ".\\新文件.txt");

        try {
            /**判断文件是否存在*/
            if ( !file.exists()){
                /**不存在文件就创建*/
                file.createNewFile();
            }
            /**创建文件字节流FileOutputStream写付给字节流OutputStream应用 (file对象,ture代表追加文本)*/
            outputStream=new FileOutputStream(file,true);

            /**ascii码表*/
            for (int i = 0; i <10 ; i++) {
                /**内容直接写入文件*/
                outputStream.write(new byte[]{65,66,68,68,69});
                /**不flush();*/

            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if ( outputStream!=null){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }



        }
    }
}

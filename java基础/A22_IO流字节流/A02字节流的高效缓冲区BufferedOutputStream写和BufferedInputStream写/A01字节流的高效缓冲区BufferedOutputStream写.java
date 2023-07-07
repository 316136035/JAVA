package A02字节流的高效缓冲区BufferedOutputStream写和BufferedInputStream写;

import java.io.*;

public class A01字节流的高效缓冲区BufferedOutputStream写 {
    public static void main(String[] args) {
        /**获取项目绝对路径*/
        String property = System.getProperty("user.dir");
        /**创建高效缓冲字符流BufferedReader读取对象*/

        OutputStream outputStream=null;
        /**创建File文件对象,并不是创建文件*/
        File file = new File(System.getProperty("user.dir") + ".\\新文件.txt");
        BufferedOutputStream bufferedOutputStream=null;
        /**判断文件是否存在*/
        try {
            if ( !file.exists()){
                /**不存在文件就创建*/
                file.createNewFile();
            }
            /***创建字节流的高效缓冲区BufferedOutputStream写*/
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file,true));
            for (int i = 0; i <10 ; i++) {
                /**使用字节流的高效缓冲区BufferedOutputStream写入进缓存区*/
                bufferedOutputStream.write(new byte[]{65,66,68,68,69});
                /**刷新清空缓存区，把内容写入到文件中*/
                bufferedOutputStream.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {if (bufferedOutputStream!=null){
            try {
                bufferedOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        }


    }
}


import java.io.*;

public class A01字符流通向字节流的桥梁_OutputStreamWriter写 {
    public static void main(String[] args) {
        /***字符流通向字节流的桥梁------就是操作字符转成字节来处理*/


        /**获取项目绝对路径*/
        String property = System.getProperty("user.dir");

        /**创建File文件对象,并不是创建文件*/
        File file = new File(System.getProperty("user.dir") + ".\\新文件.txt");
        OutputStreamWriter outputStreamWriter = null;
        try {
            /**判断文件是否存在*/
            if (!file.exists()){
                /**不存在文件就创建*/
                file.createNewFile();
            }
            /**创建字符流通向字节流的桥梁_OutputStreamWriter写*/
            outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file ,true),"UTF-8");
            for (int i = 0; i <= 10; i++) {
                /**内容写入到缓存区*/
                outputStreamWriter.write("我是中国人");
                outputStreamWriter.write("\r\n");
                /**刷新清空缓存区，把内容写入到文件中*/
                outputStreamWriter.flush();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (  outputStreamWriter!=null){
                try {
                    outputStreamWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}

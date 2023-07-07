package A01_IO打印流PrintWriter;

import java.io.*;

public class A03IO打印流PrintWriter读取文件打印到控制台 {
    public static void main(String[] args) {
        /**获取项目绝对路径*/
        String property = System.getProperty("user.dir");
        /**创建File文件对象,并不是创建文件*/
        File file = new File(System.getProperty("user.dir") + ".\\新文件.txt");


        BufferedReader bufferedReader = null;
        PrintWriter printWriter = null;
        try {
            /**创建高效缓冲字符流BufferedReader读*/
            bufferedReader = new BufferedReader(new FileReader(file));
            /**创建打印流PrintWriter(输出流,自动刷新)*/
            printWriter = new PrintWriter(System.out,true);
            /**判断是否有下一行数据*/
            while (bufferedReader.ready()) {
                /**读取每一行*/
                String s = bufferedReader.readLine();
                /**打印到文件*/
                printWriter.println(s);

            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (printWriter != null) {
                printWriter.close();
            }
        }


    }
}

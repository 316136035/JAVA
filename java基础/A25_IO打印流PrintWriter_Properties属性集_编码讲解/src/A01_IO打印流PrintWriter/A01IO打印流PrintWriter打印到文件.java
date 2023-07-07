package A01_IO打印流PrintWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class A01IO打印流PrintWriter打印到文件 {
    public static void main(String[] args) {


        /**获取项目绝对路径*/
        String property = System.getProperty("user.dir");

        /**创建File文件对象,并不是创建文件*/
        File file = new File(System.getProperty("user.dir") + ".\\新文件.txt");


        PrintWriter printWriter=null;
        try {
            /**创建打印流PrintWriter*/
            printWriter = new PrintWriter(file);

            /**打印到文件*/
            printWriter.println("123456789");
            printWriter.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (printWriter !=null){
                printWriter.close();
            }
        }


    }
}

package A01字符流FileWrite写和FileReader读;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class A03使用字符流拷贝文件 {
    public static void main(String[] args) {

        FileReader fileReader = null;
        FileWriter fileWriter = null;
        try {
            /**创建File文件对象,并不是创建文件*/
            File file = new File(System.getProperty("user.dir"), "复制出的文件.txt");
            /**判断是否有这个文件*/
            if (file.exists()) {
                /**创建文件*/
                System.out.println(file.createNewFile());}
            /**创建字符流读取对象,*/
            fileReader = new FileReader(new File(System.getProperty("user.dir")+"\\新文件.txt"));
            /**创建字符流写入对象,*/
            fileWriter = new FileWriter(file );
            /**定义一个字符串数组**/
            char[] chars = new char[1024];
            /**定义读出来的长度*/
            int  len=-1;
            /**通过字符流读取对象 ,读取文件(没有数据就是-1)*/
            while ((len=fileReader.read(chars)) != -1) {
                /**内容写入到缓存区*/
                fileWriter.write(chars,0,len);
                /**刷新清空缓存区，把内容写入到文件中*/
                fileWriter.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if (fileWriter!=null){fileWriter.close();}
                if (fileReader!=null){fileReader.close();}

            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}

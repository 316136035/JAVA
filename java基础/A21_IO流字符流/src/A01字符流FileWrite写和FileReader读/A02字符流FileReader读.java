package A01字符流FileWrite写和FileReader读;

import java.io.File;

import java.io.FileReader;
import java.io.IOException;


public class A02字符流FileReader读 {
    public static void main(String[] args) {
        /**获取项目绝对路径*/
        String property = System.getProperty("user.dir");
        File file = new File(property, "新文件.txt");
        FileReader fileReader=null;
        /**定义一个字符串数组**/
        char[] chars = new char[1024];
        /**定义读出来的长度*/
        int  len=-1;
        try {
            /**创建字符流FileReader读取对象*/
            fileReader= new FileReader(file);
            /**通过字符流读取对象 ,读取文件(没有数据就是-1)*/
            while ( fileReader.read(chars)!=-1){
                /**字符数组转成字符串*/
                System.out.println(new String(chars,0,len ));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fileReader!=null){
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}

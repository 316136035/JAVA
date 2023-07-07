package A03文件_目录的获取功能;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class A01文件_目录的获取功能 {
    public static void main(String[] args) throws IOException {
        /**获取项目绝对路径*/
        String property = System.getProperty("user.dir");

        /**创建文件对象,并不是创建文件*/
        File file = new File(property);
        /**获取文件对象的绝对路径*/
        System.out.println("文件对象的绝对路径:"+file.getAbsolutePath());


        /**创建文件对象,并不是创建文件*/
        File file1 = new File("新文件.txt");
        /***相对路径创建文件(就是当前项目的路径)*/
        boolean newFile = file1.createNewFile();

        /**获取文件的相对路径(就是当前项目的路径)*/
        System.out.println("获取文件的相对路径:"+file1.getPath());

        /**获取文件名*/
        System.out.println("获取文件名:"+file1.getName());

        /**获取文件大小*/
        System.out.println("获取文件大小:"+file1.length());

        /**获取文件的最后修改时间*/
        long l = file1.lastModified();
        /**创建时间类格式化对象(年,月,日,时,分,秒,毫秒)*/
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy/MM/dd  HH:mm:ss   SSS ");
        String format = simpleDateFormat1.format(new Date(l));
        System.out.println("获取文件的最后修改时间:"+format);




    }
}

package A01文件_目录的构造器;

import java.io.File;

public class A01文件_目录的构造器 {
    public static void main(String[] args) {
        /**获取项目绝对路径*/
        String property = System.getProperty("user.dir");
        System.out.println(property+"//A20_文件处理_目录处理_File类");

       /**创建文件对象,并不是创建文件(文件路径)*/
        File file = new File(property);

        /**创建文件对象,并不是创建文件(文件路径,文件名)*/
        File file1 = new File(property,"file1.txt");

        /**Java中的File对象可以代表目录也可以代表文件*/
        File file2 = new File(property + "目录");

        /**根据File对象创建新的File对象*/
        File file3 = new File(file2, "新的File对象.txt");


    }
}

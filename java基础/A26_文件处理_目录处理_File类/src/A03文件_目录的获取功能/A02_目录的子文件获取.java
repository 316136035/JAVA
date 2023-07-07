package A03文件_目录的获取功能;

import java.io.File;
import java.util.Arrays;

public class A02_目录的子文件获取 {
    public static void main(String[] args) {
        /**获取项目绝对路径*/
        String property = System.getProperty("user.dir");

        /**获取盘符*/
        File[] files = File.listRoots();
        System.out.println(Arrays.toString(files));

        /***相对路径创建文件对象,并不是创建文件,就是当前项目的路径)*/
        File file = new File(property);
        /**获取目录中的全部子目录/文件的绝对路径*/
        File[] listFiles = file.listFiles();
        for (File file1 : listFiles) {
            System.out.println(file1);
        }
        /**获取目录中的全部子目录/文件的名字*/
        String[] list = file.list();
        System.out.println(Arrays.toString(list));




    }
}

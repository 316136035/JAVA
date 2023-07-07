package A02文件_目录的创建和删除;

import java.io.File;

public class A02文件_目录的删除 {
    public static void main(String[] args) {
        /**获取项目路径*/
        String property = System.getProperty("user.dir");
        删除文件( property);
        删除目录( property);
    }

    public static void 删除文件( String property) {
        /**创建文件对象,并不是创建文件*/
        File file = new File(property+"//新文件.txt");
        /**删除路径的最后一个文件*/
        boolean delete = file.delete();
        System.out.println("删除文件"+file+"  "+ delete );

    }

    public static void 删除目录( String property) {
        /**创建文件对象,并不是创建文件*/
        File file = new File(property+"//新目录");
        /**删除路径的最后一个目录(只有空目录才能删除)*/
        boolean delete = file.delete();
        System.out.println("删除目录"+file+"  "+ delete );

    }
}

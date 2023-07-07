package A04文件_目录的判断功能;

import java.io.File;

public class A01文件件_目录的判断功能 {
    public static void main(String[] args) {
        /**获取项目绝对路径*/
        String property = System.getProperty("user.dir");
         /**创建文件对象,并不是创建文件*/
        File file = new File(property);

        /**判断文件对象文件是否存在*/
        System.out.println("判断文件是否存在:"+file.exists());

        /**判断文件对象是否为文件*/
        System.out.println("判断是否为文件:"+file.isFile());

        /***判断文件对象为目录*/
        System.out.println("判断文件对象为目录:" +file.isDirectory());

        /**判断文件对象是否是绝对路径*/
        System.out.println("判断文件对象是否是绝对路径:"+file.isAbsolute());


        File file1 = new File(property + "\\新文件.txt");
        System.out.println(file1);
        /**判断文件对象是否可读**/
        System.out.println("判断文件对象是否可读:"+ file1.canRead());
        /**判断文件对象是否可写**/
        System.out.println("判断文件对象是否可写:"+ file1.canWrite());
        /**判断文件对象是否隐藏**/
        System.out.println("判断文件对象是否隐藏:"+ file1.isHidden());

    }
}

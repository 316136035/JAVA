package A05递归处理文件;

import java.io.File;

public class A02使用递归遍历全部文件 {
  /**定义文件层级*/
    static int level=0;
    public static void main(String[] args) {
        /**获取项目绝对路径*/
        String property = System.getProperty("user.dir");
        递归遍历全部文件("D:\\");
    }

    public static void 递归遍历全部文件(String property) {


        level++;
        /**创建文件对象,并不是创建文件*/
        File file = new File(property);
        /**获取目录下的子文件/目录*/
        File[] files = file.listFiles();
        /**遍历子文件/目录*/
        for (File file1 : files) {
            /**打印文件层级*/
            for (int i = 0; i <level; i++) {
                System.out.print("    ");
            }
            /**打印文件/目录名称*/
            System.out.println(file1.getName());
            /**判断file对象是否为目录*/
            if (file1.isDirectory()){
                /**递归调用*/
                递归遍历全部文件(file1.getAbsolutePath());
            }


        }
        level--;

    }
}

package A05递归处理文件;

import java.io.File;

public class A03递归删除文件和目录 {
    public static void main(String[] args) {
        递归删除文件和目录("D:\\天翼云盘下载");

    }

    public static void 递归删除文件和目录(String property) {
        /**创建文件对象,并不是创建文件*/
        File file = new File(property);
        /**获取目录下的子文件/目录*/
        File[] files = file.listFiles();
        /**遍历子文件/目录*/
        for (File file1 : files) {
            /**判断是否为目录*/
            if (file1.isDirectory()){
                递归删除文件和目录(file1.getAbsolutePath());
            }else {
                /**删除文件*/
                file1.delete();
            }

        }
        /**删除目录,包含天翼云盘下载目录也删除*/
        file.delete();


    }
}

package A02文件_目录的创建和删除;


import java.io.File;
import java.io.IOException;

public class A01文件_目录的创建 {
    public static void main(String[] args) throws IOException {
        /**获取项目绝对路径*/
        String property = System.getProperty("user.dir");
        创建文件(property );
        创建目录(property);
        创建多级目录 ( property);

        /***相对路径创建文件(就是当前项目的路径)*/
//        File file1 = new File("新文件.txt");
//        boolean newFile = file1.createNewFile();

    }

    public static void 创建文件( String property) {
        /**创建文件对象,并不是创建文件*/
        File file = new File(property,"新文件.txt");
        /**判断文件是否存在*/
        if ( !file.exists()) {

            try {
                /**创建文件*/
                boolean newFile = file.createNewFile();
                System.out.println("文件是否创建:"+newFile);

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public static void 创建目录 ( String property){
        /**创建文件对象,并不是创建文件*/
        File file = new File(property, "新目录");
        /**创建目录*/
        boolean mkdir = file.mkdir();
        System.out.println("目录是否创建:"+mkdir);


    }
    public static void 创建多级目录 ( String property){
        /**创建文件对象,并不是创建文件*/
        File file = new File(property, "多级目录\\A\\B");
        /**创建目录*/
        boolean mkdir = file.mkdirs();
        System.out.println("创建多级目录:"+mkdir);


    }


}

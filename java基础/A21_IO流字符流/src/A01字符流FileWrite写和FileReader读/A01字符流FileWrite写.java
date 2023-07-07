package A01字符流FileWrite写和FileReader读;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 输出换行
 把文本写入文件中\n代表换行
 问题是不同的环境下换行的方式也不一样
 Windows: \r\n
 Linux:\n
 Mac:\r
 */

public class A01字符流FileWrite写 {
    public static void main(String[] args)  {
        /**获取项目绝对路径*/
        String property = System.getProperty("user.dir");
        File file = new File(property, "新文件.txt");

        FileWriter fileWriter=null;
        try {

            /**判断是否有这个文件*/
            if (!file.exists()){
                /**没有的话就创建*/
                boolean newFile = file.createNewFile();
                System.out.println(newFile);

            }

            /**创建FileWrite写入流
             * (文件对象/路径,ture追加文本的意思)*/
            fileWriter = new FileWriter(file ,true);
            for (int i = 0; i < 10; i++) {
                /**内容写入到缓存区*/
//                fileWriter.write(new char[]{'A','B','C','D'});
//                fileWriter.write("\r\n"); //换行符
//
//                fileWriter.write(new char[]{'W','F','G','H'},2,2);
//                fileWriter.write("\r\n");
//
//                fileWriter.write('Y');
//                fileWriter.write("\r\n");

                fileWriter.write("我是中国人");
                fileWriter.write("\r\n");

//                fileWriter.write("...写入字符串的一部分",3,3);
//                fileWriter.write("\r\n");

                /**判断缓存区文件大小来刷新*/
                if ( i%10==0){
                    /**刷新清空缓存区，把内容写入到文件中*/
                    fileWriter.flush();
                }


            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if ( fileWriter!=null){
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }





    }


}

package A02高效缓冲字符流BufferedWrite写和BufferedReader读;

import java.io.*;

public class A01高效缓冲字符流BufferedWrite写 {
    public static void main(String[] args) {
        /**获取项目绝对路径*/
        String property = System.getProperty("user.dir");
        /**创建文件对象,并不是创建文件(文件路径,文件名)*/
        File file = new File(property, "新文件.txt");
        BufferedWriter bufferedWriter = null;
        /**判断是否有这个文件*/
        if (!file.exists()) {
            /**没有的话就创建*/
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            /**创建高效缓冲字符流BufferedWrite写入对象*/
            bufferedWriter = new BufferedWriter(new FileWriter(file, true));
            for (int i = 0; i <= 100; i++) {
                /**内容写入到缓存区*/
//                 bufferedWriter.write(new char[]{'A','B','C','D'});
//                    bufferedWriter.newLine();//换行
//
//                 bufferedWriter.write(new char[]{'W','F','G','H'},2,2);
//                    bufferedWriter.newLine();//换行
//
//                  bufferedWriter.write('Y');
//                    bufferedWriter.newLine();//换行

                bufferedWriter.write("我是中国人" + Integer.valueOf(i));
                bufferedWriter.newLine();;//换行

//                bufferedWriter.write("...写入字符串的一部分",3,3);
//                bufferedWriter.newLine();;//换行

                /**判断缓存区文件大小来刷新*/
                if (i % 10 == 0) {
                    /**刷新清空缓存区，把内容写入到文件中*/
                    bufferedWriter.flush();
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            /**关闭外层的对象时候,内层的资源对象也会自动关闭*/
            if (  bufferedWriter!=null){
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}

package A02高效缓冲字符流BufferedWrite写和BufferedReader读;

import java.io.*;

public class A03高效缓冲字符流拷贝文件 {
    public static void main(String[] args) {

        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        try {
            /**创建File文件对象,并不是创建文件*/
            File file = new File(System.getProperty("user.dir"), "复制出的文件.txt");
            /**判断是否有这个文件*/
            if (file.exists()) {
                /**创建文件*/
                System.out.println(file.createNewFile());
            }


            /**创建2高效缓冲字符流BufferedReader读取对象*/
            bufferedReader = new BufferedReader(new FileReader(System.getProperty("user.dir") + "//新文件.txt"));
            bufferedWriter = new BufferedWriter(new FileWriter(file, true));


            /**判断是否有下一个行*/
            while (bufferedReader.ready()) {
                /**读取每一行*/
                String s = bufferedReader.readLine();
                /**内容写入到缓存区*/
                bufferedWriter.write(s);
                bufferedWriter.newLine();;//换行
                /**刷新清空缓存区，把内容写入到文件中*/
                bufferedWriter.flush();

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            /**关闭外层的对象时候,内层的资源对象也会自动关闭*/
            try {
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
                if (bufferedReader != null) {
                    bufferedReader.close();

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}

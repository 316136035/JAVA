package A01字节流接口OutputStream写和InputStream读;


import java.io.*;

public class A03使用字节流拷贝文件  {
    public static void main(String[] args) {
        /**获取项目绝对路径*/
        String property = System.getProperty("user.dir");
        /**创建File文件对象,并不是创建文件*/
        File file读 = new File(System.getProperty("user.dir") + ".\\新图片.png");

        /**创建File文件对象,并不是创建文件*/
        File file写 = new File(System.getProperty("user.dir") + ".\\复制出的文件.png");

        InputStream  inputStream=null;
        OutputStream outputStream=null;
        try {
            /**判断文件是否存在*/
            if (!file写.exists()){
                /**不存在文件就创建*/
                file写.createNewFile();
            }
            /**创建   inputStream字节流的实现类 -----付给父类引用*/
            inputStream = new FileInputStream(file读);
            /**创建文件字节流FileOutputStream写付给字节流OutputStream应用 (file对象,ture代表追加文本)*/
            outputStream = new FileOutputStream(file写);
            /**定义数组的长度*/
            int i=-1;
            /**定义一个数据存放读取的内容*/
            byte[] bytes = new byte[1024];
            /**判断是否有下一组数组*/
            while ((i=inputStream.read(bytes))!=-1){
                /**内容直接写入文件*/
                outputStream.write(bytes,0,i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if (outputStream!=null){outputStream.close();}
                if (inputStream!=null){inputStream.close();}
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

}

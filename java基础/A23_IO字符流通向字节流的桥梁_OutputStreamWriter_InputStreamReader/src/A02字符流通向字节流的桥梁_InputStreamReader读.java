import java.io.*;

public class A02字符流通向字节流的桥梁_InputStreamReader读 {
    public static void main(String[] args) {
        /***字符流通向字节流的桥梁------就是操作字符转成字节来处理*/



        /**获取项目绝对路径*/
        String property = System.getProperty("user.dir");
        /**创建File文件对象,并不是创建文件*/
        File file = new File(System.getProperty("user.dir") + ".\\新文件.txt");
        InputStreamReader inputStreamReader=null;
        try {
             inputStreamReader = new InputStreamReader(new FileInputStream(file),"UTF-8");

            /**定义数组的长度*/
            int i=-1;
            /**定义一个数据存放读取的内容*/
            char[] chars = new char[1024];
            /**判断是否有下一组数组*/
            while ( (i= inputStreamReader.read( chars))!=-1){
                /**byte数组转String字符串(数组,开始索引,结束索引)*/
                String s = new String(chars ,0,i);
                System.out.println(s);

            }} catch (Exception e) {
            e.printStackTrace();
        } finally {
            if ( inputStreamReader!=null){
                try {
                    inputStreamReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }


    }
}

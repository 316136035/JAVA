package A02__Properties持久的属性集;

import java.io.*;
import java.util.Properties;

public class A2_Properties持久的属性集读使用字节流读取 {
    public static void main(String[] args) {
        /**创建Properties持久的属性集*/
        Properties properties = new Properties();
        InputStream inputStream = null;
        try {
            /**通过相对路径获取字节流*/
            inputStream =new FileInputStream("text.properties");
            /**Properties持久的属性集加载字节流数据*/
            properties.load(inputStream);

            /**打印Properties持久的属性集*/
            System.out.println(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (inputStream!=null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }


    }
}

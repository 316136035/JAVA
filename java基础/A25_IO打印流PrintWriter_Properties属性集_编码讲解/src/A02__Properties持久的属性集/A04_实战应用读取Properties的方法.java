package A02__Properties持久的属性集;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class A04_实战应用读取Properties的方法 {
    /**
     * Properties一般放着src文件下
     */
    public static void main(String[] args) {

        InputStream inputStream = null;
        Properties properties = new Properties();
        try {
            inputStream = A04_实战应用读取Properties的方法.class.getClassLoader().getResourceAsStream("druid.properties");
            /** properties加载数据*/
            properties.load(inputStream);
            System.out.println(properties);
        } catch (IOException e) {

        }finally {
            if (inputStream !=null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

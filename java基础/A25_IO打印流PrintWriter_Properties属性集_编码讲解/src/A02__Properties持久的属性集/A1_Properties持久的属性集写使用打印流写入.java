package A02__Properties持久的属性集;


import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Properties;

/**
 * Properties 类表示了一个持久的属性集。Properties 可保存在流中或从流中加载。属性列表中每个键及其对应值都是一个字符串。
 *
 * 特点：
 * 1.继承于Hashtable，是线程安全的键值对存储结构
 * 2. Properties 可保存在流中或从流中加载
 * 3. 只能保存字符串的键值对。*/

public class A1_Properties持久的属性集写使用打印流写入 {
    public static void main(String[] args) {
        /**创建Properties持久的属性集*/
        Properties properties = new Properties();
        /**设置值*/
        properties.setProperty("A","A");
        properties.setProperty("B","B");
        properties.setProperty("C","C");
        /**获取值*/
        System.out.println(properties.getProperty("A"));
        PrintWriter printWriter = null;
        try {
            /**创建打印流(项目的相对路径)*/
           printWriter = new PrintWriter("text.properties");
            properties.store( printWriter,"注释");

//           /**使用Properties持久的属性集加载打印流数据*/
//            properties.list(printWriter);
//            /**刷新打印流数据*/
//            printWriter.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (   printWriter!=null){   printWriter.close();}
        }


    }




}

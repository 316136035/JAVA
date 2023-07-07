package A01_对象输出流ObjectOutputStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class A01_对象输出流ObjectOutputStream {
    public static void main(String[] args) {

        ObjectOutputStream objectOutputStream = null;
        try {
            /**创建对象输出流ObjectOutputStream（又叫序列化）
             * （必须对象要实现Serializable接口()）
             * 当对象重新修改没有办法反序列化，注意idea要设置自动生成serialVersionUID 看图）鼠标放在类名 ALT+ENTER）*/
            objectOutputStream = new ObjectOutputStream(new FileOutputStream("新文件.txt"));

            /**当有多个对象要序列化的时候要使用集合来存储*/
            List<Person> list = new ArrayList<Person>();
            list.add(new Person(1, "黄先生", 19));
            list.add(new Person(2, "周先生", 19));
            list.add(new Person(3, "廖先生", 19));

            /**objectOutputStream写入对象流list*/
            objectOutputStream.writeObject(list);
            /**刷新清空缓存区，把内容写入到文件中*/
            objectOutputStream.flush();


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }


    }
}

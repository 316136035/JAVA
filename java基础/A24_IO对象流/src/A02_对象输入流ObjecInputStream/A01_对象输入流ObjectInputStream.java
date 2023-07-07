package A02_对象输入流ObjecInputStream;

import A01_对象输出流ObjectOutputStream.Person;

import java.io.*;
import java.util.List;


public class A01_对象输入流ObjectInputStream {
    public static void main(String[] args) {

        ObjectInputStream  objectInputStream=null;
        try {

            /**创建对象输出流ObjectOutputStream（又叫反序列化）
             *  * （必须对象要实现Serializable接口()）
             * * 当对象重新修改没有办法反序列化，注意idea要设置自动生成serialVersionUID 看图  鼠标放在类名 ALT+ENTER*/
            objectInputStream  = new ObjectInputStream(new FileInputStream("新文件.txt"));

            /**反序列化读取对象(list)*/
            List<Person> list = (List<Person>) objectInputStream.readObject();
            /**遍历集合*/
            for (Person person : list) {
                System.out.println(person);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (objectInputStream!=null){
                try {
                    objectInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}

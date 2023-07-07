package 使用dom4j查询和XPath查询xml;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.net.URL;
import java.util.List;

public class 使用dom4j查xml {
    public static void main(String[] args) {
        //创建SAXReader解释器（就是dom4j提供的）
        SAXReader reader = new SAXReader();
//		reader.setValidation(true);
        URL path1 =使用dom4j查xml.class.getClass().getResource("");
        System.out.println(path1);
        Document doc=null;
        try {
            //获取xml的doc对象
             doc = reader.read("A05XML的作用程序的配置文件和数据交换和小型数据库/src/使用dom4j查询和XPath查询xml/person.xml");

            //获取doc对象的根节点
            Element rootElement = doc.getRootElement();
            //  获取doc对象的节点名称
            String name = rootElement.getName();
            System.out.println("根节点名称："+name);

            // 获取根节点下的全部叫person的节点
            List<Element> persons = rootElement.elements("person");
            //遍历全部节点
            for (Element person : persons) {
                //获取id的值
                String id = person.attributeValue("id");
                //获取gender的值
                String gender = person.attributeValue("gender");

                System.out.println(id+"--------"+gender);

                //获取person对象下的带有（name）element标签对象
                List <Element>names = person.elements("name");
                for (Element name1 : names) {
                    //获取doc对象的文本
                    String name2 = name1.getText();

                    System.out.println(name2);

                }


            }



        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }


}

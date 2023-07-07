package 使用dom4j查询和XPath查询xml;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.List;

public class 使用XPath查询xml {
    public static void main(String[] args) throws DocumentException {
        //创建SAXReader解释器（就是dom4j提供的）
        SAXReader Reader = new SAXReader();

        Document doc = null;

        //获取xml的doc对象
        doc = Reader.read("A05XML的作用程序的配置文件和数据交换和小型数据库/src/使用dom4j查询和XPath查询xml/person.xml");
        //获取xml的根节点
        Element root = doc.getRootElement();
        System.out.println(root.getName());

        //使用XPath方式查询全部名字
        List<Element>  list= root.selectNodes("/persons/person/name");
        for (Element element : list) {
            System.out.println(element .getText());
        }
        System.out.println("----------------使用XPath方式查询全部名字-----------------");

        //使用XPath方式查询全部名字
        List<Element> list1 = root.selectNodes("//name");
        for (Element element : list1) {
            System.out.println(element .getText());
        }
        System.out.println("------------使用XPath方式查询全部带有id属性的person----------------");

        //使用XPath方式查询全部带有id属性的person
        List<Element> list2 = root.selectNodes("//person[@id]");
        for (Element element : list2) {
            System.out.println(element.getName());
        }

        System.out.println("------------使用XPath方式查询全部带有id属性=\"只\"的person-------------------");
        //使用XPath方式查询全部带有id属性="只"的person
        List<Element> list3 = root.selectNodes("//person[@id='person2']");
        for (Element element : list3) {
            System.out.println(element.getName());
        }


    }
}

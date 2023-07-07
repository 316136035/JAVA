package A03Document获取元素;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;

public class A01Document获取元素 {
    public static void main(String[] args) throws IOException {
        /**
         1.根据id查询元素 getElementByld.
         2.根据标签获取元素getElementsByTag-
         3.根据class获取元素getElementsByClass
         4.根据属性获取元素getElementsByAttribute-
         * */


        //解析URL地址( URL地址,超时时间)返回Document对象
        Document document = Jsoup.parse(new URL("https://item.jd.com/67764008945.html"), 1000);
        // System.out.println(document);
        Element summary = document.getElementById("prom-mbuy");//获取id元素
        System.out.println(summary);

        Elements 标签 = document.getElementsByTag("dd");//获取全部获取标签
        for (Element element : 标签) {
            System.out.println(element.text());
        }

        Elements class1 = document.getElementsByClass("m m-aside pop-hot");//获取全部获取class
        for (Element element : class1) {
            System.out.println(element);
        }

        Element Attribute = document.getElementsByAttribute("data-url").first();////通过类型名获取
        System.out.println(Attribute);


    }
}

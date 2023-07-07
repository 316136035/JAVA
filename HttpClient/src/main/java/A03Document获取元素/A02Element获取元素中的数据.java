package A03Document获取元素;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.net.URL;


public class A02Element获取元素中的数据 {
    public static void main(String[] args) throws IOException {
        /**
         * 元素中获取数据。
         * 1.从元素中获取id-
         * 2.从元素中获取className.
         * 3.从元素中获取属性的值 attr-
         * 4从元素中获取所有属性 attributes-
         * 5.从元素中获取文本内容 text
         * */

        //解析URL地址( URL地址,超时时间)返回Document对象
        Document document = Jsoup.parse(new URL("https://item.jd.com/100032997370.html"), 1000);
        System.out.println(document);
        Element ById = document.getElementById("ttbar-home");//通过id获取到当前  Element
        System.out.println(ById.id());//通过当前Element获取id

        Element prommbuy = document.getElementById("prom-mbuy");//通过id获取到当前  Element
        System.out.println(prommbuy.absUrl("data-url"));//通过当前Element获取url


        Element ByClassfirst = document.getElementsByClass("user-item-bt").first();////通过class获取到当前Element
        System.out.println( ByClassfirst.className());//通过当前Element获取className

        System.out.println("---------------------------------------------------------------");
        Element ByClassfirst1 = document.getElementsByClass("p-img").first();////通过class获取到当前Element
        System.out.println(ByClassfirst1.attr("class"));//通过当前Element的class获取classvalve

        Element ByClassfirst2 = document.getElementsByClass("p-img").first();////通过class获取到当前Element
        Element ByTa = ByClassfirst2.getElementsByTag("a").first(); //通过当前Element获取a标签的当前Element
        System.out.println(ByTa);
        Element img = ByTa.getElementsByTag("img").first();//获取img标签的 Element
        System.out.println(img.attr("alt"));//获取img标签下key的valve
        Attributes attributes = ByTa.attributes();//通过当前Element获取到获取所有属性
        for (Attribute attribute : attributes) {System.out.println(attribute);}//





    }
}

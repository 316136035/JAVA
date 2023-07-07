package A03Document获取元素;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.net.URL;

public class A03select选择器获取元素 {
    public static void main(String[] args) throws Exception {

/**
 * Selector选择器概述.
 * tagname:通过标签查找元素，比如: span
 * #id:通过心查找元素，比如: # city_bj
 *.class:通过class名称查找元素，比如: .class_a-[attribute]
 * 利用属性查找元素，比如: [abc]
 *[attr=value]:利用属性值来查找元素，比如: [class=s_name]
 *
 * **/



        System.out.println("--------------------解析URL地址( URL地址,超时时间)返回Document对象----------------------");
        Document document = Jsoup.parse(new URL("https://item.jd.com/100032997370.html"), 1000);
        System.out.println(document);

        System.out.println("--------------------通过标签获取全部Element-------");
        Elements li标签 = document.select("li");
        System.out.println(li标签);

        System.out.println("--------------------通过ID获取全部Element-------");
        Elements  id = document.select("#logo-2014");//通过ID获取全部标签
        System.out.println(id );

        System.out.println("----------------通过class获取全部Element----------------");
        Elements classtext = document.select(".J-ql-iframe");//通过class获取全部标签
        System.out.println(classtext);

        System.out.println("----------------利用属性key获取全部Element-----------------");
        Elements keyElements  = document.select("[href]");
        for (Element keyElement : keyElements) {
            System.out.println(keyElement.absUrl("href"));
        }

        System.out.println("----------------利用属性key和valve获取全部Element-----------------");
        Elements keyvalveElements  = document.select("[class=ins abs]");
        System.out.println( keyvalveElements );


    }
}

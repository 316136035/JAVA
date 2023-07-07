package A03Document获取元素;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.net.MalformedURLException;
import java.net.URL;

public class A04select选择器组合使用 {
    public static void main(String[] args) throws Exception {
        System.out.println("--------------------解析URL地址( URL地址,超时时间)返回Document对象----------------------");
        Document document = Jsoup.parse(new URL("https://item.jd.com/100032997370.html"), 1000);
        System.out.println(document);

        /**Selector选择器组合使用
         * el#fid:元素+ID，比如:h3#city_bl
         * el.class:元素+class，比如:li.class_ael[attr]:元素+属性名，比如:span[abc]
         * 任意组合:比如: span[abc].s_name.
         *查找某个元素下子元素，比如: .city_con li
         * 查找 元素 > child:查找某个父元素下的直接子元素，比如:,.city_con > ul
         * 查找元素第一级（直接子元素）的ul，再找所有ul下的第一级liparent >*:查找某个父元素下所有直接子元素·
         * */
        System.out.println("-------------------元素+ID----------------------");
        Elements 元素和ID = document.select("a#InitCartUrl");
        System.out.println( 元素和ID);
        System.out.println("-------------------元素+class----------------------");
        Elements 元素和class = document.select("li.J-sortType-item");
        System.out.println(元素和class);
        System.out.println("-------------------元素+class+属性key+----------------------");
        Elements 元素和class和属性 = document.select("li.J-sortType-item[data-sorttype]");
        System.out.println( 元素和class和属性);
        System.out.println("-------------------元素+class+属性key+valve----------------------");
        Elements 元素和class和属性keyvalve = document.select("li.J-sortType-item[data-sorttype=5]");
        System.out.println(元素和class和属性keyvalve);
        System.out.println("-------------------------查找某个元素下子元素(记得有空格)---------------------------------");
        Elements lh_li = document.select(".lh li");
        for (Element element : lh_li) {
            System.out.println(element.select("img").attr("alt"));
        }

        System.out.println("-------------------------查找某个元素下的直接子元素（>）---------------------------------");
        Elements select = document.select(".tab-con .fore1 div > a ");
        for (Element element : select) {
            System.out.println(element);
        }
        System.out.println("----------查找元素第一级（直接子元素）的ul，再找所有ul下的第一级 >*:查找某个父元素下所有直接子元素·---------------------------------");
        Elements select1 = document.select(".quality-life > .quality-icon > li ");
        for (Element element : select1) {
            System.out.println(element);
        }

    }
}

package A02JsoupHTML解析器;


import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Jsoup解析URL {
    public static void main(String[] args) throws IOException {
        Jsoup解析URL();
        Jsoup解析字符串();
        Jsoup解析文件 ();

    }
    public static void Jsoup解析URL() throws IOException {
        //解析URL地址( URL地址,超时时间)返回Document对象
        Document document = Jsoup.parse(new URL("https://item.jd.com/67764008945.html"),1000);
        System.out.println(document);
        //Document对象获取标签
        Element title = document.getElementsByTag("title").first();
        System.out.println(title.text());
    }

    public static void Jsoup解析字符串 () throws IOException {
        //通过FileUtils文件工具类读取html文本
        String string = FileUtils.readFileToString(new File("E:\\java代码\\HttpClient\\FileUtils.txt"), "UTF-8");
        // Jsoup解析字符串
        Document document = Jsoup.parse(string);
        //Document对象获取标签
        Element title = document.getElementsByTag("title").first();
        System.out.println(title.text());

    }

    public static void Jsoup解析文件 () throws IOException {
        // Jsoup解析文件
        Document document = Jsoup.parse(new File("E:\\java代码\\HttpClient\\FileUtils.txt"), "UTF-8");
        //Document对象获取标签
        Element title = document.getElementsByTag("title").first();
        System.out.println(title.text());

    }

}

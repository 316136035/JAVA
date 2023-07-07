package A01httpclient;

import org.apache.http.*;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URLDecoder;

public class A04获取响应头AllHeaders {
    public static void main(String[] args) {
        //可以关闭的httpClient客户端，相当于一个浏览器；
        CloseableHttpClient HttpClient = HttpClients.createDefault();

        String str = "https://cd.jd.com/recommend?callback=handleComboCallback&methods=accessories&p=103003&sku=100035402990&cat=737%2C794%2C870&lid=1&uuid=1651814739189241837150&pin=%25E4%25BC%259F%25E5%25BD%25AC672&ck=pin%2CipLocation%2Catw%2Caview&lim=5&cuuid=1651814739189241837150&csid=122270672.10.1651814739189241837150%7C102.1652629287&_=1652630263484";
        //把字符串转成URLdecode
        String decode = URLDecoder.decode(str);
        //构造URI
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https");
        uriBuilder.setHost("cd.jd.com");
        uriBuilder.setPath("/recommend");
        uriBuilder.setParameter("callback", "handleComboCallback");
        uriBuilder.setParameter("methods", "accessories");
        uriBuilder.setParameter("p", "103003");
        uriBuilder.setParameter("sku", "100035402990");
        uriBuilder.setParameter("cat", "737,794,870");//"%2c等于",""
        uriBuilder.setParameter("lid", "1");
        uriBuilder.setParameter("uuid", "1651814739189241837150");
        uriBuilder.setParameter("pin", "%E4%BC%9F%E5%BD%AC672");
        uriBuilder.setParameter("ck", "pin,ipLocation,atw,aview");
        uriBuilder.setParameter("lim", "5");
        uriBuilder.setParameter("cuuid", "1651814739189241837150");
        uriBuilder.setParameter("csid", "122270672.10.1651814739189241837150|102.1652629287");
        uriBuilder.setParameter("_", "1652630263484");

        //改造httpGet请求对象(//解决httpclient被认为不是真人行为)
        HttpGet httpGet = new HttpGet(String.valueOf(uriBuilder));
        httpGet.addHeader(" Host", "cd.jd.com");
        httpGet.addHeader(" Connection", "keep-alive");
        httpGet.addHeader(" sec-ch-ua", "?0");
        httpGet.addHeader(" sec-ch-ua-mobile", "\" Not A;Brand\";v=\"99\", \"Chromium\";v=\"96\", \"Google Chrome\";v=\"96\"");
        httpGet.addHeader("  User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.110 Safari/537.36");
        httpGet.addHeader(" sec-ch-ua-platform", "Windows");
        httpGet.addHeader(" ccept", "*/");
        httpGet.addHeader(" Sec-Fetch-Site", "same-site");
        httpGet.addHeader(" Sec-Fetch-Mode", "script");
        httpGet.addHeader("Referer", "https://item.jd.com/");    ////防盗链,value:发生防益链的网站的url
        httpGet.addHeader(" Accept-Encoding", "gzip, deflate, br");
        httpGet.addHeader("  Accept-Language", "zh-CN,zh;q=0.9");

        //响应
        CloseableHttpResponse execute = null;
        try {
            //执行httpget请求
            execute = HttpClient.execute(httpGet);
            //获取响应状态
            StatusLine statusLine = execute.getStatusLine();
            //获取响应状态码
            System.out.println( statusLine.getStatusCode());
            //判断状态码是否是200
            if (HttpStatus.SC_OK==statusLine.getStatusCode()){
                //获取响应头内容
                Header[] allHeaders = execute.getAllHeaders();
                for (Header allHeader : allHeaders) {
                    System.out.println("响应头:"+allHeader.getName()+"响应内容:"+allHeader.getValue());
                }
                System.out.println("响应成功..");


                //获得响应实体类(HttpEntity不仅可以作为结果，也可以作为请求的参数实体，有很多的实现。)
                HttpEntity entity = execute.getEntity();
                //获取内容类型;
                Header contentType = entity.getContentType();
                System.out.println("获取内容类型:"+contentType);




                //使用 EntityUtils工具类 操作
                String string = EntityUtils.toString(entity, "UTF-8");
                //确保流关闭
                EntityUtils.consume(entity);
                System.out.println(string);
            }else {
                //获取响应状态码
                System.out.println( statusLine.getStatusCode());

            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (execute != null) {
                try {
                    execute.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }


    }

}

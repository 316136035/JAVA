package A01httpclient;

import org.apache.http.*;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URLDecoder;

public class A07设置请求配置ConnectTimeout和读取超时 {
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

        //改造httpGet请求对象(//解决httpclient被认为不是真人行为)
        HttpGet httpGet = new HttpGet(String.valueOf(uriBuilder));
        //代理IP和端口
        HttpHost httpHost = new HttpHost("119.130.109.227",8888);
        //对每一个请求配置(会覆盖全局的默认请求配置)
        RequestConfig requestConfig = RequestConfig.custom()
                .setProxy( httpHost) //设置代理IP
                .setConnectTimeout(1000)//当客户和服务器3次握手超过设置时间就会报错ConnectTimeoutException
                .setSocketTimeout(2000)// 表示从请求的服务器获得响应的数据时间间距   超过设置的时间就会报错SocketTimeoutException
                .setConnectionRequestTimeout(5000) //表现从连接池里面获取连接的超时时间
                .build(); //构造
        //设置代理配置
        httpGet.setConfig(requestConfig);

        //响应
        CloseableHttpResponse execute = null;
        try {
            //执行httpget请求
            execute = HttpClient.execute(httpGet);
            //获取响应状态
            StatusLine statusLine = execute.getStatusLine();
            //获取响应状态码
            System.out.println( statusLine);
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

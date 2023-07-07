package A01httpclient;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class HttpClient连接池 {
    public static void main(String[] args) throws URISyntaxException {

        PoolingHttpClientConnectionManager poolingHttpClient= new PoolingHttpClientConnectionManager();  //创建HttpClient连接池
        poolingHttpClient.setMaxTotal(200);//设置HttpClient连接池默认最大链接数
        poolingHttpClient.setDefaultMaxPerRoute(10);//设置每一个主机的最大链接数
        String str = "https://search.jd.com/Search?activity_id=200279424001";
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https");
        uriBuilder.setHost("search.jd.com");
        uriBuilder.setPath("/Search");
        uriBuilder.setParameter("activity_id","200279424001");
        URI build = uriBuilder.build();
        doGet(poolingHttpClient,build );
    }
    public static  void doGet( PoolingHttpClientConnectionManager poolingHttpClient,  URI  url) {
        HttpClientBuilder custom = HttpClients.custom();//构建自定义可以关闭的httpClient客户端，相当于一个浏览器；
        custom.setConnectionManager(poolingHttpClient);//添加HttpClient连接池
        CloseableHttpClient httpClient = custom.build();//构建成功
        HttpGet httpGet = new HttpGet( url);  httpGet.addHeader("User-Agent", " Mozilla/5.0 (Linux U; en-US)  AppleWebKit/528.5  (KHTML, like Gecko, Safari/528.5 ) Version/4.0 Kindle/3.0 (screen 600x800; rotate)");
        CloseableHttpResponse   execute =null;
        try {
            //执行httpget请求
             execute = httpClient.execute(httpGet);
            //获取响应状态
            StatusLine statusLine = execute.getStatusLine();
        if (statusLine.getStatusCode()== HttpStatus.SC_OK ){
            //获得响应实体类(HttpEntity不仅可以作为结果，也可以作为请求的参数实体，有很多的实现。)
            HttpEntity entity = execute.getEntity();
            //使用 EntityUtils工具类 操作
            String string = EntityUtils.toString(entity, "UTF-8");
            System.out.println(string );
            //确保流关闭
            EntityUtils.consume(entity);
        }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (  execute!=null){
                try {
                    execute.close();
                } catch (IOException e) {
                }
            }
        }

    }
}

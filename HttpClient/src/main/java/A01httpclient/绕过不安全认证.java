package A01httpclient;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.impl.cookie.BrowserCompatSpecFactory;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.TrustStrategy;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.net.URI;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

public class 绕过不安全认证 {
    public static void main(String[] args) throws NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        //创建HttpClient连接池并 构造https安全认证 （只能绕过不带https证书）
        PoolingHttpClientConnectionManager poolingHttpClient= new PoolingHttpClientConnectionManager( 配置httpclient绕过https安全认证());
        poolingHttpClient.setMaxTotal(200);//设置HttpClient连接池默认最大链接数
        poolingHttpClient.setDefaultMaxPerRoute(10);//设置每一个主机的最大链接数

        doGet( poolingHttpClient, "https://item.jd.com/100020524251.html");

    }

    public static Registry<ConnectionSocketFactory>  配置httpclient绕过https安全认证() throws NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        /**。通过认证需要的秘钥配置httpclient。* 配置httpclient绕过http/https安全认证**/
        Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory>create()
                .register("http", PlainConnectionSocketFactory.INSTANCE)
                .register("Https", getSSLConnectionSocketFactory())
                .build();

        return registry;
    }
    private  static  SSLConnectionSocketFactory   getSSLConnectionSocketFactory() throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException {
        SSLContextBuilder sslContextBuilder = new SSLContextBuilder();
       sslContextBuilder.loadTrustMaterial(null, new TrustStrategy() {
            @Override
            public boolean isTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
                return true;
            }
        });
        SSLContext sslContext= sslContextBuilder.build();
        SSLConnectionSocketFactory sslConnectionSocketFactory =
                new SSLConnectionSocketFactory(sslContext,new String[]{"SSLv2He11o" , "sSLv3","TLSv1", "TLSv1.1", "TLSv1.2"},null, NoopHostnameVerifier.INSTANCE);

        return sslConnectionSocketFactory;
    }

    public static  void doGet( PoolingHttpClientConnectionManager poolingHttpClient,  String url) {
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

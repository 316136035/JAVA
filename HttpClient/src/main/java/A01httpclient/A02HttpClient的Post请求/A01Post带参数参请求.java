package A01httpclient.A02HttpClient的Post请求;


import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import javax.swing.*;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class A01Post带参数参请求 {
    public static void main(String[] args) throws URISyntaxException, UnsupportedEncodingException {
        //可以关闭的httpClient客户端，相当于一个浏览器；
        CloseableHttpClient HttpClient = HttpClients.custom().setDefaultCookieStore( getCookieStore()).
                build();
        URIBuilder uriBuilder = new URIBuilder();//创建自定义URI对象
        List<NameValuePair> nameValuePairs = new ArrayList<>();//创建表单提交的List
        nameValuePairs.add(new BasicNameValuePair("表单key", "表单valve"));//表单存放数据
        nameValuePairs.add(new BasicNameValuePair("表单key", "表单valve"));//表单存放数据
        nameValuePairs.add(new BasicNameValuePair("表单key", "表单valve"));//表单存放数据
        nameValuePairs.add(new BasicNameValuePair("表单key", "表单valve"));//表单存放数据
        nameValuePairs.add(new BasicNameValuePair("表单key", "表单valve"));//表单存放数据
        UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(nameValuePairs,"UTF-8");//创建表单实体类 存放表单提交的List
        urlEncodedFormEntity.setContentEncoding(Consts.UTF_8.name());
        urlEncodedFormEntity.setContentType(ContentType.MULTIPART_FORM_DATA.toString());

        System.out.println(urlEncodedFormEntity);
        HttpPost httpPost = new HttpPost(uriBuilder.build()); //创建post请求
        httpPost.setEntity(urlEncodedFormEntity);//post请求设置表单实体类


        System.out.println("发送请求的信息:" + httpPost);
        httpPost.addHeader("User-Agent", " Mozilla/5.0 (Linux U; en-US)  AppleWebKit/528.5  (KHTML, like Gecko, Safari/528.5 ) Version/4.0 Kindle/3.0 (screen 600x800; rotate)");
        //响应
        CloseableHttpResponse execute = null;
        try {
            //执行httpget请求
            execute = HttpClient.execute(httpPost);
            //获得响应实体类(HttpEntity不仅可以作为结果，也可以作为请求的参数实体，有很多的实现。)
            HttpEntity entity = execute.getEntity();
            //使用 EntityUtils工具类 操作
            String string = EntityUtils.toString(entity, "UTF-8");
            //确保流关闭
            EntityUtils.consume(entity);

            System.out.println(string);


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

    public static CookieStore getCookieStore() {
        String  str="pin=8iB1TfFE; wskey=AAJiHzqvAEBDvInWTZesg3L4M5qCXnS6Hizf9RLbyUsWyDdmL5n8CPKepc6HWp1UkDoEmMfjKlwzyC0mRfnK4D7D-KptNoUO; pt_key=AAJiHzqwADBgEJXOWDvML4kvx1HjV9ifnCQ8t2FE2xeQvlrBjFCy-W0PKh6ymMLa8tMTc57Zk_k; unionwsws={\"devicefinger\":\"eidIc5f0812167s4fyoIoAQZTZyGNGu2A6nZcH8qCh9OFne588j9VFhU0KRXJuvllG5AEUZXFK9heiQTwGULA+CdNayflT2a49VqWRmWpGzx9mCIBJ53\",\"jmafinger\":\"eQ6d43Z4zyX9gpERV7o5XccL_gcYg4ZXD_AF_nLX7JjAYIbCIuULcpILNxrGMeUeshKF9oTrCHDaQQvZc4mHZVfBqsIWBaXgIoIqQvGqGGsI\"}";

        /**使用正则表达式替换字符串中的空格、回车、换行符、制表符*/
        Pattern p = Pattern.compile("\\s*|\t|\r|\n");
        Matcher matcher = p.matcher(str);
        String smatcher = matcher.replaceAll("");

        BasicCookieStore basicCookieStore = new BasicCookieStore();

        BasicClientCookie BasicClientCookie=null;
        String  key="";
        String  valve="";
        String[] split = smatcher.split(";");
        for (String s : split) {
            String[] split1 = s.split("=");
            for (int i = 0; i < split1.length; i++) {
                if (i==0){
                    key=split1[0];
                }
                if (i==1){
                    valve=split1[1];
                }
            }

            BasicClientCookie= new BasicClientCookie(key, valve);
            BasicClientCookie.setPath("/client.action");
            BasicClientCookie.setDomain("api.m.jd.com");
            basicCookieStore.addCookie( BasicClientCookie);



        }



        // BasicClientCookie Cookie = new BasicClientCookie();


        return basicCookieStore;
    }

}

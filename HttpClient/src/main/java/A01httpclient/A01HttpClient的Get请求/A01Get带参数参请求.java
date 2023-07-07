package A01httpclient.A01HttpClient的Get请求;


import com.alibaba.fastjson.JSONArray;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class A01Get带参数参请求 {
    public static void main(String[] args) throws URISyntaxException, MalformedURLException, UnsupportedEncodingException {
        String str = "https://www.hifini.com/thread-12073.htm";
        System.out.println("发送请求的信息:GET " + str);
        //构建一个关闭的httpClient客户端，相当于一个浏览器；
        HttpClientBuilder custom = HttpClients.custom();
        //实现浏览器；
        CloseableHttpClient build1 = custom.build();

        //构建自定义URI对象
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("http");
        uriBuilder.setHost("218.20.251.64:8080");
        uriBuilder.setPath("/tomcat1?");
        //uriBuilder.setParameter("","");  //设置url参数

        URI build = uriBuilder.build();
        //创建List<NameValuePair>对象
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        //List<NameValuePair>存放key和valve
        params.add(new BasicNameValuePair("skuIds", "100007022552"));
        params.add(new BasicNameValuePair("source", "company"));
        params.add(new BasicNameValuePair("ext", "1111111111"));
        params.add(new BasicNameValuePair("area", "1_2901_55548_0"  ));
        params.add(new BasicNameValuePair("origin", "4"));
        params.add(new BasicNameValuePair("pin", "伟彬672"));


        String URLEncoded = URLEncodedUtils.format(params, ContentType.APPLICATION_JSON.getCharset());//编译List<NameValuePair>对象

        String uribuilder = String.valueOf(uriBuilder.build());//实现Builder;

        String URLuribuilder = URLDecoder.decode(uribuilder, "UTF-8"); //使用URLDecoder编译Builder

        HttpGet httpGet = new HttpGet( URLuribuilder+URLEncoded);//创建 httpGet

        System.out.println("发送请求的信息:" + httpGet);
        //设置请求头
        httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US) AppleWebKit/534.7 (KHTML, like Gecko) Chrome/7.0.514.0 Safari/534.7)");
        //响应
        CloseableHttpResponse execute = null;
        try {
            //执行httpget请求
            execute = build1.execute(httpGet);
            //获得响应实体类(HttpEntity不仅可以作为结果，也可以作为请求的参数实体，有很多的实现。)

            HttpEntity entity = execute.getEntity();

            //使用 EntityUtils工具类 操作
            String string = EntityUtils.toString(entity, "UTF-8");
            //确保流关闭
            EntityUtils.consume(entity);

//            for (Header allHeader : execute.getAllHeaders()) {
//                System.out.println(allHeader);
//            }
            System.out.println(string);

            /**使用正则表达式替换字符串中的空格、回车、换行符、制表符*/
            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
            Matcher matcher = p.matcher(string);
            String s = matcher.replaceAll("");
            //"用正则表达式替换字符串中的空格、回车、换行符、制表符:
            System.out.println(s);
            // String substring = s.substring(s.indexOf("(")+1, s.lastIndexOf(")"));
            System.out.println(s);
            List<JsonRootBean> jsonRootBeans = JSONArray.parseArray(s, JsonRootBean.class);
            for (JsonRootBean jsonRootBean : jsonRootBeans) {
                System.out.println(jsonRootBean.getId());
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

/**
 * /**
 * Auto-generated: 2022-05-21 23:7:21
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
class JsonRootBean {

    private String p;
    private String ext;
    private String op;
    private String epp;
    private String cbf;
    private String id;
    private String up;
    private String m;

    public void setP(String p) {
        this.p = p;
    }

    public String getP() {
        return p;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public String getExt() {
        return ext;
    }

    public void setOp(String op) {
        this.op = op;
    }

    public String getOp() {
        return op;
    }

    public void setEpp(String epp) {
        this.epp = epp;
    }

    public String getEpp() {
        return epp;
    }

    public void setCbf(String cbf) {
        this.cbf = cbf;
    }

    public String getCbf() {
        return cbf;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setUp(String up) {
        this.up = up;
    }

    public String getUp() {
        return up;
    }

    public void setM(String m) {
        this.m = m;
    }

    public String getM() {
        return m;
    }

}
package A01httpclient.A02HttpClient的Post请求;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;


import java.io.IOException;

public class A02发送Json数据类型的post请求 {
    public static void main(String[] args) throws Exception {
//https://fts.jd.com/area/get?fid=4744
        String  str="https://fts.jd.com/area/get?fid=4744";
        HttpClientBuilder custom = HttpClients.custom();
        CloseableHttpClient build = custom.build();
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https");
        uriBuilder.setHost("fts.jd.com");
        uriBuilder.setPath("/area/get");
         uriBuilder.setParameter("fid","4744");
        HttpPost httpPost = new HttpPost( uriBuilder.build());
        httpPost.addHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.110 Safari/537.36");
        httpPost.addHeader("Host","fts.jd.com");
        JSONObject JSONObject = new JSONObject();


        JSONObject.put("fid", "4744");
        StringEntity jsonEntity = new StringEntity( JSONObject.toJSONString(), Consts.UTF_8);
        jsonEntity.setContentType(ContentType.APPLICATION_JSON.toString());
        jsonEntity.setContentEncoding(new BasicHeader("ContentType","APPLICATION/JSON"));

        System.out.println(JSONObject.toJSONString());
        httpPost.setEntity( jsonEntity);


        //响应
        CloseableHttpResponse execute=null;
        try {
            //执行httpget请求
            execute = build.execute(httpPost);
            //获得响应实体类(HttpEntity不仅可以作为结果，也可以作为请求的参数实体，有很多的实现。)

            HttpEntity entity = execute.getEntity();
            //使用 EntityUtils工具类 操作
            String string = EntityUtils.toString(entity, "UTF-8");
            System.out.println( string);
            for (Object o : JSONObject.parseArray(string)) {
                System.out.println(o.toString());
            }

            //确保流关闭
            EntityUtils.consume(entity);


        } catch (IOException e) {
            e.printStackTrace();
        }





    }


}

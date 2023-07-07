package HttpClient异步工具类;


import com.alibaba.fastjson.JSONObject;
import org.apache.http.Header;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.client.config.RequestConfig;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLDecoder;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;

public class 测试 {

    public static void cs() throws UnsupportedEncodingException {

        String decode = URLDecoder.decode("%7B%22childActivityUrl%22%3A%22openApp.jdMobile%3A%2F%2Fvirtual%3Fparams%3D%7B%5C%22category%5C%22%3A%5C%22jump%5C%22%2C%5C%22des%5C%22%3A%5C%22productDetail%5C%22%2C%5C%22skuId%5C%22%3A%5C%22100009320003%5C%22%7D%22%2C%22couponKey%22%3A%22geu5i1d5ed290929597984efbc8c7d4d%22%2C%22eid%22%3A%22eidAd7c781227cs7IiZXGuLOQbq2i3RoamfNxCImWJ2T%2BGnPiKV6MGRFMQQMAHknWOMxS3hvv4xQbRTN%2BoJQBY0Dmpor8wk8uuS2Cp3bl195hKrkuzkw%22%2C%22isBatchReceive%22%3A0%2C%22isN%22%3Atrue%2C%22receiveType%22%3A1%2C%22ruleId%22%3A%2284955958%22%2C%22source%22%3A%222%22%7D", "utf-8");
        System.out.println(decode);
        JSONObject jsonObject = JSONObject.parseObject(decode);
        jsonObject.forEach(new BiConsumer<String, Object>() {
            @Override
            public void accept(String s, Object o) {
                System.out.println(s+"  "+o);
            }
        });

        /**获取listJava对象并转成 JSONArray对象*/
        Object childActivityUrl = jsonObject.get("childActivityUrl");
        String s = childActivityUrl.toString();

        String[] split = s.split("=");
        String s0 = split[0] + "=";
        System.out.println(split[1]);

        Map map = JSONObject.parseObject(split[1], Map.class);

        System.out.println(s0 + JSONObject.toJSONString(map));


    }




    public static void main(String[] args) throws InterruptedException, UnsupportedEncodingException {
        HttpClientUtil异步 httpClientUtil异步 = new HttpClientUtil异步();







    }


}

package A01httpclient;

import org.apache.http.client.CookieStore;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.cookie.BasicClientCookie;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class A01设置Cookie {
    public static void main(String[] args) {




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

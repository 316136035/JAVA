package HttpClient异步工具类;


import com.alibaba.fastjson.JSONObject;
import org.apache.http.*;
import org.apache.http.client.CookieStore;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.client.utils.URLEncodedUtils;

import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLDecoder;;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HttpClientUtil异步 {
    private ThreadPoolExecutor threadPoolExecutor;//线程池
    private PoolingHttpClientConnectionManager poolingHttpClient;//浏览器池

    public HttpClientUtil异步() {
        /**CPU集型获取当前计算机的核数(最大核心线程大小)*/
        int 核数 = Runtime.getRuntime().availableProcessors();
        /**IO密集型。>判断你程序中十分耗I0的线程*2*/
        this.threadPoolExecutor = new ThreadPoolExecutor(
                20,/**核心线程大小*/
                2000,/**核心线程大小*/
                5,/**最大核心线程的超时时间*/
                TimeUnit.SECONDS,/**超时时间单位*/
                new ArrayBlockingQueue<>(2000),/**阻塞队列*/   /**(阻塞队列+最大核心线程)就是程序的最大线程数*/
                Executors.defaultThreadFactory(),/**线程工厂 创建线程的  这个不用管*/
                new ThreadPoolExecutor.DiscardOldestPolicy());/**4种拒绝策略*//**4种拒绝策略* new ThreadPoolExecutor.AbortPolicy() 当程序超过（阻塞队列+大核心线程）就会抛异常* new ThreadPoolExecutor.DiscardPolicy()  当程序超过（阻塞队列+大核心线程）就会丢弃这个线程 不会抛异常* new ThreadPoolExecutor.CallerRunsPolicy() 当程序超过（阻塞队列+大核心线程）就会丢给上级线程来处理*new ThreadPoolExecutor.DiscardOldestPolicy()  当程序超过（阻塞队列+大核心线程）就会尝试获取最早开启的线程来处理 （不一定成功）* */
        //配置浏览器池
        this.poolingHttpClient = new PoolingHttpClientConnectionManager();
        this.poolingHttpClient.setMaxTotal(2000);//设置整个连接池最大连接数
        this.poolingHttpClient.setDefaultMaxPerRoute(1000);//每个主机的并发最多只有1000

    }
    public void 异步POST
            (URI uri, CookieStore cookieStore,
             RequestConfig requestConfig, Header[] headers, List<NameValuePair> nameValuePairs) {
        String s = null;
        /**创建异步调用的CompletableFuture*/
        CompletableFuture<String> stringCompletableFuture = CompletableFuture.supplyAsync(() -> {
            CloseableHttpClient httpClient = HttpClients.custom()
                    //从浏览器池获获得浏览器
                    .setConnectionManager(poolingHttpClient)
                    //设置cookie
                    .setDefaultCookieStore(cookieStore)
                    //设置代理ip--请在RequestConfig中配置
                    //.setProxy(new HttpHost("192.168.1.21", 8888))
                    //对每一个请求配置(会覆盖全局的默认请求配置)
                    .setDefaultRequestConfig(requestConfig)
                    .build();
            //响应
            CloseableHttpResponse execute = null;
            String str = null;

            HttpPost httpPost = null;
            try {
                UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(nameValuePairs, "UTF-8");//创建表单实体类 存放表单提交的List
                urlEncodedFormEntity.setContentEncoding(Consts.UTF_8.name());
                urlEncodedFormEntity.setContentType("application/x-www-form-urlencoded");
                System.out.println(urlEncodedFormEntity);
                httpPost = new HttpPost(uri); //创建post请求
                httpPost.setEntity(urlEncodedFormEntity);//post请求设置表单实体类

                str = Post执行响应体(httpClient, httpPost);

            } catch (UnsupportedEncodingException e) {
                httpPost.releaseConnection();
                e.printStackTrace();
            } finally {
                httpPost.abort();
            }

            return str;
        }, threadPoolExecutor).whenComplete((t, u) -> {  /**正常运行会走下面whenComplete(){}中的代码*/
            System.out.println("t=" + t);/**T是正常返回的数据*/
            System.out.println("u=" + u);/**U是异常的代码信息*/


        }).exceptionally((Throwable) -> { /**异常运行会走下面exceptionally(){}中的代码*/
            System.out.println(Throwable.getMessage()); /**获取异常代码信息*/
            return Throwable.getMessage();  /**放回异常代码信息*/
        });


    }

    public void 异步GET
            (URI uri, CookieStore cookieStore,
             RequestConfig requestConfig, Header[] headers, List<NameValuePair> nameValuePairs) {
        String s = null;
        /**创建异步调用的CompletableFuture*/
        CompletableFuture<String> stringCompletableFuture = CompletableFuture.supplyAsync(() -> {
            CloseableHttpClient httpClient = HttpClients.custom()
                    //从浏览器池获获得浏览器
                    .setConnectionManager(poolingHttpClient)
                    //设置cookie
                    .setDefaultCookieStore(cookieStore)
                    //设置代理ip--请在RequestConfig中配置
                    //.setProxy(new HttpHost("192.168.1.21", 8888))
                    //对每一个请求配置(会覆盖全局的默认请求配置)
                    .setDefaultRequestConfig(requestConfig)
                    .build();
            //响应
            CloseableHttpResponse execute = null;

            String str = null;

            String URLEncoded = URLEncodedUtils.format(nameValuePairs, ContentType.APPLICATION_JSON.getCharset());//编译List<NameValuePair>对象
            String uribuilder = String.valueOf(uri);//实现Builder;
            String URLuribuilder = null; //使用URLDecoder编译Builder

            HttpGet httpGet = null;
            try {
                URLuribuilder = URLDecoder.decode(uribuilder, "UTF-8");
                httpGet = new HttpGet(URLuribuilder + URLEncoded);
                httpGet.setHeaders(headers);//设置请求头
                System.out.println("发送请求的信息:" + httpGet);
                str = Get执行响应体(httpClient, httpGet);

            } catch (UnsupportedEncodingException e) {
                httpGet.releaseConnection();
                e.printStackTrace();
            } finally {
                httpGet.abort();
            }

            return str;
        }, threadPoolExecutor).whenComplete((t, u) -> {  /**正常运行会走下面whenComplete(){}中的代码*/
            System.out.println("t=" + t);/**T是正常返回的数据*/
            System.out.println("u=" + u);/**U是异常的代码信息*/


        }).exceptionally((Throwable) -> { /**异常运行会走下面exceptionally(){}中的代码*/
            System.out.println(Throwable.getMessage()); /**获取异常代码信息*/
            return Throwable.getMessage();  /**放回异常代码信息*/
        });


    }

    public void 异步POST的JSON
            (URI uri, CookieStore cookieStore,
             RequestConfig requestConfig, Header[] headers,   JSONObject JSONObject) {
        String s = null;
        /**创建异步调用的CompletableFuture*/
        CompletableFuture<String> stringCompletableFuture = CompletableFuture.supplyAsync(() -> {
            CloseableHttpClient httpClient = HttpClients.custom()
                    //从浏览器池获获得浏览器
                    .setConnectionManager(poolingHttpClient)
                    //设置cookie
                    .setDefaultCookieStore(cookieStore)
                    //设置代理ip--请在RequestConfig中配置
                    //.setProxy(new HttpHost("192.168.1.21", 8888))
                    //对每一个请求配置(会覆盖全局的默认请求配置)
                    .setDefaultRequestConfig(requestConfig)
                    .build();


            HttpPost httpPost = new HttpPost();
            StringEntity jsonEntity = new StringEntity( JSONObject.toJSONString(), Consts.UTF_8);
            jsonEntity.setContentType(ContentType.APPLICATION_JSON.toString());
            jsonEntity.setContentEncoding(new BasicHeader("ContentType","APPLICATION/JSON"));
            httpPost.setEntity( jsonEntity);


            String str = null;
            HttpGet httpGet = null;
            try {
                String decode = URLDecoder.decode(String.valueOf(uri), "UTF-8");

                httpPost.setHeaders(headers);//设置请求头
                System.out.println("发送请求的信息:" + httpPost);
                str= Post执行响应体(httpClient, httpPost);

            } catch (UnsupportedEncodingException e) {
                httpGet.releaseConnection();
                e.printStackTrace();
            } finally {
                httpGet.abort();
            }

            return str;
        }, threadPoolExecutor).whenComplete((t, u) -> {  /**正常运行会走下面whenComplete(){}中的代码*/
            System.out.println("t=" + t);/**T是正常返回的数据*/
            System.out.println("u=" + u);/**U是异常的代码信息*/


        }).exceptionally((Throwable) -> { /**异常运行会走下面exceptionally(){}中的代码*/
            System.out.println(Throwable.getMessage()); /**获取异常代码信息*/
            return Throwable.getMessage();  /**放回异常代码信息*/
        });


    }


    public URI GetUri() {
        //构建自定义URI对象
        URIBuilder uriBuilder = new URIBuilder();
        /**测试Get*/
//        uriBuilder.setScheme("https");
//        uriBuilder.setHost("pe.3.cn");
//        uriBuilder.setPath("/prices/pcpmgets?");
        /**测试post*/
        uriBuilder.setScheme("https");
        uriBuilder.setHost("aq.jd.com");
        uriBuilder.setPath("/aqCenter/index?");


        //uriBuilder.setParameter("","");  //设置url参数
        URI uri = null;
        try {
            return uriBuilder.build();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return uri;
    }

    public CookieStore GetCookieStore(String setcookies) {
        /**使用正则表达式替换字符串中的空格、回车、换行符、制表符*/
        Pattern p = Pattern.compile("\\s*|\t|\r|\n");
        Matcher matcher = p.matcher(setcookies);
        String smatcher = matcher.replaceAll("");
        BasicCookieStore basicCookieStore = new BasicCookieStore();
        BasicClientCookie BasicClientCookie = null;
        String key = "";
        String valve = "";
        String[] split = smatcher.split(";");
        for (String s : split) {
            String[] split1 = s.split("=");
            for (int i = 0; i < split1.length; i++) {
                if (i == 0) {
                    key = split1[0];
                }
                if (i == 1) {
                    valve = split1[1];
                }
            }
            System.out.println(key+":"+valve);
            BasicClientCookie = new BasicClientCookie(key, valve);
            BasicClientCookie.setPath("/aqCenter/index");
            BasicClientCookie.setDomain("api.m.jd.com");
            basicCookieStore.addCookie(BasicClientCookie);
        }

        return basicCookieStore;
    }


    public RequestConfig GetRequestConfig(String Hostkey, String Hostvavle) {
        //对每一个请求配置(会覆盖全局的默认请求配置)
        RequestConfig requestConfig = RequestConfig.custom()
                .setProxy(GetHttpHost代理(Hostkey, Hostvavle)) //设置代理IP
                .setConnectTimeout(1000)//当客户和服务器3次握手超过设置时间就会报错ConnectTimeoutException
                .setSocketTimeout(2000)// 表示从请求的服务器获得响应的数据时间间距   超过设置的时间就会报错SocketTimeoutException
                .setConnectionRequestTimeout(5000) //表现从连接池里面获取连接的超时时间
                .build(); //构造


        return requestConfig;
    }

    public HttpHost GetHttpHost代理(String Hostkey, String Hostvavle) {
        HttpHost httpHost = new HttpHost(Hostkey, Integer.parseInt(Hostvavle));
        return httpHost;
    }

    public Header[] GetHeaders请求头() {
        return new Header[]{
                new BasicHeader("Charset", "UTF-8"),
                new BasicHeader("Connection", "keep-alive"),
                new BasicHeader("jdc-backup", "pin=9cNa6j6Si9;wskey=AAJjGfynAED99g9uS3LUuKgQMl5RXkOnYfQVjwmDUe3iynA0je6L7iaC73NwUrOKm5NlsP7c6FJcxBAE5bwNwbtysLs0U0xa;whwswswws=damzV7tC22V-zIdRAmywyP3oG6cl6JfpN0B19C-DikvAkUC3DsF0GnZXycnyqhW3k6xEQXsqgV3AIRs5bJv1b0NnGrMnmn8hk9r2BxkZRVL0kp-HTYjJEcjUGlixmpCma;unionwsws={\"devicefinger\":\"eidAd7c781227cs7IiZXGuLOQbq2i3RoamfNxCImWJ2T+GnPiKV6MGRFMQQMAHknWOMxS3hvv4xQbRTN+oJQBY0Dmpor8wk8uuS2Cp3bl195hKrkuzkw\",\"jmafinger\":\"damzV7tC22V-zIdRAmywyP3oG6cl6JfpN0B19C-DikvAkUC3DsF0GnZXycnyqhW3k6xEQXsqgV3AIRs5bJv1b0NnGrMnmn8hk9r2BxkZRVL0kp-HTYjJEcjUGlixmpCma\"};"),
                new BasicHeader("Accept-Encoding", "br,gzip,deflate"),
                new BasicHeader("Cache-Control", "no-cache"),
                new BasicHeader("Cache-Contro", "application/x-www-form-urlencoded; charset=UTF-8"),
                new BasicHeader("Accept", "application/json, text/plain, */*"),
                new BasicHeader("Host", " api.m.jd.com"),
                new BasicHeader("User-Agent", "okhttp/3.12.1"),


        };
    }

    public List<NameValuePair> GetList请求参数(String keyvalve) {
        //创建List<NameValuePair>对象
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        /**使用正则表达式替换字符串中的空格、回车、换行符、制表符*/
        Pattern p = Pattern.compile("\\s*|\t|\r|\n");
        Matcher matcher = p.matcher(keyvalve);
        String smatcher = matcher.replaceAll("");
        String key=null;
        String valve=null;
        for (String s : smatcher.split("&")) {
            String[] split = s.split("=");
            for (int i = 0; i < split.length; i++) {
                if (i == 0) {
                    key= split[0];
                }
                if (i == 1) {
                    valve= split[1];
                }

            }

            params.add(  new BasicNameValuePair( key,valve));

        }

        return params;
    }

    public  void main(String  boty) {

    }





    public String Post执行响应体(CloseableHttpClient httpClient, HttpPost httpPost) {
        //响应
        CloseableHttpResponse execute = null;
        String s = null;
        try {
            execute = httpClient.execute(httpPost); //执行httpget请求
            System.out.println("执行httpget请求");
            HttpEntity entity = execute.getEntity();   //获得响应实体类(HttpEntity不仅可以作为结果，也可以作为请求的参数实体，有很多的实现。)
            //获取响应状态
            StatusLine statusLine = execute.getStatusLine();

            System.out.println(statusLine);
            if (HttpStatus.SC_OK == statusLine.getStatusCode()) {
                String string = EntityUtils.toString(entity, "UTF-8"); //使用 EntityUtils工具类 操作
                EntityUtils.consume(entity); //确保流关闭
                Pattern p = Pattern.compile("\\s*|\t|\r|\n");   /**使用正则表达式替换字符串中的空格、回车、换行符、制表符*/
                Matcher matcher = p.matcher(string);
                s = matcher.replaceAll("");
                System.out.println(s);
            }

        } catch (Exception e) {
            httpPost.releaseConnection();
            e.printStackTrace();
        } finally {
            httpPost.abort();

        }


        return s;
    }

    public String Get执行响应体(CloseableHttpClient httpClient, HttpGet httpGet) {
        //响应
        CloseableHttpResponse execute = null;
        String s = null;
        try {
            execute = httpClient.execute(httpGet); //执行httpget请求
            System.out.println("执行httpget请求");
            HttpEntity entity = execute.getEntity();   //获得响应实体类(HttpEntity不仅可以作为结果，也可以作为请求的参数实体，有很多的实现。)
            //获取响应状态
            StatusLine statusLine = execute.getStatusLine();
            if (HttpStatus.SC_OK == statusLine.getStatusCode()) {
                String string = EntityUtils.toString(entity, "UTF-8"); //使用 EntityUtils工具类 操作
                EntityUtils.consume(entity); //确保流关闭
                Pattern p = Pattern.compile("\\s*|\t|\r|\n");   /**使用正则表达式替换字符串中的空格、回车、换行符、制表符*/
                Matcher matcher = p.matcher(string);
                s = matcher.replaceAll("");
                System.out.println(s);
            }

        } catch (Exception e) {
            httpGet.releaseConnection();
            e.printStackTrace();
        } finally {
            httpGet.abort();

        }


        return s;
    }


}

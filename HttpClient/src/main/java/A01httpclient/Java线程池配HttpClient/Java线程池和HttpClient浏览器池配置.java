package A01httpclient.Java线程池配HttpClient;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.concurrent.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Java线程池和HttpClient浏览器池配置 {
    private ThreadPoolExecutor threadPoolExecutor;//线程池
    private PoolingHttpClientConnectionManager poolingHttpClient;//浏览器池

    public Java线程池和HttpClient浏览器池配置() {
        /**CPU集型获取当前计算机的核数(最大核心线程大小)*/
        int 核数 = Runtime.getRuntime().availableProcessors();
        /**IO密集型。>判断你程序中十分耗I0的线程*2*/
        this.threadPoolExecutor = new ThreadPoolExecutor(
                20,/**核心线程大小*/
                2000,/**核心线程大小*/
                3,/**最大核心线程的超时时间*/
                TimeUnit.SECONDS,/**超时时间单位*/
                new ArrayBlockingQueue<>(2000),/**阻塞队列*/   /**(阻塞队列+最大核心线程)就是程序的最大线程数*/
                Executors.defaultThreadFactory(),/**线程工厂 创建线程的  这个不用管*/
                new ThreadPoolExecutor.DiscardOldestPolicy());/**4种拒绝策略*//**4种拒绝策略* new ThreadPoolExecutor.AbortPolicy() 当程序超过（阻塞队列+大核心线程）就会抛异常* new ThreadPoolExecutor.DiscardPolicy()  当程序超过（阻塞队列+大核心线程）就会丢弃这个线程 不会抛异常* new ThreadPoolExecutor.CallerRunsPolicy() 当程序超过（阻塞队列+大核心线程）就会丢给上级线程来处理*new ThreadPoolExecutor.DiscardOldestPolicy()  当程序超过（阻塞队列+大核心线程）就会尝试获取最早开启的线程来处理 （不一定成功）* */
        this.poolingHttpClient = new PoolingHttpClientConnectionManager();

    }
    public CompletableFuture getCompletableFuture(String url) {
        /**创建异步调用的CompletableFuture*/
        CompletableFuture<String> stringCompletableFuture = CompletableFuture.supplyAsync(() -> {
            CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(poolingHttpClient).build();
            HttpGet httpGet = new HttpGet(url);
            System.out.println("正在执行................." + httpGet);
            httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.110 Safari/537.36");
            //响应
            CloseableHttpResponse execute = null;
            String s = null;
            try {
                execute = httpClient.execute(httpGet); //执行httpget请求
                HttpEntity entity = execute.getEntity();   //获得响应实体类(HttpEntity不仅可以作为结果，也可以作为请求的参数实体，有很多的实现。)
                String string = EntityUtils.toString(entity, "UTF-8"); //使用 EntityUtils工具类 操作
                EntityUtils.consume(entity); //确保流关闭
                Pattern p = Pattern.compile("\\s*|\t|\r|\n");   /**使用正则表达式替换字符串中的空格、回车、换行符、制表符*/
                Matcher matcher = p.matcher(string);
                s = matcher.replaceAll("");
            } catch (IOException e) {e.printStackTrace();
            } finally {
                if (execute != null) {try {execute.close();} catch (IOException e) {e.printStackTrace();}}}
            return s;
        }, threadPoolExecutor);

        return stringCompletableFuture;
    }


}

package A04http请求线程池;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.config.SocketConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

import java.nio.charset.Charset;

public class HttpClientTest {
    //全局参数
    private static PoolingHttpClientConnectionManager connectionManager = null;
    //设置请求参数
    private RequestConfig config;

    private CloseableHttpClient client;

    //单例模式创建
    private void init(){
        synchronized (HttpClientTest.class) {
            if (client == null) {
                connectionManager = new PoolingHttpClientConnectionManager();
                // http请求线程池，最大连接数
                int requestMaxNum = 5000;
                ConnectionConfig connConfig = ConnectionConfig.custom().setCharset(Charset.forName("utf-8")).build();
                SocketConfig socketConfig = SocketConfig.custom().setSoTimeout(5000).build();
                connectionManager.setDefaultConnectionConfig(connConfig);
                connectionManager.setDefaultSocketConfig(socketConfig);
                // 连接池最大生成连接数
                connectionManager.setMaxTotal(requestMaxNum);
                // 默认设置route最大连接数
                connectionManager.setDefaultMaxPerRoute(requestMaxNum);
                //设置请求参数
                config = RequestConfig.custom().setConnectTimeout(5000) //连接超时时间
                        .setConnectionRequestTimeout(500) //从线程池中获取线程超时时间
                        .setSocketTimeout(5000) //设置数据超时时间
                        .build();
                // 创建builder
                HttpClientBuilder builder = HttpClients.custom();
                //管理器是共享的，它的生命周期将由调用者管理，并且不会关闭
                //否则可能出现Connection pool shut down异常
                builder.setConnectionManager(connectionManager).setConnectionManagerShared(true);
                // 长连接策略
                builder.setKeepAliveStrategy(new DefaultConnectionKeepAliveStrategy());
                // 创建httpClient
                client = builder.setDefaultRequestConfig(config).setRetryHandler(new MyRetryHandle()).build();
            }
        }
    }

    /**
     * 从池子中获取连接
     * @return CloseableHttpClient
     */
    private CloseableHttpClient getClientFromHttpPool() {
        if(client == null) {
            init();
        }
        return client;
    }

}


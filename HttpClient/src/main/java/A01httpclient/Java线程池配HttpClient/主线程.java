package A01httpclient.Java线程池配HttpClient;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;

public class 主线程 {
    public static void main(String[] args) throws InterruptedException {

        Java线程池和HttpClient浏览器池配置 java线程池和HttpClient浏览器池配置 = new Java线程池和HttpClient浏览器池配置();


        for (long i = 100032200706l; i <100032201706l; i++) {
            TimeUnit.MILLISECONDS.sleep(2000);
            String str = "https://pe.3.cn/prices/pcpmgets?skuIds="+ i+"&source=company&ext=1111111111&area=1_2901_55548_0&origin=4&pin=%E4%BC%9F%E5%BD%AC672&pdpin=%E4%BC%9F%E5%BD%AC672&pduid=16529651017411443029704";
            CompletableFuture completableFuture = java线程池和HttpClient浏览器池配置.getCompletableFuture(str);
            completableFuture.whenComplete(new BiConsumer<String, Throwable>() {
                @Override
                public void accept(String s, Throwable throwable) {
                    System.out.println("返回结果"+"        "+s);
                }
            });


        }




        };
    }


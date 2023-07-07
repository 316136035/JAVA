package A01_实现线程的三种方法.A01实现线程的方法一继承Thread并重写run方法;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class A02练习Thread_实现多线程同步下载图片 {
    public static void main(String[] args) {
        /***获取项目绝对路径 （返回拼接好的项目绝对路径）*/
        fileMkdirs();
        /**定义图片路径*/
        String  url1="https://img11.360buyimg.com/n1/jfs/t1/15821/5/18637/190687/63808eabE988e5d2f/051c7cec4d2ac0c9.jpg";
        String  url2="https://img14.360buyimg.com/n1/jfs/t1/3476/7/2751/370003/5b977068E3d9fdbe2/9aeb3156b1709e98.jpg";

        /**定义图片名字*/
        String  name1 ="1.png";
        String  name2 ="2.png";
        /**拼接文件路径+文件名*/
        String fielname1 = fileMkdirs() +"\\"+name1;
        String fielname2 = fileMkdirs() +"\\"+name2;
        /**创建线程对象传入参数（图片路径，拼接文件路径+文件名）*/
        ThreadText1 threadText1 = new ThreadText1(url1, fielname1);
        ThreadText1 threadText2 = new ThreadText1(url2, fielname2);

        /**调用线程*/
        threadText1.start();
        threadText2.start();

    }
    /**返回拼接好的项目绝对路径*/
    public static String fileMkdirs() {
        /***获取项目绝对路径*/
        String property = System.getProperty("user.dir");
        /**创建file对象并不是创建文件*/
        File file = new File( property,"动态目录\\A26_线程");
        /**判断是否存在目录*/
        if (!file.exists()&&!file.isDirectory()) {
            /**创建多层目录*/
            System.out.println(file.mkdirs()+"目录创建成功..");
        }
        /**返回目录路径*/
        return file.toString();
    }
}

/**继承 Thread  重写run() 方法*/
class ThreadText1 extends Thread {

    /**定义图片路径*/
    private String url;
    /**定义图片名字*/
    private String name;

    public   ThreadText1( String url,String name){
       this.url=url;
       this.name=name;
    }
    /**线程的执行体*/
    @Override
    public void run() {
        /**创建下载的对象*/
        WedDownLoader wedDownLoader = new WedDownLoader();
        /**调用下载方法*/
        wedDownLoader.dowmLoader( url,name);
        /**获取线程的名字*/
        System.out.println("获取线程的名字:"+Thread.currentThread().getName());
    }
}

/**定义下载图片的类*/
class WedDownLoader {
    /**定义下载图片的方法*/
    public void dowmLoader(String url, String filename) {
        try {
            /**使用commons-io-2.11.0.jar工具类 下载图片（图片地址，保存的图片路径+文件名）*/
            FileUtils.copyURLToFile(new URL(url), new File(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
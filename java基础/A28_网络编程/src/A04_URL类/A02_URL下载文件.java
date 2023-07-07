package A04_URL类;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class A02_URL下载文件 {
    public static void main(String[] args) {
        try {
            /**创建URL*/
            URL url = new URL("https://t7.baidu.com/it/u=674071663,2882444360&fm=218&app=126&size=f242,150&n=0&f=JPEG&fmt=auto?s=C752C1334F6E440B1E79EDDF0300C0B2&sec=1669914000&t=36c4b98738bde7d62e40d87919cdaa0a");
            /**打开链接*/
            URLConnection urlConnection = url.openConnection();
            /**获取输入流*/
            InputStream inputStream = urlConnection.getInputStream();
            System.out.println(inputStream);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

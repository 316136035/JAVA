import java.util.Date;

public class A01Date时间类 {
    public static void main(String[] args) {

        //创建date时间类
        Date date = new Date();
        System.out.println(date);

        //获取java中的当前时间（毫秒）
        long TimeMillis = System.currentTimeMillis();
        //创建date时间类（毫秒数）
        Date dateTimeMillis  = new Date(TimeMillis );
        System.out.println(dateTimeMillis);

       /**通过date时间类转成毫秒*/
        long time = date.getTime();
        System.out.println(time);









    }
}

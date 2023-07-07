import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class A02时间格式化DateFormat的子类SimpleDateFormat {
    public static void main(String[] args) throws ParseException {

        /**创建时间对象date*/
        Date date = new Date();
        /**创建时间类格式化对象*/
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        /**格式化时间类*/
        String format = simpleDateFormat.format(date);
        System.out.println(format);

        /**创建时间类格式化对象(年,月,日,时,分,秒,毫秒)*/
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy/MM/dd  HH:mm:ss   SSS ");
        /**格式化时间类*/
        String format1 = simpleDateFormat1.format(date);
        System.out.println(format1);

        /**字符串的时间--->date类(首先要创建 SimpleDateFormat格式化类才能转换)*/
        Date parse = simpleDateFormat1.parse(format1);
        System.out.println(parse);
        /**date类--->long*/
        System.out.println(parse.getTime());

        text();
    }


    public static void text() {
        while (true){

            /**创建时间类格式化对象*/
            SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy/MM/dd  HH:mm:ss   SSS ");

            String format = simpleDateFormat1.format(new Date());
            System.out.println(format);
            try {
                TimeUnit.MILLISECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}

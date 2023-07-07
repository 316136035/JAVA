import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class A05字符串API修改和替换 {
    public static void main(String[] args) {
//        /**创建一个扫描器*/
//        Scanner scanner = new Scanner(System.in);
//        /**通过扫描器读取从控制台输入的内容*/
//        String next = scanner.nextLine();
//        System.out.println(next);
        String next = "aQxOpUjZcFiD1";
        /**把字符串的全部变成大写*/
        System.out.println(next.toUpperCase());
        /**把字符串的全部变成小写*/
        System.out.println(next.toLowerCase());

        String cookie = "aQxOpUjZcFiD----duh460353--------pin=aQxOpUjZcFiD;wskey=AAJhhVnqAEC0qmROrabJh-uX-oCzBvyRpJ2sUBtlRbUQq06uB7eAejjE3BLfO40CSiFAAnqxZW0YhTz4_0Nu98U9BwooC9Rc;pt_key=app_openAAJhh4ZqADBUN4hoPV_o-KTA3Vo5LGHxGF67ZzEWNEwF17zFuQB7J8Men9XUbwXcyKqECjW85vE;pt_pin=aQxOpUjZcFiD\n";
        /**split（）  关键字拆分字符串（"\\特殊字符"），，最好全部加上\\*/
        String[] split = cookie.split("\\;");
        for (String s : split) {
            System.out.println(s);

        }

        /**字符串的替换*/
        String str = "\n" +
                "\n" +
                " 我是  中  \n" +
                "   国人,我是中    \n" +
                "    国人,我是 \t  1 1   \" + \" \n" +
                "\t 中国人 ";
        /**replace("要替换的字符", "新的字符")*/
        String replace = str.replace("我是", "你不是");
        System.out.println(replace);
        /**去除字符串的空格（只能去除头和尾）*/
        String trim = replace.trim();
        System.out.println("去除字符串的空格:" + trim);

        /**去除全部空格和换行
         * 注：\n 回车(\u000a)
         \t 水平制表符(\u0009)
         \s 空格(\u0008)
         \r 换行(\u000d)
         *
         *
         * Pattern p = Pattern.compile("\\s*|\t|\r|\n");
         * */
        /**使用正则表达式替换字符串中的空格、回车、换行符、制表符*/
        Pattern p = Pattern.compile("\\s*|\t|\r|\n");
        Matcher matcher = p.matcher(str);
        String s = matcher.replaceAll("");
        System.out.println("用正则表达式替换字符串中的空格、回车、换行符、制表符:" + s);

        /**使用replace替换字符串中的空格、回车、换行符、制表符*/
        String replace1 = str;
        str = replace1.replaceAll("\n", "").replace("\t", "").replace("\r", "").replace(" ", "");
        System.out.println("用replace替换字符串中的空格、回车、换行符、制表符:"+str);


    }


}

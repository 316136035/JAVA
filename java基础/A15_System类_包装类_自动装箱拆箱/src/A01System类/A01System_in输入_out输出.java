package A01System类;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class A01System_in输入_out输出 {
    public static void main(String[] args) {

        /**从控制台获得输入流*/
        InputStream in = System.in;
        /**创建扫描器*/
        Scanner scanner = new Scanner(in);

        while (true){

            /**读取从控制台获得输入的每一行*/
            String s = scanner.nextLine();
            /**从控制台获得输出流*/
            PrintStream out = System.out;
            /**打到控制器*/
            out.println(s );



        }


    }
}

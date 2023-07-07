package A04Scanner扫描器;

import java.util.Scanner;

public class A01Scanner扫描器 {
    public static void main(String[] args) {

        /**创建Scanner扫描器  从控制台输入*/
        Scanner scanner = new Scanner(System.in);
        while (true) {
            /**读取每一行*/
            String str = scanner.nextLine();
            System.out.println(str);
        }

    }
}

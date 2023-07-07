package A01_IO打印流PrintWriter;


import java.io.PrintWriter;

public class A02IO打印流PrintWriter打印控制台 {
    public static void main(String[] args) {

        PrintWriter printWriter=null;
        try {
            /**创建打印流PrintWriter*/
            printWriter = new PrintWriter(System.out);

            /**打印到控制台*/
            printWriter.println("打印到控制台");
            printWriter.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (printWriter !=null){
                printWriter.close();
            }
        }


    }
}

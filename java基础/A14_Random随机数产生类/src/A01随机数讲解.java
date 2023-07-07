import java.util.Random;


public class A01随机数讲解 {
    public static void main(String[] args) {


        Random random = new Random();
        for (int i = 0; i <10 ; i++) {
            /**int返回从该随机数生成器的序列中提取的伪随机、均匀分布的值，介于 0（含）和指定值（不含）之间。*/
            int i1 = random.nextInt(100);
            System.out.print(i1 );
        }
        System.out.println();
        for (int i = 0; i <10 ; i++) {
            /**boolean从该随机数生成器的序列中返回下一个均匀分布的伪随机 值。*/
            boolean b = random.nextBoolean();
            System.out.print(b);
        }

        System.out.println();
       /** 生成数字：0-9*/
       char  char1 = (char)(Math.random()*('9' - '0' + 1) + '0');
       System.out.println( char1);

       /** 生成小写字母：a-z*/
       char  char2 = (char)(Math.random()*('z' - 'a' + 1) + 'a');
       System.out.println(char2);

       /** 生成大写字母：A-Z*/
       char  char3 = (char)(Math.random()*('Z' - 'A' + 1) + 'A');
       System.out.println(char3 );

        for (int i = 0; i < 100; i++) {
            System.out.println(getStringRandom(4));
        }



    }


/**Random生成字母+数字的随机数*/
    public static String getStringRandom(int length) {
        String val = "";
        Random random = new Random();
        //参数length，表示生成几位随机数
        for(int i = 0; i < length; i++) {
            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
            //输出字母还是数字
            if("char".equalsIgnoreCase(charOrNum)){
                //输出是大写字母还是小写字母
                int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
                val += (char)(random.nextInt(26) + temp);
            }else if("num".equalsIgnoreCase(charOrNum)) {
                val += String.valueOf(random.nextInt(10));
            }
        }
        return val;
    }
}

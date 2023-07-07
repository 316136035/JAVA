public class B01计算一个字符串中大写字母和小写字母还有数字的数量 {
    public static void main(String[] args) {
        Text("123456ASDFaaa");
    }

    public static void Text(String str) {
        int 数字字母 = 0;
        int 大写字母 = 0;
        int 小写字母 = 0;

        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt >= '0' && charAt <= '9') {
                数字字母++;
            }
            if (charAt >= 'A' && charAt <= 'Z') {
                大写字母++;
            }
            if (charAt >= 'a' && charAt <= 'z') {
                小写字母++;
            }


        }


        System.out.println("数字字母" + 数字字母 + "    " + "大写字母:" + 大写字母 + "    " + "小写字母:" + 小写字母);


    }

}

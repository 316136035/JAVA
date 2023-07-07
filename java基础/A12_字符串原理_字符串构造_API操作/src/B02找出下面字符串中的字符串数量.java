public class B02找出下面字符串中的字符串数量 {
    public static void main(String[] args) {

        String str = "liasdflihsdhllihsdflihsdfiligsdfglikhsdfklilisdflio;";

        Text(str);


    }

    public static void Text(String str) {

        /** fromlndex（指定的索引） 从后到前数第一次出现的li索引的值，(找不到就是-1)*/
        int ii = str.lastIndexOf("li", str.length());
        int count = 0;

        while (ii != -1) {
            count++;
            ii = str.lastIndexOf("li", ii - 1);
        }

        System.out.println(count);

    }
}

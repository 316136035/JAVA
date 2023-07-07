public class A03字符串API的判断 {
    public static void main(String[] args) {
        String str = "我是中国人A太容易";
        /**当且仅当此字符串包含指定的字符串序列时才返回true*/
        System.out.println("当且仅当此字符串包含指定的字符串" + str.contains("中国"));

        /**判断字符串是否是这个字符串*/
        StringBuffer SB = new StringBuffer("中国人");
        System.out.println("判断字符串是否是内容等于" + str.contentEquals("中国人"));
        System.out.println("判断字符串是否是内容等于" + str.contentEquals("SB "));

        /**测试此字符串是否以指定的后缀结尾。*/
        System.out.println("测试此字符串是否以指定的后缀结尾" + str.endsWith("人"));

        /**测试此字符串是否以指定的前缀开头。*/
        System.out.println("测试此字符串是否以指定的前缀开头" + str.startsWith("中"));

        /**测试此字符串是否以指定的索引 前缀开头。*/
        System.out.println("测试此字符串是否以指定的索引 前缀开头" + str.startsWith("中", 2));

        /**将此字符串与指定对象进行比较区分大小写*/
        System.out.println("将此字符串与指定对象进行比较不区分大小写" + str.equals("我是中国人A"));

        /**将此字符串与指定对象进行比较不区分大小写*/
        System.out.println("将此字符串与指定对象进行比较不区分大小写" + str.equalsIgnoreCase("我是中国人a"));

        /**判空返回 true如果，且仅当 length()为 0 。 */
        System.out.println("判空返回 true如果，且仅当 length()为 0 " + str.isEmpty());


    }
}

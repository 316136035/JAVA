public class A02可变字符串StringBuffer_方法 {
    public static void main(String[] args) {

        /**可变字符串线程安全*/
        StringBuffer stringBuffer = new StringBuffer("可变字符串");
        //StringBuffer是一个可变字符串，在原有的字符串上追加返回这个字符串的对象
        System.out.println(stringBuffer.append("在原有的字符串上追加返回这个字符串的对象"));
        //在原有的字符串上追加ABCDEF（偏移量 ，意思是开始索引截取长度，）
        System.out.println(stringBuffer.append("ABCDEFG",1,4));
        //返回 StringBuffer当前容量。
        System.out.println("返回当前 StringBuffer容量:" + stringBuffer.capacity());
        //返回char此序列中指定索引处的值
        System.out.println("返回char此序列中指定索引处的值:" + stringBuffer.charAt(0));
        //删除char此序列中指定位置的值 。
        System.out.println("删除char此序列中指定位置的值:" + stringBuffer.deleteCharAt(0));
        //删除此序列的子字符串中的字符。。
        System.out.println("删除此序列的子字符串中的字符:" + stringBuffer.delete(0,1));
        //返回指定子字符串在此字符串中第一次出现的索引。
        System.out.println("返回指定子字符串在此字符串中第一次出现的索引。:" + stringBuffer.indexOf("在",2));
        //从指定索引开始向后搜索 指定子字符串在此字符串中第一次出现的索引。
        System.out.println("从指定索引开始向后搜索 指定子字符串在此字符串中第一次出现的索引。:" + stringBuffer.lastIndexOf("在",10));
        //将参数的字符串表示形式String插入到此序列中（指定索引处插入）。
        System.out.println("将参数的字符串表示形式String插入到此序列中。。:" + stringBuffer.insert(0,"可变"));
        //返回长度（字符数）。
        System.out.println("返回长度（字符数):"+stringBuffer.length());
        //将此序列的子字符串中的字符替换为指定 中的字符String。
        System.out.println(stringBuffer.replace(0,5, "将此序列的子字符串中的字符替换为指定 中的字符String。"));
        //导致此字符序列被序列的反向替换。
        System.out.println("导致此字符序列被序列的反向替换:"+stringBuffer.reverse());
        // 返回一个新的String，其中包含当前包含在此序列中的字符子序列。
        System.out.println("返回一个新的String，其中包含当前包含在此序列中的字符子序列:"+stringBuffer.substring(5,10));




    }
}

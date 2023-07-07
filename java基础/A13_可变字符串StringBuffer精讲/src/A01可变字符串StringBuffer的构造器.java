public class A01可变字符串StringBuffer的构造器 {
    public static void main(String[] args) {

        /**
         构造一个其中没有字符且初始容量为 16 个字符的字符串缓冲区。*/
        StringBuffer stringBuffer = new StringBuffer();
        /**
         构造一个其中没有字符和指定初始容量的字符串缓冲区。*/
        StringBuffer stringBuffer1 = new StringBuffer(18);

        /**
         构造一个包含与指定 相同字符的字符串缓冲区CharSequence。*/

        StringBuffer stringBuffer2 = new StringBuffer("UTF-8");
        /**
         *
         构造一个字符串缓冲区，初始化为指定字符串的内容。*/
        StringBuffer stringBuffer3 = new StringBuffer("初始化为指定字符串的内容");

    }
}

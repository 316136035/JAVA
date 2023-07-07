public class A02错误Error {
    public static void main(String[] args) {
        /**Error是throwable的子类，他是程序出现了严重的问题，这种问题程序解决不了。*
         * 如:因为内存溢出或没有可用的内存提供给垃圾回收器时，Java 虚拟机无法分配一个对象，这时抛出该异常。错误都是以Error为结尾
         *这种只能提升硬件性能
         */

        /**当Java虚拟机由于内存不足而无法分配对象时抛出，并且垃圾收集器不再有可用的内存
         * 出现OutOfMemoryError*/

        int[] arr = new int[9999999 * 999999999 * 99999999];

        System.out.println(arr.length);


    }
}

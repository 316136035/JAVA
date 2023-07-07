package A01System类;


import java.util.Arrays;
import java.util.function.BiConsumer;

public class A02System方法 {
    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5};
        int[] arrs = {6, 7, 8, 9, 10, 11};
        /**将指定源数组中的数组从指定位置开始复制到目标数组的指定位置。*/
        /***System.arraycopy("原数组" 原数组开始索引，目标数组，目标数组索引，原数组要拷贝的长度)*/
        System.arraycopy(arr, 1, arrs, 2, 3);
        System.out.println(Arrays.toString(arrs));
        /**获取当前时间以毫秒为单位返回当前时间。*/
        System.out.println(System.currentTimeMillis());

        System.out.println("Windows:"+System.getProperty("os.name"));

        /**获取系统属性**/
        System.getProperties().forEach(new BiConsumer<Object, Object>() {
            @Override
            public void accept(Object  o, Object o2) {
                System.out.println(o.toString()+"       "+ o2.toString());
            }
        });

    }
}

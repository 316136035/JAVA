import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class A02数组工具类Arrays {
    public static void main(String[] args) {

        /**返回指定数组内容的字符串表示形式。*/
        String toString = Arrays.toString(new char[]{'我', '是', '中', '国', '人'});
        System.out.println(toString);

        /**返回指定数组内容的字符串表示形式。*/
        Person[] people = new Person[2];
        people[0]=new Person(1, "周先生", 18);
        people[1] =new Person(2, "黄先生", 19);
        System.out.println(Arrays.toString(people));

        /**对数组排序*/
        int[] ints = {1, 45, 64, 684, 564, 864, 86, 465, 48, 1, 864, 65, 186, 165, 1};
        Arrays.sort(ints);
        /**对数组指定索引排序*/
        Arrays.sort(ints,0,10);
        /**排序对象,对象要实现 Comparable<T>接口  重写compareTo()方法*/


        System.out.println(Arrays.toString(ints));

        /**使用二分法搜索。返回索引*/
        int i = Arrays.binarySearch(ints, 186);
        System.out.println(i);




        /**数组转List集合*/
        List<Person> ints1 = Arrays.asList( people);
        ints1.forEach(new Consumer<Person>() {
            @Override
            public void accept(Person person) {
                System.out.println(person);
            }
        });



    }
}

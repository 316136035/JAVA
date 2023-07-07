package A01集合Collection的体系_List_Set.集合的遍历;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class forEach消费型接口 {
    public static void main(String[] args) {
        /**创建ArrayList集合实现类*/
        List<String> listteacher1 = new ArrayList<>();
        /**集合中添加元素*/
        listteacher1.add("奥迪");
        listteacher1.add("宝马");
        listteacher1.add("玛莎拉蒂");
        listteacher1.add("大众");
        listteacher1.add("本田");

        /**消费型接口打印*/
        listteacher1.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {System.out.println(s);
            }
        });

    }
}

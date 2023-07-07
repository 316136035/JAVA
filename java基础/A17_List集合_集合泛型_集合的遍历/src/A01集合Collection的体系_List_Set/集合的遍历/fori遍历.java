package A01集合Collection的体系_List_Set.集合的遍历;

import java.util.ArrayList;
import java.util.List;

public class fori遍历 {
    public static void main(String[] args) {
        /**创建ArrayList集合实现类*/
        List<String> listteacher1 = new ArrayList<>();
        /**集合中添加元素*/
        listteacher1.add("奥迪");
        listteacher1.add("宝马");
        listteacher1.add("玛莎拉蒂");
        listteacher1.add("大众");
        listteacher1.add("本田");

        /**动态的获取集合的长度*/
        for (int i = 0; i < listteacher1.size(); i++) {
            if (listteacher1.get(i).equals("宝马")) {
                listteacher1.add("add");
            }
            System.out.println(listteacher1.get(i));
        }






    }
}

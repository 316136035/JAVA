import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    // 定义集合，用来存储饭店的菜品  Map<菜品对象,数量>
    private static List<Dish> dishList = new ArrayList<>();

    // 用户已点的菜品
    private static List<Dish> userList = new ArrayList<>();

    // 静态代码块，是什么时候执行的！！
    static {
        dishList.add(new Dish(1,"宫保鸡丁",21));
        dishList.add(new Dish(2,"炖王八",49));
        dishList.add(new Dish(3,"红烧肉",36));
        dishList.add(new Dish(4,"红烧茄子",26));
        dishList.add(new Dish(5,"酸菜鱼",42));
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        // 开始点菜的流程
        // 创建扫描器对象
        Scanner s = new Scanner(System.in);
        // 编写while循环。死循环
        while (true){
            // 输出饭店的菜单
            showMenu();
            // 获取到用户输入的编号
            int num1 = s.nextInt();
            // 根据用户输入的数字，做一些事情...
            switch (num1){
                case 1:
                    // System.out.println("用户选择了点菜...");
                    while (true){
                        // 点菜，展示饭店的菜品
                        showDish();
                        // 用户输入的数字  12345
                        int num2 = s.nextInt();
                        // 判断
                        if(num2 == 0){
                            break;
                        }
                        Dish dish = dishList.get(num2 - 1);
                        //复制list对象
                        Dish dishclone = (Dish)dish.clone();
                        // 表示用户点菜了
                        userList.add( dishclone);
                        System.out.println("亲，您已经点了"+dish.getName());
                    }
                    break;
                case 2:
                    // System.out.println("用户选择了已点...");
                    // 作业：展示已点菜品，退菜！！
                    break;
                case 3:
                    // System.out.println("用户选择了买单...");
                    // 结账
                    buy();
                    return;
            }
        }
    }

    // 结账
    public static void buy(){
        System.out.println("大爷，感觉还可以，稍等，正在结算...");
        double money = 0d;
        // 结算
        for (Dish dish : userList) {
            // 金额的累加
            money += dish.getPrice();
        }
        System.out.println("您一共消费了："+money+"，欢迎下次再来...");
    }

    // 显示饭店的菜品
    public static void showDish(){
        System.out.println("-------欢迎点菜---------");

        // 遍历 dishList集合，显示菜品就OK  dishList.for  回车 生成增强for循环
        for (Dish dish : dishList) {
            System.out.println(dish.getNum()+"\t"+dish.getName()+"\t"+dish.getPrice());
        }

        System.out.println("-------输入编号点菜，按0返回主目录---------");
    }

    // 显示饭店的主菜单
    public static void showMenu(){
        System.out.println("-------主菜单---------");
        System.out.println("1\t\t点菜");
        System.out.println("2\t\t已点");
        System.out.println("3\t\t买单");
        System.out.println("-------主菜单---------");
    }

}

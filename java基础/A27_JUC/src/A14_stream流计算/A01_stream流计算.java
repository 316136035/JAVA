package A14_stream流计算;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class A01_stream流计算 {
    public static void main(String[] args) {

        List<User> list = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            list.add(new User(i, "a" + i, i + 100));
        }
        System.out.println(list);
        /**获取流计算对象*/
        Stream<User> userStream = list.stream();
        /**使用 Stream流对象过滤元素*/
        userStream
                /**(Predicate_断定型接口_传入参数_返回boolean)*/
                .filter((user) -> {
                    return user.getId() % 2 == 0;
                })
                /**(Predicate_断定型接口_传入参数_返回boolean)*/
                .filter((user) -> {
                    return user.getAge() > 105;
                })
                /**(Function_函数型接口_传入参数_返回参数)*/
                .map((user -> {
                    return user.getName().toUpperCase();
                }))
                /**使用sorted方法排序 Comparator函数型接口排序*/
                .sorted((String o1, String o2) ->{return o1.compareTo( o2);})
                /**分页*/
                .limit(2)
                /**打印 Stream流对象*/
                .forEach(System.out::println);


    }
}

class User {

    public User(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public void setAge(int age) {
        this.age = age;
    }

    private int id;
    private String name;
    private int age;


}
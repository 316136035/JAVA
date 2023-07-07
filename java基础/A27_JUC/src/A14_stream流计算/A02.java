package A14_stream流计算;

import java.util.function.Predicate;

public class A02 {
    public static void main(String[] args) {
        User1 user1 = new User1(1, "周钰婷", 7);
        User1 user2 = new User1(2, "周伟彬", 30);




    }
}
class User1 {

    public User1(int id, String name, int age) {
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
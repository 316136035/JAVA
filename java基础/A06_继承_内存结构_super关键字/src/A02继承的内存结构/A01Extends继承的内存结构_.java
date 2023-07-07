package A02继承的内存结构;

public class A01Extends继承的内存结构_ {
    public static void main(String[] args) {
        WorkPerson workPerson = new WorkPerson();
        workPerson.name = "周先生";
        workPerson.age = 19;
        workPerson .money = 10000;
    }
}

class Person {
    String name;
    int age;

    public void sleep() {
        System.out.println(name + "正在睡觉");


    }

}

class WorkPerson extends Person{
    double money;

    public void paoBu() {
        System.out.println(name + "正在跑步");
    }


}


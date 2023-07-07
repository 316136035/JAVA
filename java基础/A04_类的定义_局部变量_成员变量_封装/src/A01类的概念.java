public class A01类的概念 {
    public static void main(String[] args) {
        /**
         * 我们把某些具有相同的属性和行为的事物抽象成一类。
         *类名:首字母大写的驼峰模式XxxYyy */

        Dog dog = new Dog();
        dog.str = "名字";
        dog.gender = 1;
        dog.color = "黄色";

        System.out.println(dog.toString());
        dog.sleep();


    }


}

class Dog {
    String str;
    int gender;
    String color;

    @Override
    public String toString() {
        return "Dog{" +
                "str='" + str + '\'' +
                ", gender=" + gender +
                ", color='" + color + '\'' +
                '}';
    }

    public void sleep() {
        System.out.println("正在睡觉");

    }

    public void lookHome() {
        System.out.println("正在睡觉");

    }


}




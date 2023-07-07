class Student {
    /**
     * private只能在本类中使用
     */
    private int stu;
    private String name;
    private int age;


    public Student(int stu, String name, int age) {
        this.stu = stu;
        this.name = name;
        this.age = age;
    }

    public int getStu() {
        return stu;
    }

    public void setStu(int stu) {
        this.stu = stu;
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

    public void setAge(int age) {
        this.age = age;
    }

    public void sleep() {
        System.out.println("学生在睡觉");
    }

    public void info() {
        System.out.println(stu + name + age + "学生在跑步");
    }

}


public class A05封装 {


    /**
     * 面向对象三大特征：封装，继承，多态。
     * 目的：提高数据安全性，通过封装，可以实现对属性的访问权限控制，同时增加了程序的可维护性。
     * 封装：
     * 将属性私有化，使用private关键字完成属性私有化，这种属性只有本类能访问。
     * 我们一般对每一个私有属性提供公共public的set和get这种方法供外界来访问我们的私有属性。
     * 除非用反射
     */
    public static void main(String[] args) {
        Student student = new Student(19, "name", 19);
        student.info();

    }


}


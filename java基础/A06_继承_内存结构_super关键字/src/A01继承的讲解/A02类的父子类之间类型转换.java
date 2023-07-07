package A01继承的讲解;

public class A02类的父子类之间类型转换 {
    public static void main(String[] args) {


        JavaTeacher javaTeacher = new JavaTeacher();
        /**子类的对象自动赋给父类做引用*/
        Teacher teacher = javaTeacher;

        /**如果子类里面有对父类的方法的重写的话，那么通过父类的引用调用重写的方法的时候调用的是子类*/
        teacher.sleep();

        /**属性不能重写  谁调用就是谁的属性*/
        System.out.println(javaTeacher.name);
        System.out.println( teacher.name);

        /**子类赋给的父类不能使用子类特有的方法*/
//        teacher.word();

        /**父类如果转操成子类必须要强制转换，但是前提是这个父类的真身是这个子类*/
        JavaTeacher javaTeacher1 = (JavaTeacher) teacher;
        javaTeacher1.word();


    }
}

class Teacher {
    String name = "父类属性";
    int age;

    public void sleep() {
        System.out.println("正在睡觉");
    }
}

class JavaTeacher extends Teacher {
    String name = "子类属性";

    /**
     * 重写了父类的方法
     */
    public void sleep() {
        System.out.println(name + "  " + "Java正在大路上睡觉");
    }

    /**
     * 子类特有的方法
     */
    public void word() {
        System.out.println(name + "   " + "工地上班");


    }

}
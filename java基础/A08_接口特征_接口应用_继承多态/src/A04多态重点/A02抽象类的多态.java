package A04多态重点;

abstract class Teacheralls1 {
    String name;

    public abstract void teach();


}

class TeacherJava1 extends Teacheralls1 {
    public void teach() {
        System.out.println("Java开始讲课");
    }


}

class TeacherPhp1 extends Teacheralls1 {
    public void teach() {
        System.out.println("Php开始讲课");
    }

}

public class A02抽象类的多态 {
    public static void main(String[] args) {
        /**同一个方法表现不同的行为就是多态*/

        Teacheralls1 teacherJava = new TeacherJava1();
        teacherJava.teach();

        Teacheralls1 TeacherPhp = new TeacherPhp1();
        TeacherPhp.teach();
    }
}
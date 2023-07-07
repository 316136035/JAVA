package A04多态重点;

class Teacheralls {
    String name;

    public void teach() {
        System.out.println("开始讲课");
    }


}

class TeacherJava extends Teacheralls {
    public void teach() {
        System.out.println("Java开始讲课");
    }


}

class TeacherPhp extends Teacheralls {
    public void teach() {
        System.out.println("Php开始讲课");
    }


}

public class A01普通类的多态 {
    public static void main(String[] args) {
        /**同一个方法表现不同的行为就是多态*/

        Teacheralls teacherJava = new TeacherJava();
        teacherJava.teach();

        Teacheralls TeacherPhp = new TeacherPhp();
        TeacherPhp.teach();


    }
}









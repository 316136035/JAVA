interface Teacher1 {

    public void teach();


}

class TeacherJava2 implements Teacher1 {
    public void teach() {
        System.out.println("Java开始讲课");
    }


}

class TeacherPhp2 implements Teacher1 {
    public void teach() {
        System.out.println("Php开始讲课");
    }

}


public class A01接口的多态 {
    public static void main(String[] args) {
        /**同一个方法表现不同的行为就是多态*/

        Teacher1 teacherJava = new TeacherJava2();
        teacherJava.teach();

        Teacher1 TeacherPhp = new TeacherPhp2();
        TeacherPhp.teach();
    }
}

package A04多态重点;

/**定义接口*/
interface Teacheralls2 {

    public void teach();


}
/**实现接口*/
class TeacherJava2 implements Teacheralls2 {
    public void teach() {
        System.out.println("Java开始讲课");
    }


}
/**实现接口*/
class TeacherPhp2 implements Teacheralls2 {
    public void teach() {
        System.out.println("Php开始讲课");
    }

}


public class A03接口interface的多态 {
    public static void main(String[] args) {
        /**同一个方法表现不同的行为就是多态*/

        Teacheralls2 teacherJava = new TeacherJava2();
        teacherJava.teach();

        Teacheralls2 TeacherPhp = new TeacherPhp2();
        TeacherPhp.teach();
    }
}

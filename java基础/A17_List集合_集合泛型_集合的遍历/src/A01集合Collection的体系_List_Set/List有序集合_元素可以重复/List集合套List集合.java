package A01集合Collection的体系_List_Set.List有序集合_元素可以重复;

import java.util.ArrayList;
import java.util.List;

public class List集合套List集合 {
    public static void main(String[] args) {
        /**创建书的集合*/
        List<Book> books = new ArrayList<>();
        /**书的集合次存放书*/
        books.add(new Book("语文", 18));
        books.add(new Book("数学", 17));
        books.add(new Book("英语", 20));
        /**创建学生对象*/
        Student s1 = new Student(1, "侯先生", 19, books);
        /**创建学生集合*/
        List<Student> students = new ArrayList<>();
        /**学生集合存放学生*/
        students.add(s1);
        System.out.println(students);
        Student student = students.get(0);
        System.out.println(student.getList());


    }
}

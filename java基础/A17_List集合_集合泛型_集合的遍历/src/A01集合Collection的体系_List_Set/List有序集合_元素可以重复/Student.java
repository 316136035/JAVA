package A01集合Collection的体系_List_Set.List有序集合_元素可以重复;

import java.util.List;

public class Student {
    private int id;
    private String name;
    private int age;

    public Student(int id, String name, int age, List<Book> list) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.list = list;
    }

    private List<Book> list;

    public List<Book> getList() {
        return list;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", list=" + list +
                '}';
    }

    public void setList(List<Book> list) {
        this.list = list;
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

    public void setAge(int age) {
        this.age = age;
    }

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}

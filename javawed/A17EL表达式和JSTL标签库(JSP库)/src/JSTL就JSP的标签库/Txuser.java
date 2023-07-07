package JSTL就JSP的标签库;


public class Txuser {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Txuser(String name, int age, int xingbie) {
        this.name = name;
        this.age = age;
        this.xingbie = xingbie;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getXingbie() {
        return xingbie;
    }

    @Override
    public String toString() {
        return "Txuser{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", xingbie=" + xingbie +
                '}';
    }

    public void setXingbie(int xingbie) {
        this.xingbie = xingbie;
    }

    private  String name;
    private  int  age;
    private  int   xingbie;


}

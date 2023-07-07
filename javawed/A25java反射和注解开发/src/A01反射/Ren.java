package A01反射;

public class Ren {
    public static void statictext() {
        System.out.println("我是静态方法...");
    }

    public Ren() {
    }

    private String name;
    private  int  age;
    private String address;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Ren{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Ren(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }
}

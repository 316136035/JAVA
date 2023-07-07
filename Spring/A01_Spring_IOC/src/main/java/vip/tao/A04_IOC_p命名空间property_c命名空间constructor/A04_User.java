package vip.tao.A04_IOC_p命名空间property_c命名空间constructor;


public class A04_User {

    private String name;
    private  int age;
    private A04_Role address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "A04_User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address=" + address +
                '}';
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public A04_Role getAddress() {
        return address;
    }

    public void setAddress(A04_Role address) {
        this.address = address;
    }
}

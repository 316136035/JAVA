package vip.tao.A05_IOC_三种装配benans.A05_A01_xml手动装配;

public class A05_A01_Person {
    private String name;
    private A05_A01_Dog dog;
    private A05_A01_Cat cat;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public A05_A01_Dog getDog() {
        return dog;
    }

    public void setDog(A05_A01_Dog dog) {
        this.dog = dog;
    }

    public A05_A01_Cat getCat() {
        return cat;
    }

    public void setCat(A05_A01_Cat cat) {
        this.cat = cat;
    }
}

package vip.tao.A05_IOC_三种装配benans.A05_A02_java注解自动装配;


import javax.annotation.Resource;



public class A05_A02_Person {

    @Resource(name = "dog")
    private A05_A02_Dog dog;

    @Resource()
    private A05_A02_Cat cat;

    public A05_A02_Dog getDog() {
        return dog;
    }

    public void setDog(A05_A02_Dog dog) {
        this.dog = dog;
    }

    public A05_A02_Cat getCat() {
        return cat;
    }

    public void setCat(A05_A02_Cat cat) {
        this.cat = cat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;





}

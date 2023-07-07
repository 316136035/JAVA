public class A03Static关键字 {
    public static void main(String[] args) {

        //静态属性的使用
        Person 周先生 = new Person("周先生", 18);
        Person.id++;
        Person 黄先生 = new Person("黄先生", 18);
        Person.id++;
        Person X先生 = new Person("X先生", 18);
        X先生.id++;
        System.out.println(Person.id);

        //静态方法的使用
        Person 静态方法的使用 = new Person("静态方法的使用", 18);
        静态方法的使用.work();
        Person.work();




    }


}

class Person {

    /**使用static修饰的属性我们认为是类的属性,共享的每一个对象，不带static修饰的属性我们认为是对象的属性
     * 。对象属性的生命周期
     * 	随着对象的创建二产生，对象如果被gc回收，属性自然也就不存在了
     *  Static类属性生命周期
     * 	类文件被载入jvm的时候就会自动的初始化static的属性，jvm销毁后就会销毁类文件，static的属性也就被销毁了。
     * */
    static int  id;

    private String name;
    private int age;

    /**类方法是在static的属性初始化完毕初始化。类方法的调用也是通过类名.方法名*/
    public static void work() {
        System.out.println("我是static 方法");
       // System.out.println(name);静态方法不能使用类属性



    };

/**对象方法是共享的，但是这个对象方法一定是创建了对象之后才能调用。对象方法的生命周期是在对象创建之后。*/
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }


    public Person(String name, int age) {
        this.name = name;
        this.age = age;

    }

}



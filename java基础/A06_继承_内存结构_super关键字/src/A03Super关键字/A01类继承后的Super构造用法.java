package A03Super关键字;

public class A01类继承后的Super构造用法 {
    public static void main(String[] args) {
        WorkPerson workPerson = new WorkPerson();

    }
}
/**父类*/
class Person{

    String  name;
    int age;

    /*1.子类实例化的过程中父类的构造器先被调用，然后再调用子类的构造器*/
    public Person() {
        System.out.println("父类无参构造器");
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("父类有参构造器");
    }
}
/**子类*/
class WorkPerson  extends  Person{
    public WorkPerson() {
        /**super()的调用必须要放在方法的第一行。*/
       //调用父类默认有参构造器
        super("周四",19);
      //  super();//调用父类默认无参构造器(当调用父类默认有参构造器  无参构造器就不会调用)
        System.out.println("子类无参构造器");
    }
}
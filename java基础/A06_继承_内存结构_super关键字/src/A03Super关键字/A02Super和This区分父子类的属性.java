package A03Super关键字;

public class A02Super和This区分父子类的属性 {
    public static void main(String[] args) {
        WorkPerson1 workPerson = new WorkPerson1();
        workPerson.name="子类名字";
        workPerson.sleep();
        workPerson.method();

        System.out.println(  workPerson.getSupername());


    }
}
/**父类*/
class Person1{

    String  name;
    int age;



    public Person1(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("父类有参构造器");
    }

    public void sleep() {
        System.out.println("我是父类的方法");

    }
}
/**子类*/
class WorkPerson1  extends  Person{
    String  name;

    public WorkPerson1() {
        //调用父类有构造器
        super("父类名字",19);


    }


    /**重写的父类的方法*/
    public void sleep() {
        System.out.println("我是子类的方法");
        System.out.println(super.name);//打印父类的属性
        System.out.println(this.name);//打印子类的属性

    }

    //
    public  void  method() {
        System.out.println(this.name+"      "+"method()");
        System.out.println(super.name+"      "+"method()");

    }

    /**返回父类的name*/
    public String  getSupername() {
        return super.name;
    }


}
public class A01this关键字 {
    public static void main(String[] args) {
       /**
        * 对象中的this和创建的对象地址是一样的
        * 创建多个工人对象,我们创建的对象地址是不一样*/
       Worker worker = new Worker();
        Worker worker1 = new Worker();
        System.out.println(worker);
        System.out.println(worker1);

    }
}

class Worker{


    /**this存在对象方法(不带static的方法是对象方法)里面

     对象方法中隐藏了this关键字，this表示调用这个方法的那个对象

     对象方法中this是可以省略的，效果是一样的
     */
    public Worker() {
        System.out.println(this);
    }

    public Worker(String name, int salary, int agt) {
        this.name = name;
        this.salary = salary;
        this.agt = agt;
    }


    String  name;
    int salary;
    int agt;







}
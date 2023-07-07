public class A02构造器 {
    public static void main(String[] args) {

        Worker1 无惨构造器 = new Worker1();
        Worker1 周先生 = new Worker1("周先生", 10, 11);
        System.out.println(周先生);

    }
}

class Worker1 {
    /**如果类存在有参的构造器的话，默认的构造器会被覆盖。如果还想要使用这个默认的构造器，就必须要显式的定义出来。*/
    //默认的无惨构造器
    public Worker1() {
        System.out.println("默认的无惨构造器调用了.");
    }


    /**
     作用：创建对象，给对象赋初始值；
     构造器本身是一个方法：
     没有返回值，也没有void
     构造器的方法名必须和类名一致
     在方法中定义要初始化的参数列表。*/
    //有惨构造器1
    public Worker1(String name, int salary) {

        this.name = name;
        this.salary = salary;
    }


    //有惨构造器2
    public Worker1(String name, int salary, int agt) {
        //构造器的调用(构造器调用构造器，被调用的构造器一定要放在第一行。)
        this(name,salary);
        this.agt = agt;
    }

    private String name;
    private int salary;
    private int agt;

    /**方法是在数据共享区*/
    @Override
    public String toString() {
        return "Worker1{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", agt=" + agt +
                '}';
    }
}
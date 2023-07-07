package A01继承的讲解;


public class A01TestExtends  {
    public static void main(String[] args) {

        TeachPHP teachPHP = new TeachPHP();
        teachPHP.setName("teachPHP");
        teachPHP.setAge(19);
        teachPHP.setMoney(10000);
        teachPHP.sleep();
        teachPHP.PHP();
        teachPHP.playBAll();


        TeachNET teachNET = new TeachNET();
        teachNET.setName("teachNET");
        teachNET.setAge(19);
        teachNET.sleep();
        teachNET.NET();


    }
}

/***    1.如果父类中包含了某些类中的共同的属性和行为，我们可以使用继承来设计程序。
        2.子类使用extends关键字继承父类的共同属性以外，子类还可以有自己特有的属性或者方法。
        3.父类更通用，子类更具体。
        4.子类只能获得父类中的非private的属性，如果想要继承就得提供公共的set和get的方法。 私有的方法	是无法继承下来的
        5.java中类只能做单继承*/


/**父类 */
class Teach {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private String name;
    private  int age;

    public void sleep() {
        System.out.println(this.name+"正在睡觉........");
    }

}
/**子类继承父类 */
class TeachPHP extends Teach {
    //子类特有属性
  private   double money;

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public void PHP() {
        System.out.println(this.getName() + "----" + "PHP"+"工资:"+money);
    }
    //子类特有方法
    public void  playBAll() {
        System.out.println(this.getName() + "----" + "PHP"+"正在打球");
    }

}
/**子类继承父类 */
class TeachNET extends Teach{
    public void NET() {
        System.out.println(this.getName() + "----" + "NET");
    }


}








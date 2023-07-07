package A02权限修饰符.A02权限修饰符不同包父子类中2;


import A02权限修饰符.A02权限修饰符不同包父子类中1.Texeall父类;

public class Texeall子类 extends Texeall父类 {

    public static void main(String[] args) {
        Texeall子类 texeall子类 = new Texeall子类();
        texeall子类.Public_Method();//公共的方法可以继承
        texeall子类.Protected_Method();//受保护的方法可以继承
        /**
       * texeall子类.默认_Method()  默认方法不能继承
       * texeall子类.Private_Method() 私有方法不能继承
       */
    }
}


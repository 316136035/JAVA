package A02_静态代理模式_lamde表达式.A01静态代理模型;

/**
 *静态代理
 *真实对象和代理对象也要实现痛一个接口
 *代理对象要代理真实对象
 * */
public class A01静态代理模型 {
    public static void main(String[] args) {
        /**真实对象*/
        You you = new You();
        /**代理对象(真实对象)*/
        WeddingCompany weddingCompany = new WeddingCompany(you);
        /***/
        weddingCompany.HappyMarry();

        /**这种写法是一样的*/
        new WeddingCompany(new You()).HappyMarry();

        new Thread(()-> {}).start();

    }
}
interface  Marry{

    void  HappyMarry();


}
/**真实角色*/
class  You  implements  Marry{
    @Override
    public void HappyMarry() {
        System.out.println("周先生要结婚了");

    }
}
/**代理角色*/
class WeddingCompany  implements  Marry{
    public WeddingCompany(Marry target) {
        this.target = target;
    }

    /**实现目标角色*/
    private  Marry  target;

    @Override
    public void HappyMarry() {

        before();
        /**真实对象*/
        this.target.HappyMarry();
        after();

    }


    private void before() {
        System.out.println("结婚之前,布置现场");
    }

    private void after() {
        System.out.println("结婚之后,结账");
    }

}
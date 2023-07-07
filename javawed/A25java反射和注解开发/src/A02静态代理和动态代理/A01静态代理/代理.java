package A02静态代理和动态代理.A01静态代理;

public class 代理  implements 代理接口 {


    //真实用户
    private 代理接口 interfacetext;

    public 代理(代理接口 interfacetext) {
        super();
        this.interfacetext = interfacetext;
    }

    @Override
    public void interface1() {

        System.out.println("收中介费");
        interfacetext.interface1();
        System.out.println("扣押金");
    }
}

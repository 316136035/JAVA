package A02静态代理和动态代理.A01静态代理;

public class 真实用户 implements 代理接口 {
    @Override
    public void interface1() {
        System.out.println("我是真实用户..");
    }
}

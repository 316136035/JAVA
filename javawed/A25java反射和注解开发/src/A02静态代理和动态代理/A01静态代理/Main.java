package A02静态代理和动态代理.A01静态代理;

public class Main {
    public static void main(String[] args) {

        真实用户 真实用户 = new 真实用户();
        代理 代理 = new 代理( 真实用户);
        代理.interface1();

        System.out.println(真实用户.getClass().getClassLoader());

    }
}

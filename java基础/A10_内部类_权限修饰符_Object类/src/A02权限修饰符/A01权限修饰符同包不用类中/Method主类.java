package A02权限修饰符.A01权限修饰符同包不用类中;

class Text {
    public void PublicMethod() {
        System.out.println("我是 public 方法");
    }

    void 默认Method() {
        System.out.println("我是 默认 方法");
    }

    private void PrivateMethod() {
        System.out.println("我是  private 方法");
    }

    protected void ProtectedMethod() {
        System.out.println("我是  protected  方法");
    }
}


public class Method主类 {
    public static void main(String[] args) {
        Text text = new Text();
        text.PublicMethod();
        text.默认Method();
        /** text.PrivateMethod()不同类私有的不能访问*/
        text.ProtectedMethod();


    }
}

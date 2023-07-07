package A01内部类_匿名内部类;

class 外部类 {
    String 外部类name;

    public void sleep() {
        System.out.println("外部类");
    }

    class 内部类 {
        String 内部类name;

        public String get内部类name() {
            return 内部类name;
        }

        public void set内部类name(String name) {
            this.内部类name = name;
        }

        public void sleep() {
            System.out.println(内部类name);
            System.out.println(外部类name);
        }
    }


}


public class A01内部类 {
    public static void main(String[] args) {

        外部类.内部类 内部类 = new 外部类().new 内部类();
        内部类.set内部类name("内部类名字");
        内部类.sleep();






    }
}

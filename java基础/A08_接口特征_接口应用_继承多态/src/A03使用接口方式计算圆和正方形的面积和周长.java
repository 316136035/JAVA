interface 面积和周长 {
    public static final double PI = 3.14;

    public double 面积(double r);

    public double 周长(double r);
}

class Yuan implements 面积和周长 {

    @Override
    public double 面积(double r) {
        return 面积和周长.PI * r * r;
    }

    @Override
    public double 周长(double r) {
        return 面积和周长.PI * 2 * r;
    }
}


class Zheng implements 面积和周长 {

    @Override
    public double 面积(double r) {
        return r * r;
    }

    @Override
    public double 周长(double r) {
        return r * 4;
    }
}


public class A03使用接口方式计算圆和正方形的面积和周长 {
    public static void main(String[] args) {

        //获取接口的属性只能这样获取
        System.out.println(面积和周长.PI);

    }
}

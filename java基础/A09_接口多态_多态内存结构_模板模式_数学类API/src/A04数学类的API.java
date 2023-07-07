public class A04数学类的API {
    public static void main(String[] args) {

        /**其他查看API  Math类*/
        System.out.println("double值比其他任何一个都更接近 e ，自然对数的基数: " + Math.PI);
        System.out.println("double值比任何其他的更接近 pi ，圆周长与其直径的比率: " + Math.E);
        System.out.println("返回值为 double绝对值: " + Math.abs(-1));
        System.out.println("把小数去掉整数加1:  " + Math.ceil(3.00001));
        System.out.println("把小数去掉:  " + Math.floor(3.14));
        System.out.println("判断2个数的大小返回大的:" + Math.max(1, 10));
        System.out.println("判断2个数的大小返回小的:" + Math.min(1, 10));
        System.out.println("计算某个数的M的幂:" + Math.pow(3, 3));
        System.out.println("四舍五入:" + Math.round(4.5));
        System.out.println("开平方" + Math.sqrt(16));
    }
}

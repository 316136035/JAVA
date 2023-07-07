public class A01可变参数 {
    public static void main(String[] args) {

        int ii = 可变参数(10);
        System.out.println( ii );
        int iii = 可变参数(new int[]{1, 2, 3, 4, 5});
        System.out.println( iii );

    }

    /**可以代表数组也可以代表单个数(当有参数的方法时会优先使用有参数的方法)*/
    public static  int 可变参数(int ...  ints) {

        int total=0;

        for (int i = 0; i < ints.length; i++) {
            total+=ints[i];
        }
        return total;
    }
}

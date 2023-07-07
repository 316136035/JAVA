public class A04求极值 {
    public static void main(String[] args) {

        int [] arr={5456,45684,561,681,651,651,6,651,564,561,594,1563,165,1};
        System.out.println(arrmax(arr));


    }

    public static int arrmax(int []arr) {
        //定义一般最大值的变量
        int max=-1;

        /**数组是引用数据类型，引用数据类型有可能发生空指向的问题 并判断数组索引不能为0*/
        if (arr!=null&&arr.length!=0){

            for (int i = 0; i < arr.length-1; i++) {
                //判断索引每一个值和max比较,比max大就更换
                if (arr[i]>max){
                    max=arr[i];

                }
            }
        }

        return max;
    }
}

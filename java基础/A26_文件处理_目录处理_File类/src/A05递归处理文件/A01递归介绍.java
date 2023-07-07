package A05递归处理文件;

public class A01递归介绍 {
    public static void main(String[] args) {
        int 递归 = 递归(5);
        System.out.println(递归);

    }

    public static  int 递归(int num) {
        int result = 1;
        if(num > 1)
            //方法的自身调用自身就是递归
            result = num * 递归(num - 1);
        return result;
    }
    }


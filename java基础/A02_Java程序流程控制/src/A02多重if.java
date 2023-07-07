public class A02多重if {
    public static void main(String[] args) {

        int score = 5001;
        ifElse(score);
        多重if(score);



    }

    /***注意：多重if当遇到第一个满足的表达式条件时执行当前的if语句，就不会再向下去执行*/
    public static void 多重if(int score) {

        if (score>=10000){
            System.out.println("A级");
        }
        if (score>=8000&&score<10000){
            System.out.println("B级");
        }
        if (score>=5000&&score<8000){
            System.out.println("C级");
        }
        if (score<500){
            System.out.println("D级");
        }




    }



    public static void ifElse(int score) {
        if (score >= 10000) {
            System.out.println("A级");
        } else if (score >= 8000) {
            System.out.println("B级");
        } else if (score >= 5000) {
            System.out.println("C级");
        } else {
            System.out.println("D级");
        }
    }




}

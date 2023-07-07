package A17_volatliede的可见性_非原子性_指令重排;

public class A03_volatile可以避免指令重排 {
    public static void main(String[] args) {
        /**什么是 指令重排 : 你写的程序，计算机并不是按照你写的那样去执行的。
         源代码-->编译器优化的重排--> 指令并行也可能会重排--> 内存系统也会重排---> 执行



         volatile可以避免指今重排 :
         内存屏障。CPU指令。作用 :
         1、保证特定的操作的执行顺序!
         2、可以保证某些变量的内存可见性 ( 利用这些特性volatile实现了可见性 )*/


    }



}

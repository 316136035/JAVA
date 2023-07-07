package A15_ForkJoin分支合并;


import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

public class A01_使用ForkJoin分支合并_计算求和 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        long l1 = System.currentTimeMillis();
        /**创建分叉加入池*/
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        /**创建递归任务*/
        ForkJoinTask<Long> forkJoinText = new ForkJoinText(1l, 10_0000_0000l);
        /**分叉加入池 执行递归任务(获取结果)*/
        Long aLong = forkJoinPool.submit(forkJoinText).get();
        System.out.println(aLong);
        long l2 = System.currentTimeMillis();
        System.out.println("任务使用时间:"+(l2-l1));

        long l3 = System.currentTimeMillis();
        /**使用并行流计算求和*/
        System.out.println(LongStream.rangeClosed(0L, 10_0000_0000).parallel().reduce(0, Long::sum));
        long l4 = System.currentTimeMillis();
        System.out.println("使用并行流计算求和:"+(l4-l3));

    }
}


class ForkJoinText extends RecursiveTask<Long> {
    private Long start;
    private Long end;

    public ForkJoinText(Long start, Long end) {
        this.start = start;
        this.end = end;
    }

    private Long temp=10000l;




    @Override
    protected Long compute() {

        Long sum = 0l;

        Long sum2 = 0l;

        if (end-start < temp) {
            for (Long i = start; i <= end; i++) {
                sum += i;

            }
            return  sum;
        } else {

            long 中间值 = (start + end) / 2;
            ForkJoinText forkJoinText1 = new ForkJoinText(start, 中间值);
            forkJoinText1.fork();/**拆分任务,把任务压入线程队列*/
            ForkJoinText forkJoinText2 = new ForkJoinText(中间值+1, end);
            forkJoinText2.fork();/**拆分任务,把任务压入线程队列*/
            sum2 = forkJoinText1.join() + forkJoinText2.join();/**结果*/
        }


        return  sum2;
    }
}
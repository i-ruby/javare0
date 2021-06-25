package work.iruby.misc;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ruby
 * @since 2021/6/12
 */
public class ThreadPoolExecutorFactory {

    static class Test {
        public static void main(String[] args) {
            ThreadPoolExecutorFactory test = new ThreadPoolExecutorFactory();
            long start = System.currentTimeMillis();
            ThreadPoolExecutor executor = ThreadPoolExecutorFactory.newThreadPoolExecutor();
            executor.prestartAllCoreThreads();
            executor.setCorePoolSize(5);
            executor.setMaximumPoolSize(10);
            long end = System.currentTimeMillis();
            System.out.println("执行用时: " + (end - start) + " ms");
        }
    }

    private void showExecutorDetail(ThreadPoolExecutor executor) {
        System.out.printf("核心线程数:%d, 活动线程数:%d, 最大线程数:%d, 池中线程数:%d",
                executor.getCorePoolSize(), executor.getActiveCount(),
                executor.getMaximumPoolSize(), executor.getPoolSize(),
                executor.getQueue().size(), executor.getQueue().remainingCapacity());
    }

    public static ThreadPoolExecutor newThreadPoolExecutor() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 5, 30, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(10), new MyThreadFactory("iruby"));
        return threadPoolExecutor;
    }

    private static class MyThreadFactory implements ThreadFactory {
        private static final AtomicInteger poolNumber = new AtomicInteger(1);
        private final ThreadGroup group;
        private final AtomicInteger threadNumber = new AtomicInteger(1);
        private final String namePrefix;

        MyThreadFactory(String name) {
            SecurityManager s = System.getSecurityManager();
            group = (s != null) ? s.getThreadGroup() :
                    Thread.currentThread().getThreadGroup();
            namePrefix = name + "-pool-" +
                    poolNumber.getAndIncrement() +
                    "-thread-";
        }

        public Thread newThread(Runnable r) {
            Thread t = new Thread(group, r,
                    namePrefix + threadNumber.getAndIncrement(),
                    0);
            if (t.isDaemon())
                t.setDaemon(false);
            if (t.getPriority() != Thread.NORM_PRIORITY)
                t.setPriority(Thread.NORM_PRIORITY);
            return t;
        }
    }
}

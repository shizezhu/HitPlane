package cn.szz.plane.utils;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * 线程池
 *
 * @author Shi Zezhu
 * @date 2020年7月31日 下午12:00:54
 */
public final class ExecutorUtils {

    private static final ExecutorService executorService = Executors.newCachedThreadPool();
    private static final ScheduledExecutorService ScheduledExecutorService = Executors.newScheduledThreadPool(50);

    public static void execute(Runnable command) {
        executorService.execute(command);
    }

    public static Future<?> submit(Runnable task) {
        return executorService.submit(task);
    }

    public static <R> Future<R> submit(Runnable task, R t) {
        return executorService.submit(task, t);
    }

    public static <R> Future<R> submit(Callable<R> task) {
        return executorService.submit(task);
    }

    public static ScheduledFuture<?> schedule(Runnable command, long delay, TimeUnit unit) {
        return ScheduledExecutorService.schedule(command, delay, unit);
    }

    public static <V> ScheduledFuture<V> schedule(Callable<V> callable, long delay, TimeUnit unit) {
        return ScheduledExecutorService.schedule(callable, delay, unit);
    }

    public static ScheduledFuture<?> scheduleAtFixedRate(Runnable command, long initialDelay, long period, TimeUnit unit) {
        return ScheduledExecutorService.scheduleAtFixedRate(command, initialDelay, period, unit);
    }

    public static ScheduledFuture<?> scheduleWithFixedDelay(Runnable command, long initialDelay, long delay, TimeUnit unit) {
        return ScheduledExecutorService.scheduleWithFixedDelay(command, initialDelay, delay, unit);
    }
}


Executor
ExecutorService
AbstractExecutorService
ThreadPoolExecutor

public interface Executor{
    void execute(Runnable command);
}

public interface ExecutorService extends Executor{
        void shutdown();
        List<Runnable> shutdownNow();
        boolean isShutdown();
        <T> Future<T> submit(Callable<T> task);
        <T> Future<T> submit(Runnable task, T result);
        Future<?> submit(Runnable task);
        <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks)
            throws InterruptedException;
}
1.shutdownNow ： 关闭线程池，返回放入了线程池，但是还没开始执行的线程。
2.submit ： 执行的任务 允许拥有返回值。
3.invokeAll ： 运行把任务放进集合中，进行批量的执行，并且能有返回值


Ps：execute 和 submit 区别：

_submit 有返回值，execute 没有返回值。_ 所以说可以根据任务有无返回值选择对应的方法。
_submit 方便异常的处理。_
如果任务可能会抛出异常，而且希望外面的调用者能够感知这些异常，
那么就需要调用 submit 方法，通过捕获 Future.get 抛出的异常。


AbstractExecutorService

public Future<?> submit(Runnable task) {
    if (task == null) throw new NullPointerException();
        RunnableFuture<Void> ftask = newTaskFor(task, null);
        execute(ftask);
        return ftask;
}


ThreadPoolExecutor

private final HashSet<Worker> workers = new HashSet<Worker>();
private final BlockingQueue<Runnable> workQueue;





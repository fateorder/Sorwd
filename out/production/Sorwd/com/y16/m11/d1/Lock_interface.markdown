Java Lock接口源码分析:

public interface Lock {
    void lock();
    void lockInterruptibly() throws InterruptedException;
    boolean tryLock();
    boolean tryLock(long time, TimeUnit unit) throws InterruptedException;
    void unlock();
    Condition newCondition();
}


lockInterruptibly 方法

这里首先需要了解两个概念才能更好的理解这个方法：

1.线程的打扰机制
2.Thread类的interrupt,interrupted,isInterrupted方法的区别


对于线程的打扰机制，_每个线程都有一个打扰标志。_

1.如果线程在sleep或wait,join，此时如果别的进程调用此进程的 interrupt（）方法，
  此线程会被唤醒并被要求处理InterruptedException；
2.如果线程在运行，则不会收到提醒。但是 此线程的 “打扰标志”会被设置。

对于 interrupt() 方法：
_不会中断一个正在运行的线程_。


对于 interrupt,interrupted,isInterrupted方法的区别：

interrupted() is static and checks the current thread.
isInterrupted() is an instance method which checks
the Thread object that it is called on.

A common error is to call a static method on an instance.
Thread myThread = ...;
if (myThread.interrupted()) {} // WRONG! This might not be checking myThread.
if (myThread.isInterrupted()) {} // Right!

Another difference is that
interrupted() also clears the status of the current thread.
In other words, if you call it twice in a row and
the thread is not interrupted between the two calls,
the second call will return false even if the first call returned true.


下面再介绍下 lockInterruptibly 方法：

当通过这个方法去获取锁时，如果线程正在等待获取锁，则这个线程能够响应中断，即中断线程的等待状态。
例如当两个线程同时通过lock.lockInterruptibly()想获取某个锁时，
假若此时线程A获取到了锁，而线程B只有在等待，
那么对线程B调用threadB.interrupt()方法能够中断线程B的等待过程。



newCondition()
用于获取一个 Conodition 对象。Condition 对象是比 Lock 更细粒度的控制。
要很好的理解 condition，个人觉得必须要知道，生产者消费者问题。
简单来说就是，我们都了解 生成者在缓冲区满了的时候需要休眠，此时会再唤起一个线程，
那么你此时唤醒的是生成者还是消费者呢，如果是消费者，很好；
但是如果是唤醒生产者，那还要再休眠，此时就浪费资源了。
condition就可以用来解决这个问题，能保证每次唤醒的都是消费者。


ReentrantLock

可重入锁：指同一个线程，外层函数获得锁之后，内层递归函数仍有获得该锁的代码，但是不受影响。

_可重入锁的最大作用就是 可以避免死锁。
_例如：A线程 有两个方法 a 和 b，其中 a 方法会调用 b 方法，假如 a，b 两个方法都需要获得锁，
那么首先 a 方法先执行，会获得锁，此时 b方法将永远获得不了锁，b 方法将一直阻塞住，
a 方法由于 b 方法没有执行完，它本身也 不释放锁，此时就会造成一个 死锁。

ReentrantLock 就是一个可重入锁。
真正使用 锁的时候，一般是 Lock lock ＝ new ReentrantLock()；然后 使用 Lock 接口方法。




ReadWriteLock
public interface ReadWriteLock {
    Lock readLock();
    Lock writeLock();
}
ReadWriteLock 可以算是 Lock 的一个细分，合理使用有利于提高效率。
比如说， 对于一个变量 i， A，B 线程同时读，那么不会造成错误的结果，所以此时是允许并发，
但是如果是同时写操作，那么则是有可能造成错误。所以真正使用的时候，可以使用
细分需要的是读锁还是写锁，再相应地进行加锁。

_从代码也可以看出，ReadWriteLock 和 Lock 没有关系，既不继承，也不是实现。_


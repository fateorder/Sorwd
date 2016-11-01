_synchronized 关键字用法（修饰类，方法，静态方法，代码块）_

除了 synchronized 的方式，
还有 lock，condition，volatile，threadlocal，atomicInteger，cas等方式。


1.修饰一个类，其作用的范围是synchronized后面括号括起来的部分，
_作用的对象是这个类的所有对象_。
2.修饰一个方法，被修饰的方法称为同步方法，其作用的范围是整个方法，
_作用的对象是调用这个方法的对象_；
3.修改一个静态的方法，其作用的范围是整个静态方法，
_作用的对象是这个类的所有对象_；
4.修饰一个代码块，被修饰的代码块称为同步语句块，其作用的范围是大括号{}括起来的代码，
_作用的对象是调用这个代码块的对象_；



_在定义接口方法时不能使用synchronized关键字。_
_构造方法不能使用synchronized关键字，但可以使用synchronized代码块来进行同步。_
_synchronized 关键字不能被继承_
。如果子类覆盖了父类的 被 synchronized 关键字修饰的方法，
那么子类的该方法只要没有 synchronized 关键字，那么就默认没有同步，也就是说，
不能继承父类的 synchronized。

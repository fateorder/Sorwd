


public static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();

threadLocal.set(new Integer(123));

threadLocal.get()




1._每个线程都有_一个 ThreadLocalMap 类型的 threadLocals 属性。
2.ThreadLocalMap 类相当于一个Map，key 是 ThreadLocal 本身，value 就是我们的值。
3.当我们通过 threadLocal.set(new Integer(123)); ，
  我们就会在这个线程中的 threadLocals 属性中放入一个键值对，
  key 是这个threadLocal.set(new Integer(123)); 的 threadlocal，value 就是值。
4.当我们通过 threadlocal.get() 方法的时候，首先会根据这个线程得到这个线程的 threadLocals 属性，
  然后由于这个属性放的是键值对，我们就可以根据键 threadlocal 拿到值。
  注意，这时候这个键 threadlocal 和 我们 set 方法的时候的那个键 threadlocal 是一样的，
  所以我们能够拿到相同的值。
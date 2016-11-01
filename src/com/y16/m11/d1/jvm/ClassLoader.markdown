



1.BootStrap Loader：它所加载的都是 JVM 中最底层的类。
2.ExtClassLoader：用于加载 Java 的一些库。
3.AppClassLoader：它主要由 java.class.path 来指定。

_采用了 双亲委托模型_


那么，在加载完 class 文件之后， ClassLoader 如何将 class 文件变成一个 java 类的。
在 ClassLoader中有一个非常重要的方法叫 findClass() 方法，
它接受要加载的类作为它的参数，在该方法中会找到class文件并且读取文件中的内容到一个 byte 数组，
然后再调用 另外一个重要的方法：defineClass()，
该方法能够把 byte 数组中的内容转化为一个相应的 Class Object。

委托机制，指先委托父转载器寻找目标类，
_只有在找不到的情况下才从自己的类路径中查找并装载类，这一点是从安全角度考虑的_，
试想如果有人编写了一个恶意的基础类，比如String类，并装载到JVM中将会引起多么可怕的后果呢。
但是，由于有了全盘负责委托机制，String类 永远是有根装载器装载，这样就避免了事件的发生。
另外，我们经常遇到的NoSuchMethodError的错误往往就是因为加载了不同版本的包造成的。


自定义类加载器可以选择
**继承ClassLoader类，重写里面的方法来实现。里面有三个重要的方法，
一个是loadClass()方法，一个是findClass()方法，一个是defineClass()方法。**

package singleton;


import com.sun.org.apache.bcel.internal.classfile.InnerClass;

import java.io.Serializable;

public class SingleTonTest {

	public static void main(String[] args) {
		//1.懒汉式单例，线程不安全
		/*SingleTonOne instance = SingleTonOne.getInstance();
		SingleTonOne instance1 = SingleTonOne.getInstance();
		System.out.println(instance);
		System.out.println(instance1);*/

		//2.懒汉式单例，线程安全
		/*SingleTonTwo instance = SingleTonTwo.getInstance();
		SingleTonTwo instance1 = SingleTonTwo.getInstance();
		System.out.println(instance);
		System.out.println(instance1);*/

		//3.饿汉式单例
		/*SingleTonThree instance = SingleTonThree.getInstance();
		SingleTonThree instance1 = SingleTonThree.getInstance();
		System.out.println(instance);
		System.out.println(instance1);*/

		SingleTonSix instance = SingleTonSix.instance;
		SingleTonSix instance1 = SingleTonSix.instance;
		System.out.println(instance);
		System.out.println(instance1);
		System.out.println(instance == instance1);

	}
}


/**
 *  懒汉式单例，线程不安全
 */
class SingleTonOne{
	private static SingleTonOne instance;

	private SingleTonOne(){}

	public static SingleTonOne getInstance(){
		if(instance == null){
			instance = new SingleTonOne();
		}
		return instance;
	}

}


/**
 * 懒汉式单例，线程安全
 * 这种写法能够在多线程中很好的工作，而且看起来它也具备很好的lazy loading，
 * 但是，遗憾的是，效率很低，99%情况下不需要同步。
 */
class SingleTonTwo{

	private static SingleTonTwo instance;

	private SingleTonTwo(){}

	public static synchronized SingleTonTwo getInstance(){
		if (instance == null){
			instance = new SingleTonTwo();
		}
		return instance;
	}
}


/**
 *  饿汉式
 *  这种方式基于classloder机制,避免了多线程的同步问题，不过，
 *  instance在类装载时就实例化，虽然导致类装载的原因有很多种，
 *  在单例模式中大多数都是调用getInstance方法， 但是也不能确定有其他的方式
 *  （或者其他的静态方法）导致类装载，这时候初始化instance显然没有达到lazy loading的效果。
 */
class SingleTonThree{
	private static SingleTonThree instance = new SingleTonThree();

	private SingleTonThree(){}

	public static SingleTonThree getInstance(){
		return instance;
	}
}


/**
 * 饿汉式的变种：跟第三种差不多，都是在类初始化即实例化instance
 */
class SingleTonFour{

	private static SingleTonFour instance;

	static {
		instance = new SingleTonFour();
	}

	private SingleTonFour(){}

	public static SingleTonFour getInstance(){
		return instance;
	}
}


/**
 * 静态内部类
 * 这种方式同样利用了classloder的机制来保证初始化instance时只有一个线程，
 * 它跟第三种和第四种方式不同的是（很细微的差别）：第三种和第四种方式是只要Singleton类被装载了，
 * 那么instance就会被实例化（没有达到lazy loading效果），而这种方式是Singleton类被装载了，
 * instance不一定被初始化。因为SingletonHolder类没有被主动使用，只有显示通过调用getInstance方法时，
 * 才会显示装载SingletonHolder类，从而实例化instance。想象一下，如果实例化instance很消耗资源，
 * 我想让他延迟加载，另外一方面，我不希望在Singleton类加载时就实例化，
 * 因为我不能确保Singleton类还可能在其他的地方被主动使用从而被加载，那么这个时候实例化instance显然是不合适的。
 * 这个时候，这种方式相比第三和第四种方式就显得很合理。
 */
class SingleTonFive{

	private SingleTonFive(){}

	public static final SingleTonFive getInstance() {
		return SingletonHolder.instance;
	}

	private static class SingletonHolder{
		public static final SingleTonFive instance = new SingleTonFive();
	}
}


/**
 *  枚举
 *  这种方式是Effective Java作者Josh Bloch 提倡的方式，它不仅能避免多线程同步问题，
 *  而且还能防止反序列化重新创建新的对象，可谓是很坚强的壁垒啊
 */
enum SingleTonSix{
	instance
}


/**
 * 双重校验锁
 */
class SingleTonSeven{
	private volatile static SingleTonSeven singleton;
	private SingleTonSeven (){}
	public static SingleTonSeven getSingleton() {
		if (singleton == null) {
			synchronized (SingleTonSeven.class) {
				if (singleton == null) {
					singleton = new SingleTonSeven();
				}
			}
		}
		return singleton;
	}
}


/*
总结：
1.如果单例由不同的类装载器装入，那便有可能存在多个单例类的实例。假定不是远端存取，
		例如一些servlet容器对每个servlet使用完全不同的类装载器，
		这样的话如果有两个servlet访问一个单例类，它们就都会有各自的实例。

2.如果Singleton实现了java.io.Serializable接口，那么这个类的实例就可能被序列化和复原。
		不管怎样，如果你序列化一个单例类的对象，接下来复原多个那个对象，那你就会有多个单例类的实例。

		为什么序列化可以破坏单例？
		答：序列化会通过反射调用无参数的构造方法创建一个新的对象。

		如何防止序列化/反序列化破坏单例模式？
		答：只要在Singleton类中定义readResolve就可以解决该问题。
		如下：
 */
public class SingletonEight implements Serializable {
	private volatile static SingletonEight singleton;
	private SingletonEight (){}
	public static SingletonEight getSingleton() {
		if (singleton == null) {
			synchronized (SingletonEight.class) {
				if (singleton == null) {
					singleton = new SingletonEight();
				}
			}
		}
		return singleton;
	}

	private Object readResolve() {
		return singleton;
	}
}
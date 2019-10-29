package functionalinterface;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;

import java.util.function.Supplier;

@FunctionalInterface
public interface FunctionalInterfaceTest {

	/*定义：
	(1).只能有一个抽象方法
	(2).可以有静态方法和默认方法，因为这两种方法都是已经实现的了
	(3).可以包含Object里所有能重写的方法，因为即使接口包含像String toString()这样的抽象方法，
	它的实现类也会因继承了Object类，而再次对接口中的toString()方法进行实现。*/

	//只能有一个抽象方法，除了Object类里能被重写的方法
	void test1(String arg);

	//加上这个抽象方法接口就会报错（编译不通过）
//	void test2();

	default void test3(String s){
		System.out.println(s);
	}

	static void test4(String arg){
		System.out.println(arg);
	}

	//这是Object里能重写的方法，所以编译可以通过
	boolean equals(Object obj);
	//这是Object里能重写的方法，所以编译可以通过
	String toString();
}

class UseTest{

	public UseTest(){}

	public static void main(String[] args) {
//		FunctionalInterfaceTest f = a -> System.out.println(a);

		/*
		Java8 允许你使用 :: 来调用静态方法和构造函数的引用。上面的代码展示了如何引用一个静态方法
		。也可以通过同样的方法来引用对象方法*/
		//1.下面是上面方法的静态方法引用
		FunctionalInterfaceTest f = System.out::println;
		f.test1("hello wind");
		f.test3("yellow");
		FunctionalInterfaceTest.test4("red");

		//2.对象方法的引用
		UseTest useTest = new UseTest();
		FunctionalInterfaceTest testClass = useTest::testClass;
		FunctionalInterfaceTest testClass1 = new UseTest()::testClass;
		testClass.test1("testClass");
		testClass1.test1("testClass1");
		//3.构造函数的引用
		Supplier<Person> person = Person::new;
	}


	public void testClass(String str){
		System.out.println("testClass=="+str);
	}
}

class Person{

	String name;

	public Person(){}
	public Person(String name){
		this.name = name;
	}

}
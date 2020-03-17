package itface;

//可以用@FunctionalInterface注解来判断一个接口是不是函数式接口
@FunctionalInterface
public interface NoneReturnNoneParameter {
	
	void test();
	//jdk1.8及以后版本才支持接口面定义default和static方法
	default void testMethod() {
		System.out.println("这是接口里面的default方法");
	}
}

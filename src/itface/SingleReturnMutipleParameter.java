package itface;

//可以用@FunctionalInterface注解来判断一个接口是不是函数式接口
public interface SingleReturnMutipleParameter {
	int test(int a,int b);
	public static void testMethod() {
		System.out.println("这是接口里面的static方法");
	}
}

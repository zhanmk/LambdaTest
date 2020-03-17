package itfaceImpl;

import itface.NoneReturnMutipleParameter;
import itface.NoneReturnNoneParameter;
import itface.SingleReturnMutipleParameter;
import itface.SingleReturnSingleParameter;

public class TestA{
	
	private static int c =100;
	
	public static void test() {
		System.out.println("TestA static 方法");
	}
	
	public static int getAbs(int a,int b) {
		if(a >= b) {
			return a-b;
		}
		return b-a;
	}
	
	public void noneReturnNoneParameter(){
		System.out.println("无参无返回值");
	}
	
	

	public static void main(String[] args) {
		
		NoneReturnNoneParameter lambda1 = () -> {
			System.out.println("无参无返回lambda");
		};
		
		lambda1.test();
		lambda1.testMethod();
		
		System.out.println("=============================");
		
		SingleReturnMutipleParameter lambda2 = (int x,int y) -> {
			return x + y;
		};
		System.out.println(lambda2.test(10, 20));
		SingleReturnMutipleParameter.testMethod();
		
		//精简版_参数部分写法1，可以把参数的类型省略，有多个参数时，要么全部省略，不能只省略其中一个参数的类型
		SingleReturnMutipleParameter lambda2_1 = (x,y) -> {
			return x + y;
		};
		System.out.println(lambda2_1.test(10, 20));
		
		//精简版_参数部分写法2，有且只有1个参数时，参数的括号可以省略（0个参数或多个参数都不能省略）
		SingleReturnSingleParameter lambda2_2 = x ->{
			return x*x;
		};
		System.out.println(lambda2_2.test(100));
		
		//精简版_方法体部分写法3，如果方法体里面只有一行代码，那么{}可以省略不写
		NoneReturnMutipleParameter lambda2_3 = (x,y,z) -> System.out.println(x+y+z);
		lambda2_3.test(1, 2, 3);
		
		//精简版_方法体部分写法4，如果方法体里面只有一行代码，且该行代码是一个return语句，那么{}可以省略不写但是return也必须省略
//		SingleReturnMutipleParameter lambda2_4 = (x,y) -> {
//			return x + y;
//		};
		SingleReturnMutipleParameter lambda2_4 = (x,y) -> x+y ;
		System.out.println(lambda2_4.test(1, 2));
		
		System.out.println("=============================");
		
		/**
		 * lambda函数引用:
		 * 将一个接口的实现，引用到一个已经存在的方法上，此时，使用这个已经存在方法来实现接口中的抽象方法
		 */
		SingleReturnMutipleParameter lambda3 = (x,y) -> {
			if(x >= y) {
				return x-y;
			}
			return y-x;
		};
		int result = lambda3.test(2, 8);
		System.out.println(result);
		
		SingleReturnMutipleParameter lambda3_1 = (x,y) -> TestA.getAbs(x, y);
		int result3_1 = lambda3_1.test(10, 1);
		System.out.println(result3_1);
		
		
		//引用静态方法(类名::函数名)
		SingleReturnMutipleParameter lambda3_2 = TestA::getAbs;
		int result3_2 = lambda3_2.test(100, 200);
		System.out.println(result3_2);
		
		//引用非静态方法(对象::函数名)
		TestA a = new TestA();
		NoneReturnNoneParameter lambda4 = a::noneReturnNoneParameter;
		lambda4.test();
		
		
//		TestA a = new TestA();
//		//黄色提示：静态变量或静态方法应该直接使用类名调用
//		System.out.println(TestA.c+"//"+a.c);
//		a.test();
//		TestA.test();
	}
}

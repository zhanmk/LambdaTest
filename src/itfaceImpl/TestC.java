package itfaceImpl;

import java.util.function.BiConsumer;
/**
 * 方法引用：getter和setter
 * 
 * @author 41996
 *
 */
public class TestC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dog dog = new Dog();
		dog.setName("小白");
		
		//lambda表达式  getter方法引用
		GetName lambda = Dog::getName;
		System.out.println(lambda.getDogName(dog));
		
		//lambda表达式  setter方法引用
		SetName lambda2 = Dog::setName;
		lambda2.setDogName(dog, "小黑");
		System.out.println(dog.getName());
		
		BiConsumer< Dog,String> studentNameSetter = Dog :: setName;
		studentNameSetter.accept(dog, "小黄");
		System.out.println(dog.getName());
		
		SetNameGeneric<Dog,String> setNameGeneric = Dog::setName;
		setNameGeneric.setDogName(dog, "小花");
		System.out.println(dog.getName());
	}

}

interface GetName{
	String getDogName(Dog dog);
}
interface SetName{ 
	void setDogName(Dog dog,String name);
}
//该接口类似于BiConsumer接口
interface SetNameGeneric<T,U>{
	void setDogName(T t,U u);
}


class Dog{
	
	private String name;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}

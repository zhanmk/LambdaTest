package itfaceImpl;

public class TestB {
	
	
	public static void main(String[] args) {
		A a0 = ()->new Student();
		//lambda表达式，函数引用 无参构造函数（接口A中的getStudent()方法的参数个数0需要和Student类中的无参构造方法一致）
		A a = Student::new;
		
		B b = (name,age)->new Student(name,age);
		//lambda表达式，函数引用 有参构造函数 （接口B中的getStudent(String name,int age)方法的形参需要和Student类中的有参构造方法的形参一致）
		B b2 = Student::new;
		System.out.println(a0.getStudent().toString());
		System.out.println(a.getStudent().toString());
		System.out.println(b.getStudent("lisi",25).toString());
		System.out.println(b2.getStudent("zhangsan", 26).toString());
		
	}

}




interface A{
	Student getStudent();
}
interface B{
	Student getStudent(String name,int age);
}


class Student{
	
	private String name;
	private int age;
	
	public Student() {
		System.out.println("无参");
	}
	
	public Student(String name,int age) {
		this.name = name;
		this.age = age;
		System.out.println("有参");
	}
	

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}
	
	
	
	
	
}

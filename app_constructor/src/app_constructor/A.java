package app_constructor;

public class A {

	A(char x){
		System.out.println(x);
	}
	A(int a, char n){
	System.out.println(a);
	System.out.println(n);
	}
	A(int x, float f){
		System.out.println(x);
		System.out.println(f);
	}
	public static void main(String[] args) {
		A a1= new A('p');
		A a2= new A(30, 'j');
		A a3= new A(100, 100.09f);
	}
}

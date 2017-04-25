package alp3_mulzer_u04_dequeue;

public class Main {
	public static void main(String[] args){
		A a = new A();
		a.a();
		//a.b();
		B b = new B();
		b.a();
		b.b();
		I i;
		//i = new I();
		i = a;
		i.a();
		//i.b();
		i = b;
		i.a();
		//i.b();
		//b = i;
		b = (B)i;
		a = (A)i;
		
	}
}

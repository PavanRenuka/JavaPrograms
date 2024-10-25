package programs;

public class Fibonacci {
public static void main(String[] args) {
	int f=1, s=2, t, count=5;
	
	System.out.println(f+" "+s);
	for(int i=1; i<count; i++) {
		t=f+s;
	System.out.println(""+t);	
	f=s;
	s=t;
	}
}
}

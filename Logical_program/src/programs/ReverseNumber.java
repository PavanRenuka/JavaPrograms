package programs;
// Reverse of a number using while loop
public class ReverseNumber {
public static void main(String[] args) {
	int n=565, r, sum=0;
	
	while(n!=0) {
		r=n%10;
		sum=(sum*10)+r;
		n=n/10;
			
	}
	System.out.println(sum);
}
}

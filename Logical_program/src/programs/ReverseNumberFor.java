package programs;
// Reverse given number using for loop
public class ReverseNumberFor {
	public static void main(String[] args) {
		int n=542566, r, sum=0;
		for(; n!=0; n=n/10) {
			r=n%10;
			sum=(sum*10)+r;
			
		}
		System.out.println("The reverse of the number is:"+sum);
	}

}

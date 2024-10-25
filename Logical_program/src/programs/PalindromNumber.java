package programs;

public class PalindromNumber {
	public static void main(String[] args) {
		int r, sum=0, temp;
		int n=8598;
		temp=n;
		while(n>0) {
			r=n%10;
			sum=(sum*10)+r;
			n=n%10;
		}
		if(temp==sum) {
			System.out.println("N is palindrom");
		}else {
			System.out.println("Not palindrom");
		}
	}

}

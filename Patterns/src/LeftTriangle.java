
public class LeftTriangle {
public static void main(String[] args) {
	int row=5;
	for(int i=1; i<row; i++) {
		for(int j=2*(row-i); j>=0; j--) {
			System.out.println(" ");
			for(int k=0; k<i; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
}

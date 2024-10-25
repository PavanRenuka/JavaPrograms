

public class A{
	public static void main(String[] args) {
		String str="my name is sumant";
		String[] s = str.trim().split(" ");
		System.out.println(s.length);
		for (String x : s) {
			System.out.println(x);
		}
	}
}
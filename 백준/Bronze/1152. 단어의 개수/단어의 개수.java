import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int l = s.length();
		int ans = 0;
		if (s.charAt(0) != ' ') ans++;
		for (int i=1; i<l; i++) {
			if (s.charAt(i)!=' ' && s.charAt(i-1)==' ') ans++;
		}
		System.out.println(ans);
	}
}

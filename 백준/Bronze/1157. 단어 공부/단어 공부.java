import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		s = s.toUpperCase();
		int l = s.length();
		int[] fre = new int[26];
		for (int i=0; i<l; i++) {
			fre[s.charAt(i)-'A']++;
		}
		int mx = 0;
		char ans = '?';
		for (int i=0; i<26; i++) {
			if (mx < fre[i]) {
				mx = fre[i];
				ans = (char)('A'+i);
			}
			else if (mx == fre[i]) {
				ans = '?';
			}
		}
		System.out.println(ans);
	}
}
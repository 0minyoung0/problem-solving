import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		int cnt = 0;
		int ans = 665;
		
		while (cnt < n) {
			if (check(++ans)) {
				cnt++;
			}
		}
		
		System.out.println(ans);
	}
	private static boolean check(int num) {
		int cnt = 0;
		while (num != 0) {
			if (num % 10 == 6) cnt++;
			else cnt = 0;
			
			if (cnt == 3) return true;
			
			num /= 10;
		}
		return false;
	}
}
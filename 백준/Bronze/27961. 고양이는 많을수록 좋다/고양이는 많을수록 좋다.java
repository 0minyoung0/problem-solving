import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		long n = Long.parseLong(br.readLine());
		
		if (n == 0) {
			System.out.println(0);
			return;
		}
		
		long rabbit = 1;
		int ans = 1;
		
		while (n > rabbit) {
			rabbit *= 2;
			ans++;
		}
		
		System.out.println(ans);
	}
}

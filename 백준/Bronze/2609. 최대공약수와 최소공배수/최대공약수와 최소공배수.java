import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		int gcd = GCD(a, b);
		int lcm = a * b / gcd;
		
		System.out.println(gcd);
		System.out.println(lcm);
		
	}
	private static int GCD(int a, int b) {
		if (b == 0) return a;
		
		return GCD(b, a%b);
	}
}

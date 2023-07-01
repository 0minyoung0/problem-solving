import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		for (int m=1; m<n; m++) {
			if (n == make(m)) {
				System.out.println(m);
				return;
			}
		}
		System.out.println(0);
	}
	private static int make(int m) {
		int temp = m;
		while (temp != 0) {
			m += temp % 10;
			temp /= 10;
		}
		return m;
	}
}
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		final int r = 31;
		final int M = 1234567891;
		
		int L = Integer.parseInt(br.readLine());
		
		char[] input = br.readLine().toCharArray();
		
		long ans = 0;
		for (int i=0; i<L; i++) {
			long temp = input[i] - 'a' + 1;
			for (int j=0; j<i; j++) {
				temp = (temp * r) % M;
			}
			ans = (ans + temp) % M;
		}
		
		System.out.println(ans);
		
	}
}
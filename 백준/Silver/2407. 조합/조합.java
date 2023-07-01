import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		BigInteger ans1 = BigInteger.ONE;
		BigInteger ans2 = BigInteger.ONE;
		
		for (int i=0; i<m; i++) {
			ans1 = ans1.multiply(new BigInteger(String.valueOf(n-i)));
			ans2 = ans2.multiply(new BigInteger(String.valueOf(i+1)));
		}
		
		System.out.println(ans1.divide(ans2));
	}
}

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		char[] input = sc.next().toCharArray();
		
		int ans = 0;
		for (int i=0; i<N; i++) {
			ans += input[i] - '0';
		}
		System.out.println(ans);
	}
}

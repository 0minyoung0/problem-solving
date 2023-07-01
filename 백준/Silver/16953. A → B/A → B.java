import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int ans = 1;
		while (B != 0) {
			if (B % 2 == 0) B /= 2;
			else if (B % 10 == 1) B /= 10;
			else {
				System.out.println(-1);
				return;
			}
			ans++;
			
			if (A == B) {
				System.out.println(ans);
				return;
			}
		}
		
		System.out.println(-1);
	}
}
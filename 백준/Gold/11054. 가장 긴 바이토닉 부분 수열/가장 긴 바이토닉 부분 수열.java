import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 수열 A의 크기
		int N = Integer.parseInt(br.readLine());
		
		// 수열 A
		int[] A = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		// 오름차순 길이
		int[] ASC = new int[N];
		Arrays.fill(ASC, 1);
		for (int i=1; i<N; i++) {
			for (int j=0; j<i; j++) {
				if (A[j] < A[i] && ASC[j] + 1 > ASC[i]) {
					ASC[i] = ASC[j] + 1;
				}
			}
		}
		
		// 내림차순 길이
		int[] DESC = new int[N];
		Arrays.fill(DESC, 1);
		for (int i=N-2; i>=0; i--) {
			for (int j=i+1; j<N; j++) {
				if (A[i] > A[j] && DESC[i] < DESC[j] + 1) {
					DESC[i] = DESC[j] + 1;
				}
			}
		}
		
		// 최대 길이 구하기
		int ans = 1;
		for (int i=0; i<N; i++) {
			if (ans < ASC[i] + DESC[i] - 1) {
				ans = ASC[i] + DESC[i] - 1;
			}
		}
		System.out.println(ans);
	}
}

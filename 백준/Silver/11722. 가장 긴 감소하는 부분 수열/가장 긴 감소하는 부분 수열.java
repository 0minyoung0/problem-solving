import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 수열의 크기
		int N = Integer.parseInt(br.readLine());
		
		// 수열 A
		int[] A = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		// 뒤에서부터 순회하며 최대 길이 구하기
		int ans = 1;
		int[] length = new int[N];
		Arrays.fill(length, 1);
		for (int i=N-2; i>=0; i--) {
			for (int j=i+1; j<N; j++) {
				if (A[i] > A[j] && length[i] < length[j] + 1) {
					length[i] = length[j] + 1;
					if (ans < length[i]) {
						ans = length[i];
					}
				}
			}
		}
		
		// 답 출력
		System.out.println(ans);
		
	}
}

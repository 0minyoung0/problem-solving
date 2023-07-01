import java.io.*;
import java.util.*;

public class Main {
	static int N, ans;
	static int[] A, idx;
	static boolean[] isUsed;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 배열 A에 들어있는 정수의 개수
		N = Integer.parseInt(br.readLine());
		
		// 배열 A
		A = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		// 정수의 순서를 인덱스로 저장할 배열
		idx = new int[N];
		
		// 정수의 사용 여부를 저장할 배열
		isUsed = new boolean[N];
		
		// 백트래킹으로 식의 최대값 구하기
		backTracking(0);
		
		// 답 출력
		System.out.println(ans);
	}
	private static void backTracking(int k) {
		if (k == N) {
			int temp = 0;
			for (int i=0; i<N-1; i++) {
				temp += Math.abs(A[idx[i]]-A[idx[i+1]]);
			}
			if (ans < temp) ans = temp;
			return;
		}
		
		for (int i=0; i<N; i++) {
			if (isUsed[i]) continue;
			
			// k번째 숫자를 i번 인덱스의 숫자로 결정
			isUsed[i] = true;
			idx[k] = i;
			
			// 다음 재귀 호출
			backTracking(k+1);
			
			// 원상복구
			isUsed[i] = false;
		}
	}
}
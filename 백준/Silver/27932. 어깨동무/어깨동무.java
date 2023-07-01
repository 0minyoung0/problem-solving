import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 고려대를 응원하는 학생 수
		int n = Integer.parseInt(st.nextToken());
		// 지친 사람 수의 최대값
		int k = Integer.parseInt(st.nextToken());
		
		// 학생의 키
		int[] height = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<n; i++) {
			height[i] = Integer.parseInt(st.nextToken());
		}
		
		// 이진검색으로 찾기
		int s = 0;
		int e = 1000000000;
		while (s < e) {
			int mid = (s + e) / 2;
			
			// 점수차가 mid일때 지친 사람 수 세기
			int cnt = 0;
			boolean[] chk = new boolean[n];
			for (int i=0; i<n-1; i++) {
				if (Math.abs(height[i] - height[i+1]) > mid) {
					if (!chk[i]) {
						chk[i] = true;
						cnt++;
					}
					if (!chk[i+1]) {
						chk[i+1] = true;
						cnt++;
					}
				}
			}
			
			// 지친 사람 수가 k명 이하일 때
			if (cnt <= k) e = mid;
			// 지침 사람 수가 k명보다 많을 때
			else s = mid+1;
			
		}
		
		// 답 출력
		System.out.println(s);
		
	}
}

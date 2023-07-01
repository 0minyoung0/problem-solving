import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 지방의 수
		int N = Integer.parseInt(br.readLine());
		
		// 각 지방의 예산 요청
		int[] req = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			req[i] = Integer.parseInt(st.nextToken());
		}
		
		// 총 예산
		int M = Integer.parseInt(br.readLine());
		
		// 가능한 최대의 상한액 찾기
		int s = 1;
		int e = 100000;
		while (s < e) {
			int mid = (s + e + 1) / 2;
			
			// 현재의 상한액으로 필요한 금액
			int cost = 0;
			for (int i=0; i<N; i++) {
				if (req[i] < mid) cost += req[i];
				else cost += mid;
			}
			
			// 불가능한 경우 - 상한액 감소
			if (cost > M) e = mid - 1;
			
			// 가능한 경우 - 더 큰 상한액에 대해 가능한지 확인
			else s = mid;
		}
		
		// 답 출력
		int ans = 0;
		for (int i=0; i<N; i++) {
			if (ans >= req[i]) continue;
			if (req[i] >= s) ans = s;
			else ans = req[i];
		}
		System.out.println(ans);
		
	}
}
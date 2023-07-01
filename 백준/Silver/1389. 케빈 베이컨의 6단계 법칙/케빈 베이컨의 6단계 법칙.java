import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		final int INF = 100000000;
		
		// 유저의 수
		int N = Integer.parseInt(st.nextToken());
		// 친구 관계의 수
		int M = Integer.parseInt(st.nextToken());
		
		// 친구 관계를 배열로 저장
		// x와 y의 친구 단계 수
		int[][] level = new int[N+1][N+1];
		for (int i=1; i<=N; i++) {
			Arrays.fill(level[i], INF);
			level[i][i] = 0;
		}
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			level[A][B] = level[B][A] = 1;
		}
		
		
		// 플로이드 알고리즘
		for (int i=1; i<=N; i++) {
			for (int s=1; s<=N; s++) {
				if (i == s) continue;
				for (int e=1; e<=N; e++) {
					if (i == e || s == e) continue;
					if (level[s][e] > level[s][i] + level[i][e]) {
						level[s][e] = level[s][i] + level[i][e];
					}
				}
			}
		}
		
		// 케빈 베이컨의 수가 가장 작은 사람 구하기
		int ans = -1;
		int cnt = INF;
		for (int i=1; i<=N; i++) {
			int temp = 0;
			for (int j=1; j<=N; j++) {
				temp += level[i][j];
			}
			if (cnt > temp) {
				ans = i;
				cnt = temp;
			}
		}
		
		// 답 출력
		System.out.println(ans);
		
	}
}

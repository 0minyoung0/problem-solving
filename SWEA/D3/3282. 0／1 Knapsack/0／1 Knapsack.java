import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 테스트 케이스의 수
		int T = Integer.parseInt(br.readLine());
		
		// 테이블 초기화
		int[][] table = new int[101][1001];
		
		// 물건의 부피 배열
		int[] V = new int[101];
		// 물건의 가치 배열
		int[] C = new int[101];
		
		// 테스트 케이스별로 실행
		for (int tc=1; tc<=T; tc++) {
			
			// 물건의 개수 N, 가방의 부피 K
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			// 물건의 부피와 가치 배열 채우기
			for (int i=1; i<=N; i++) {
				st = new StringTokenizer(br.readLine());
				V[i] = Integer.parseInt(st.nextToken());
				C[i] = Integer.parseInt(st.nextToken());
			}
			
			// 테이블 채우기
			for (int i=1; i<=N; i++) {
				for (int j=1; j<=K; j++) {
					if (j < V[i]) {
						table[i][j] = table[i-1][j];
						continue;
					}
					table[i][j] = table[i-1][j-V[i]] + C[i] > table[i-1][j] ? table[i-1][j-V[i]] + C[i] : table[i-1][j];
				}
			}
			
			// 답 출력
			System.out.println("#" + tc + " " + table[N][K]);
		}
	}
}

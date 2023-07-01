import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 미로의 크기
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// 사탕 정보
		int[][] map = new int[N+1][M+1];
		for (int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=1; j<=M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 순차적으로 순회하면서 DP!
		// 대각선으로 이동하는게 더 나은 경우는 없으므로 고려 안함
		int[][] DP = new int[N+1][M+1];
		for (int i=1; i<=N; i++) {
			for (int j=1; j<=M; j++) {
				DP[i][j] = Math.max(DP[i-1][j], DP[i][j-1]) + map[i][j];
			}
		}
		
		// 답 출력
		System.out.println(DP[N][M]);
	}
}
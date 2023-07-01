import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		// 표의 크기
		int N = Integer.parseInt(st.nextToken());
		// 합을 구해야 하는 횟수
		int M = Integer.parseInt(st.nextToken());
		
		// 표에 채워져있는 수로 (1,1)에서 (x,y)까지의 누적합을 table[x][y]에 저장
		int[][] table = new int[N+1][N+1];
		for (int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=1; j<=N; j++) {
				table[i][j] = table[i-1][j] + table[i][j-1] - table[i-1][j-1]
											+ Integer.parseInt(st.nextToken());
			}
		}
		
		// (x1,y1)부터 (x2,y2)까지의 합
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			sb.append(table[x2][y2]-table[x1-1][y2]-table[x2][y1-1]+table[x1-1][y1-1]).append("\n");
		}
		
		// 답 출력
		System.out.println(sb);
	}
}

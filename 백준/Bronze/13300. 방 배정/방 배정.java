import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 학생 수
		int N = Integer.parseInt(st.nextToken());
		// 한 방에 배정 할 수 있는 최대 인원 수
		int K = Integer.parseInt(st.nextToken());
		
		// 학생을 성별, 학생별로 카운팅
		int[][] student = new int[2][7];
		while (N-- > 0) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());
			student[S][Y]++;
		}
		
		// 답 계산
		int ans = 0;
		for (int i=0; i<2; i++) {
			for (int j=1; j<=6; j++) {
				if (student[i][j] == 0) continue;
				ans += (student[i][j] - 1) / K + 1;
			}
		}
		System.out.println(ans);
	}
}

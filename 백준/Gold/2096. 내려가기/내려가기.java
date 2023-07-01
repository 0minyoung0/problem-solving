import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		// 숫자표
		int[][] nums = new int[N][3];
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<3; j++) {
				nums[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 첫 줄 초기 값 세팅
		int[][] ans = new int[N][3];
		for (int j=0; j<3; j++) {
			ans[0][j] = nums[0][j];
		}
		
		// DP로 최대 점수 구하기
		for (int i=1; i<N; i++) {
			ans[i][0] = Math.max(ans[i-1][0], ans[i-1][1]) + nums[i][0];
			ans[i][1] = Math.max(ans[i-1][0], Math.max(ans[i-1][1], ans[i-1][2])) + nums[i][1];
			ans[i][2] = Math.max(ans[i-1][1], ans[i-1][2]) + nums[i][2];
		}
		
		System.out.print(Math.max(ans[N-1][0], Math.max(ans[N-1][1], ans[N-1][2])) + " ");
		
		// DP로 최소 점수 구하기
		for (int i=1; i<N; i++) {
			ans[i][0] = Math.min(ans[i-1][0], ans[i-1][1]) + nums[i][0];
			ans[i][1] = Math.min(ans[i-1][0], Math.min(ans[i-1][1], ans[i-1][2])) + nums[i][1];
			ans[i][2] = Math.min(ans[i-1][1], ans[i-1][2]) + nums[i][2];
		}
		
		System.out.print(Math.min(ans[N-1][0], Math.min(ans[N-1][1], ans[N-1][2])));
	}
}

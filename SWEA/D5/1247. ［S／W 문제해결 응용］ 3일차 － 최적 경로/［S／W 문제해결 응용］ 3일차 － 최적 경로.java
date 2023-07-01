import java.util.*;

public class Solution {
	static int N, ans;
	static int[][] inputCoo, coo;
	static boolean[] isUsed;
	public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	
    	// 테스트 케이스의 수
    	int T = sc.nextInt();
    	
    	// 각 테스트 케이스 별로 실행
    	for (int t=1; t<=T; t++) {
    		
    		// 고객의 수
    		N = sc.nextInt();
    		
    		inputCoo = new int[N+2][2];
    		coo = new int[N+2][2];
    		
    		// 회사 좌표
    		for (int i=0; i<2; i++) {
    			inputCoo[0][i] = sc.nextInt();
    		}
    		coo[0] = inputCoo[0];
    		// 집 좌표
    		for (int i=0; i<2; i++) {
    			inputCoo[N+1][i] = sc.nextInt();
    		}
    		coo[N+1] = inputCoo[N+1];
    		// 고객 좌표
    		for (int i=1; i<=N; i++) {
    			for (int j=0; j<2; j++) {
    				inputCoo[i][j] = sc.nextInt();
    			}
    		}
    		
    		// 고른 고객의 좌표를 표시할 boolean 배열
    		isUsed = new boolean[N+1];
    		
    		// ans를 Integer.MAX_VALUE로 초기화
    		ans = Integer.MAX_VALUE;
    		
    		// 백트래킹
    		backTracking(0, 0);
    		
    		// 답 출력
    		System.out.println("#" + t + " " + ans);
    	}
    }
	
	private static void backTracking(int k, int sum) {
		if (sum > ans) return;
		
		if (k == N) {
			if (ans > sum + calDis(coo[N], coo[N+1])) {
				ans = sum + calDis(coo[N], coo[N+1]);
			}
			return;
		}
		
		// k+1번째로 들릴 집 고르기
		for (int i=1; i<=N; i++) {
			if (isUsed[i]) continue;
			isUsed[i] = true;
			coo[k+1] = inputCoo[i];
			backTracking(k+1, sum + calDis(coo[k], coo[k+1]));
			isUsed[i] = false;
		}
	}
	
	private static int calDis(int[] c1, int[] c2) {
		return Math.abs(c1[0]-c2[0]) + Math.abs(c1[1]-c2[1]);
	}
}
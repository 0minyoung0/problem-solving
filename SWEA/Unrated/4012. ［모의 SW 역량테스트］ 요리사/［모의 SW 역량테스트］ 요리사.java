import java.util.Scanner;

public class Solution {
	static int n, ans;
    static int[][] arr;
    static boolean[] with1;
	public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
         
        // 테스트 케이스의 개수
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
        	// 식재료의 수
        	n = sc.nextInt();
            
        	// 식재료 궁합 정보
        	arr = new int[n+1][n+1];
        	for (int i=1; i<=n; i++) {
        		for (int j=1; j<=n; j++) {
        			arr[i][j] = sc.nextInt();
        		}
        	}
        	
        	// 재료가 1번 재료와 같은 음식에 들어가는지 저장할 boolean 배열
        	with1 = new boolean[n+1];
        	with1[1] = true;
        	
        	// 백트래킹
        	ans = Integer.MAX_VALUE;
        	BT(1, 1);
        	
        	System.out.println("#" + t + " " + ans);
        }
    }
	// pre : 이전에 고른 재료, select : 현재 고른 재료 수
	private static void BT(int pre, int select) {
		// n/2개를 모두 골랐다면 계산하기!
		if (select == n/2) {
			int temp = 0;
			for (int i=1; i<n; i++) {
				if (!with1[i]) continue;
				for (int j=i+1; j<=n; j++) {
					if (!with1[j]) continue;
					temp += arr[i][j] + arr[j][i];
				}
			}
			for (int i=2; i<n; i++) {
				if (with1[i]) continue;
				for (int j=i+1; j<=n; j++) {
					if (with1[j]) continue;
					temp -= arr[i][j] + arr[j][i];
				}
			}
			
			// temp의 절대값 구하기
			if (temp < 0) temp = -temp;
			
			// ans 갱신
			if (ans > temp) ans = temp;
			
			return;
		}
		
		// 1번재료와 같은 음식에 들어갈 재료 고르기
		for (int i=pre+1; i<=n; i++) {
			with1[i] = true;
			BT(i, select + 1);
			with1[i] = false;
		}
	}
}
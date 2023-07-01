import java.util.Scanner;

public class Solution {
	static int n, l, ans;
	static int[] taste, kcal;
	public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
         
        // 테스트 케이스의 개수
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
        	// 재료의 수
        	n = sc.nextInt();
        	
        	// 제한 칼로리
        	l = sc.nextInt();
            
        	// 식재료 정보 (맛, 칼로리)
        	taste = new int[n];
        	kcal = new int[n];
        	for (int i=0; i<n; i++) {
        		taste[i] = sc.nextInt();
        		kcal[i] = sc.nextInt();
        	}
        	
        	// 백트래킹
        	ans = 0;
        	BT(0, 0, 0);
        	
        	System.out.println("#" + tc + " " + ans);
        }
    }
	private static void BT(int k, int tSum, int kSum) {
		if (k == n) {
			if (tSum > ans) ans = tSum;
			return;
		}
		
		BT(k+1, tSum, kSum);
		if (kSum + kcal[k] > l) return;
		BT(k+1, tSum+taste[k], kSum+kcal[k]);
	}
}
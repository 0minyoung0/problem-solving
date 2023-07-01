import java.util.Scanner;

public class Solution {
	static int n, k, ans;
	static int[] A;
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
         
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
        	n = sc.nextInt();
        	k = sc.nextInt();
             
        	// 수열 A
        	A = new int[n];
        	for (int i=0; i<n; i++) {
        		A[i] = sc.nextInt();
        	}
             
        	// 백트래킹으로 답 출력
        	ans = 0;
        	BT(0, 0);
        	System.out.println("#" + t + " " + ans);
        }
    }
    private static void BT(int idx, int sum) {
    	if (idx == n) {
    		if (sum == k) {
    			ans++;
    		}
    		return;
    	}
    	
    	BT(idx+1, sum);
    	BT(idx+1, sum+A[idx]);
    }
}
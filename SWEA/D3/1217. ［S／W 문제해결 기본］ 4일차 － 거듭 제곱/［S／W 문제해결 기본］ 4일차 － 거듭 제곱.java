import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
        
    	// 테스트 케이스 개수
    	int T = 10;
        while (T-- != 0) {
        	// 테스트 케이스 번호
        	int t = sc.nextInt();
        	
        	// n의 m승 구하기
        	int n = sc.nextInt();
        	int m = sc.nextInt();
        	
        	// 거듭제곱 구하기
        	int ans = power(n, m);
        	
        	// 답 출력
        	System.out.println("#" + t + " " + ans);
        }
    }
	private static int power(int n, int m) {
		if (m == 0) {
			return 1;
		}
		int x = power(n, m/2);
		
		if (m % 2 == 0) return x*x;
		return x*x*n;
	}
}
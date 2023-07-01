import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 10^6이하의 숫자가 소수인지 판별해주는 배열
        boolean[] isNotPrime = new boolean[1000001];
        isNotPrime[1] = true;
        for (int i=2; i<=1000; i++) {
        	if (!isNotPrime[i]) {
	        	for (int j=2; j*i<=1000000; j++) {
	        		isNotPrime[j*i] = true;
	        	}
        	}
        }
        
        // 테스트케이스 개수
        int T = sc.nextInt();
        
        // 테스트케이스 별로 실행
        for (int t=1; t<=T; t++) {
        	int d = sc.nextInt();
        	int a = sc.nextInt();
        	int b = sc.nextInt();
        	
        	int ans = 0;
        	
        	for (int i=a; i<=b; i++) {
        		if (!isNotPrime[i]) {
        			String s = String.valueOf(i);
        			if (s.contains(String.valueOf(d))) {
        				ans++;
        			}
        		}
        	}
        	
        	System.out.println("#" + t + " " + ans);
        }
    }
}
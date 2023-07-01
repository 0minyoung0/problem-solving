import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 테스트케이스 개수
        int T = sc.nextInt();
        
        // 테스트케이스 별로 실행
        for (int t=1; t<=T; t++) {
        	// 농장의 크기
        	int n = sc.nextInt();
        	
        	// 수확한 농작물의 가치
        	int ans = 0;
        	
        	// 위에 절반 탐색
        	for (int i=0; i<n/2; i++) {
        		String s = sc.next();
        		for (int j=n/2-i; j<=n/2+i; j++) {
        			ans += s.charAt(j) - '0';
        		}
        	}
        	// 아래 절반 탐색
        	for (int i=n/2; i<n; i++) {
        		String s = sc.next();
        		for (int j=-n/2+i; j<3*n/2-i; j++) {
        			ans += s.charAt(j) - '0';
        		}
        	}
        	
        	// 답 출력
        	System.out.println("#" + t + " " + ans);
        }
    }
}
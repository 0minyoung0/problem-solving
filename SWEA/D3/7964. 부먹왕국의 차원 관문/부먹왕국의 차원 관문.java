import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	
    	// 테스트 케이스 개수
        int T = sc.nextInt();
        
        for (int t=1; t<=T; t++) {
        	// 부먹 왕국의 도시 수
        	int n = sc.nextInt();
        	// 제한거리
        	int limit = sc.nextInt();
        	
        	// 연속해서 0이 나온 횟수를 세기 위한 변수 선언
        	int cnt = 0;
        	
        	// 새로 건설한 차원 관문의 수를 세기 위한 변수 선언
        	int ans = 0;
        	
        	// 차원 관문 세기
        	for (int i=0; i<n; i++) {
        		if (sc.nextInt() == 0) {
        			cnt++;
        			if (cnt >= limit) {
        				ans++;
        				cnt = 0;
        			}
        		}else {
        			cnt = 0;
        		}
        	}
            
            // 답 출력
            System.out.println("#" + t + " " + ans);
        }
    }
}
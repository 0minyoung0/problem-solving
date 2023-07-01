import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 테스트 케이스의 수
        int T = sc.nextInt();
        
        // 테스트 케이스 별로 실행
        for (int t=1; t<=T; t++) {
        	String s = sc.next();
        	
        	int ans = 0;
        	if (s.charAt(0) == '1') {
        		ans++;
        	}
        	for (int i=1; i<s.length(); i++) {
        		if (s.charAt(i) != s.charAt(i-1)) {
        			ans++;
        		}
        	}
        	
        	// 정답 출력
        	System.out.println("#" + t + " " + ans);
        }
    }
}
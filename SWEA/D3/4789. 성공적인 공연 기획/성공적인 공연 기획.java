import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 테스트케이스 개수
        int T = sc.nextInt();
        
        // 테스트케이스 별로 실행
        for (int t=1; t<=T; t++) {
        	// 고용해야 할 사람의 수
        	int ans = 0;
        	// 현재 기립박수치는 사람 수
        	int cur = 0;
        	
        	// 기립박수 조건
        	String s = sc.next();
        	
        	// 순회하면서 고용해야 할 사람의 수 계산
        	for (int i=0; i<s.length(); i++) {
        		if (cur < i) {
        			// 사람이 모자르면 고용하기
        			ans += i - cur;
        			cur = i;
        		}
        		cur += s.charAt(i) - '0';
        	}
        	
        	System.out.println("#" + t + " " + ans);
        }
    }
}
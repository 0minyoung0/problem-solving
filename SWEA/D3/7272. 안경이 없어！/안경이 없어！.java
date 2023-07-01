import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	
    	// 탐색을 위한 델타배열
    	int[] dx = {-1,-1,-1,0,0,1,1,1};
    	int[] dy = {-1,0,1,-1,1,-1,0,1};
    	
    	// 테스트 케이스 개수
        int T = sc.nextInt();
        
        for (int t=1; t<=T; t++) {
        	String s1 = sc.next();
        	String s2 = sc.next();
        	
        	// 문자열 길이가 다른 경우
        	if (s1.length() != s2.length()) {
        		System.out.println("#" + t + " DIFF");
        		continue;
        	}
        	
        	// 문자 각각에 대해 같은지 체크
        	boolean terminated = false;
        	for (int i=0; i<s1.length(); i++) {
        		if (func(s1.charAt(i)) != func(s2.charAt(i))) {
        			System.out.println("#" + t + " DIFF");
        			terminated = true;
        			break;
        		}
        	}
        	if (terminated) continue;
        	
        	// 답 출력
        	System.out.println("#" + t + " SAME");
        }
    }
    private static char func(char ch) {
    	if (ch == 'B') {
    		return 'B';
    	}
    	
    	String s = String.valueOf(ch);
    	if ("ADOPQR".contains(s)) {
    		return 'A';
    	}
    	
    	return 'C';
    }
}
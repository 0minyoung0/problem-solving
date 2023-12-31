import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        
        for (int t=1; t<=T; t++) {
        	// 쇠막대기와 레이저 배치
        	String s = br.readLine();
        	// char 배열에 데이터 저장
        	char[] arr = new char[s.length()];
        	for (int i=0; i<s.length(); i++) {
        		arr[i] = s.charAt(i);
        	}
	        		
	        // '('는 스택에 보관
	        // ')'는 앞의 데이터가 뭔지에 따라 의미가 다름
	        // '('이후의 ')'는 레이저, ')'이후의 ')'는 막대의 끝
	        // 한번 순회하면서 막대의 닫는 괄호를 ']'로 바꿔서 다루기 편하게 하자
	        // 역순으로 순회
	        for (int i=s.length()-1; i>0; i--) {
	        	if (s.charAt(i) == ')' && s.charAt(i-1) == ')') {
	        		arr[i] = ']';
	        	}
	        }
	        
	        // 레이저는 레이저의 '('를 제외한 기존 스택의 크기만큼 ans에 더해줌
	        // 막대의 끝은 1만큼 ans에 더해줌
	        
	        // 데이터를 보관할 스택을 덱으로 선언
	        Deque<Character> stack = new ArrayDeque<>();
	        int ans = 0;
	        for (int i=0; i<s.length(); i++) {
	        	if (arr[i] == '(') {
	        		stack.offerFirst('(');
	        	}
	        	else if (arr[i] == ')') { // 레이저
	        		stack.poll();
	        		ans += stack.size();
	        	}
	        	else { // ']' 막대
	        		stack.poll();
	        		ans += 1;
	        	}
	        }
	        System.out.println("#" + t + " " + ans);
        }
    }
}
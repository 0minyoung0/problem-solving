import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 테스트 케이스 별로 실행
        for (int t=1; t<=10; t++) {
        	sc.nextLine();
        	// 괄호 문자열
        	String s = sc.nextLine();

        	// 괄호의 유효성 여부를 체크하기 위한 스택을 덱으로 선언
        	Deque<Character> stack = new ArrayDeque<>();
        	
        	// 괄호의 유효성 여부를 저장할 int 변수 선언
        	int ans = 1;
        	
        	for (int i=0; i<s.length(); i++) {
        		// 현재의 괄호가 여는 괄호일때
        		if (stack.isEmpty() || s.charAt(i) == '(' || s.charAt(i) == '['
        				 || s.charAt(i) == '{' || s.charAt(i) == '<') {
        			stack.offerFirst(s.charAt(i));
        		}
        		// 닫는 괄호일때
        		else if (s.charAt(i) == ')') {
        			// 스택이 비어있거나 짝이 맞는 괄호가 아닐 경우
        			if (stack.isEmpty() || stack.peek() != '(') {
        				ans = 0;
        				break;
        			}
        			// 짝이 맞는 괄호 제거
        			stack.poll();
        		}
        		else if (s.charAt(i) == ']') {
        			// 스택이 비어있거나 짝이 맞는 괄호가 아닐 경우
        			if (stack.isEmpty() || stack.peek() != '[') {
        				ans = 0;
        				break;
        			}
        			// 짝이 맞는 괄호 제거
        			stack.poll();
        		}
        		else if (s.charAt(i) == '}') {
        			// 스택이 비어있거나 짝이 맞는 괄호가 아닐 경우
        			if (stack.isEmpty() || stack.peek() != '{') {
        				ans = 0;
        				break;
        			}
        			// 짝이 맞는 괄호 제거
        			stack.poll();
        		}
        		else { // s.charAt(i) == '>'
        			// 스택이 비어있거나 짝이 맞는 괄호가 아닐 경우
        			if (stack.isEmpty() || stack.peek() != '<') {
        				ans = 0;
        				break;
        			}
        			// 짝이 맞는 괄호 제거
        			stack.poll();
        		}
        	}
        	// 괄호의 문자열을 모두 순회했는데 스택이 비어있지 않으면 유효하지 않음
        	if (!stack.isEmpty()) {
        		ans = 0;
        	}
        	
        	// 정답 출력
        	System.out.println("#" + t + " " + ans);
        }
    }
}
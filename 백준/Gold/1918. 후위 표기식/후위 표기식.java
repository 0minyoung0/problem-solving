import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 스택을 ArrayDeque으로 선언
		Deque<Character> stack = new ArrayDeque<>();
		
		// 중위 표기식
		char[] input = br.readLine().toCharArray();
		
		// 후위 표기식으로 변환
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<input.length; i++) {
			char c = input[i];
			
			switch(c) {
			
			// 더하기, 빼기인 경우
			case '+':
			case '-':
				// 여는 괄호가 아니라면 스택에서 다 빼냄
				while (!stack.isEmpty() && stack.peek() != '(') {
					sb.append(stack.poll());
				}
				stack.offerFirst(c);
				break;
			
			// 곱하기, 나누기인 경우
			case '*':
			case '/':
				// 곱하기나 나누기인 경우 스택에서 빼냄
				while (!stack.isEmpty() && (stack.peek() == '*' || stack.peek() == '/')) {
					sb.append(stack.poll());
				}
				stack.offerFirst(c);
				break;
			
			// 여는 괄호인 경우
			case '(':
				stack.offerFirst(c);
				break;
			
			// 닫는 괄호인 경우
			case ')':
				// 여는 괄호가 나올때까지 스택에서 빼냄
				while (!stack.isEmpty() && stack.peek() != '(') {
					sb.append(stack.poll());
				}
				stack.poll();
				break;
				
			// 알파벳 대문자인 경우
			default:
				sb.append(c);
				break;
			}
		}
		while (!stack.isEmpty()) {
			sb.append(stack.poll());
		}
		
		// 후위 표기식 출력
		System.out.println(sb);
	}
}

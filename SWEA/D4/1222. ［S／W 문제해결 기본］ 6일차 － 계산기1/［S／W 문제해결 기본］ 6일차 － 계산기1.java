import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 테스트 케이스에 따라 진행
		for (int t=1; t<=10; t++) {
			// 수식 문자열 길이
			int l = Integer.parseInt(sc.nextLine());
			// 수식 문자열을 char 배열에 저장
			char[] arr = sc.nextLine().toCharArray();
			
			// 수식 문자열을 후위 표기식으로 바꾸기 위한 스택을 덱으로 선언
			Deque<Character> stack = new ArrayDeque<>();
			// 후위 표기식으로 바꾼 수식을 저장할 char List
			List<Character> list = new ArrayList<>();
			
			// 수식 문자열을 후위 표기식으로 바꾸기
			for (int i=0; i<l; i++) {
				switch (arr[i]) {
					// '+'인 경우
					case '+':	
						while (!stack.isEmpty() && stack.peek() == '+') {
							list.add(stack.poll());
						}
						stack.offerFirst('+');
						break;
						
					// 숫자인 경우 바로 출력
					default:	
						list.add(arr[i]);
						break;
				}
			}
			
			// 스택이 비어있지 않다면 남은 데이터 모두 출력
			while(!stack.isEmpty()) {
				list.add(stack.poll());
			}
			
			// 후위 표기식을 계산하기위한 스택을 덱으로 선언
			Deque<Integer> stack2 = new ArrayDeque<>();
			for (int i=0; i<list.size(); i++) {
				switch (list.get(i)) {
					// + 연산
					case '+':	
						stack2.offerFirst(stack2.poll() + stack2.poll());
						break;
						
					// 숫자
					default:
						stack2.offerFirst(list.get(i) - '0');
				}
			}
			
			// 답 출력
			System.out.println("#" + t + " " + stack2.poll());
		}
	}
}

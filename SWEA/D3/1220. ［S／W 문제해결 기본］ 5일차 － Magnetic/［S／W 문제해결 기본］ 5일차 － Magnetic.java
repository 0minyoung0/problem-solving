import java.util.Scanner;
import java.util.Deque;
import java.util.ArrayDeque;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 테스트케이스 별로 실행
        for (int t=1; t<=10; t++) {
        	// 테이블 한 변의 길이
        	int n = sc.nextInt();
        	
        	// 배열에 테이블 상태 저장
        	char[][] table = new char[n][n];
        	for (int i=0; i<n; i++) {
        		for (int j=0; j<n; j++) {
        			table[i][j] = sc.next().charAt(0);
        		}
        	}
        	
        	// 자성체 개수를 세기 위한 덱 선언
        	Deque<Character> dq = new ArrayDeque<>();
        	
        	// 남는 자성체 개수를 저장할 변수
        	int ans = 0;
        	
        	// 각 열에 대해 남는 자성체 개수 세기
        	for (int i=0; i<n; i++) {
        		// 덱에 자성체 정보 넣기
        		for (int j=0; j<n; j++) {
        			if (table[j][i] != '0') {
        				dq.offer(table[j][i]);
        			}
        		}
        		
        		// 덱의 앞에서 S극 자성체를, 덱의 뒤에서 N극 자성체를 제거하기
        		while (!dq.isEmpty() && dq.peek() == '2') {
        			dq.poll();
        		}
        		while (!dq.isEmpty() && dq.peekLast() == '1') {
        			dq.pollLast();
        		}

        		// 남아있는 교착상태 개수를 ans에 더해주기
        		while (!dq.isEmpty()) {
        			// 덱의 앞에서 N극 자성체 덩어리와 S극 자성체 덩어리를 제거하고 ans에 +1
        			while (!dq.isEmpty() && dq.peek() == '1') {
        				dq.poll();
        			}
        			while (!dq.isEmpty() && dq.peek() == '2') {
        				dq.poll();
        			}
        			ans++;
        		}

        	}
        	// 계산된 남은 자성체 개수를 출력
        	System.out.println("#" + t + " " + ans);
        }
    }
}
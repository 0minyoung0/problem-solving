import java.util.Scanner;
import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 테스트 케이스 별로 실행
        for (int t=1; t<=10; t++) {
        	int n = sc.nextInt();

        	// 숫자를 저장할 배열
        	int[] arr = new int[8];
        	
        	// 15로 나눈 가장 작은 몫을 저장할 변수 선언
        	int quo = Integer.MAX_VALUE;
        	
        	// 8사이클 돌리면 15씩 빠지니까 그렇게 빼도 되는 사이클 구하기
        	for (int i=0; i<8; i++) {
        		arr[i] = sc.nextInt();
        		quo = Math.min(quo, arr[i] % 15);
        	}
        	
        	// 탐색에 사용할 큐를 덱으로 선언
        	Deque<Integer> q = new ArrayDeque<>();
        	
        	// 8 * quo 사이클 돌린셈 치고 큐에 넣기
        	for (int i=0; i<8; i++) {
        		arr[i] -= quo * 15;
        		q.offer(arr[i]);
        	}
        	
        	// while문 탈출을 위한 boolean 선언
        	boolean isEnd = false;
        	
        	while (!isEnd) {
        		for (int i=1; i<=5; i++) {
        			// 종료조건에 해당 될 때
        			if (q.peek() <= i) {
        				q.poll();
        				q.offer(0);
        				isEnd = true;
        				break;
        			}
        			// 종료조건에 해당되지 않을 때
        			q.offer(q.poll() - i);
        		}
        	}
        	
        	// 정답 출력
        	System.out.print("#" + t + " ");
        	while(!q.isEmpty()) {
        		System.out.print(q.poll() + " ");
        	}
        	System.out.println();
        }
    }
}
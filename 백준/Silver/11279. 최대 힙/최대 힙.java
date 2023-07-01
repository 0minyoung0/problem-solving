import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// 연산의 개수
		int N = Integer.parseInt(br.readLine());
		
		// 최대 힙
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		
		// 연산 처리
		while (N-- > 0) {
			int oper = Integer.parseInt(br.readLine());
			
			// 제거 연산
			if (oper == 0) {
				
				// 비어있는 경우
				if (pq.isEmpty()) sb.append("0\n");
				// 가장 큰 값 출력
				else sb.append(pq.poll()).append("\n");
			}
			
			// 추가 연산
			else {
				pq.offer(oper);
			}
		}
		
		System.out.println(sb);
	}
}

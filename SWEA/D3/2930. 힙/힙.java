import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 테스트 케이스의 수
		int T = Integer.parseInt(br.readLine());
		
		// 최대 힙
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		
		// 테스트 케이스별로 실행
		for (int tc=1; tc<=T; tc++) {
			
			// 출력문을 저장할 스트링빌더
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc);
			
			// 최대 힙 초기화
			pq.clear();
			
			// 수행해야하는 연산의 수
			int N = Integer.parseInt(br.readLine());
			
			// 연산 수행
			while (N-- > 0) {
				
				// 연산 처리
				st = new StringTokenizer(br.readLine());
				switch(st.nextToken()) {
				
				// 삽입 연산
				case "1":
					pq.offer(Integer.parseInt(st.nextToken()));
					break;
					
				// 삭제 연산
				case "2":
					sb.append(" ");
					if (pq.isEmpty()) sb.append("-1");
					else sb.append(pq.poll());
					break;
				default:
					break;
				}
			}
			
			// 답 출력
			System.out.println(sb);
		}
	}
}

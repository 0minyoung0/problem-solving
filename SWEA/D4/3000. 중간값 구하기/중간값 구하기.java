import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 테스트 케이스의 수
		int T = Integer.parseInt(br.readLine());
		
		// 사용할 최대힙과 최소힙
		PriorityQueue<Integer> pq1 = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> pq2 = new PriorityQueue<>();
		
		// 테스트 케이스별로 실행
		for (int tc=1; tc<=T; tc++) {
			
			// 답을 저장할 변수
			int ans = 0;
			
			st = new StringTokenizer(br.readLine());
			
			// 추가로 숫자를 적는 횟수
			int N = Integer.parseInt(st.nextToken());
			
			// 최대힙에 경근이가 처음에 공책에 쓴 자연수 넣기
			pq1.offer(Integer.parseInt(st.nextToken()));
			
			// 추가로 숫자 적고 중간값을 ans에 더하기
			while (N-- > 0) {
				
				st = new StringTokenizer(br.readLine());
				int n1 = Integer.parseInt(st.nextToken());
				int n2 = Integer.parseInt(st.nextToken());
				
				pq1.offer(Math.min(n1, n2));
				pq2.offer(Math.max(n1, n2));

				while (pq1.peek() > pq2.peek()) {
					pq2.offer(pq1.poll());
					pq1.offer(pq2.poll());
				}
				
				ans = (ans + pq1.peek()) % 20171109;
			}
			
			// 답 출력
			System.out.println("#" + tc + " " + ans);
			
			// 최대힙과 최소힙 초기화
			pq1.clear();
			pq2.clear();
		}
	}
}

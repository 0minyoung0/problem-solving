import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 테스트 케이스 개수
		int T = Integer.parseInt(br.readLine());
		
		// 테스트 케이스 별로 실행
		while (T-- > 0) {
			
			// 소설을 구성하는 장의 수
			int K = Integer.parseInt(br.readLine());
			
			// 소설을 저장할 우선순위 큐
			PriorityQueue<Long> pq = new PriorityQueue<>();
			
			// 답을 저장할 변수
			long ans = 0;
			
			// 파일의 크기 저장
			st = new StringTokenizer(br.readLine());
			for (int i=0; i<K; i++) {
				pq.offer(Long.parseLong(st.nextToken()));
			}
			
			// 파일 합치기
			while (pq.size() > 1) {
				long newFile = pq.poll() + pq.poll();
				ans += newFile;
				pq.offer(newFile);
			}
			
			// 답 출력
			System.out.println(ans);
		}

	}
}
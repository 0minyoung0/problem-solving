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
			
			st = new StringTokenizer(br.readLine());
			// 건물의 개수
			int N = Integer.parseInt(st.nextToken());
			// 건설순서 규칙의 총 개수
			int K = Integer.parseInt(st.nextToken());
			
			// 각 건물 건설에 걸리는 시간
			int[] D = new int[N+1];
			st = new StringTokenizer(br.readLine());
			for (int i=1; i<=N; i++) {
				D[i] = Integer.parseInt(st.nextToken());
			}
			
			// 건설순서 규칙
			List<Integer>[] list = new List[N+1];
			for (int i=1; i<=N; i++) {
				list[i] = new ArrayList<>();
			}
			int[] indegree = new int[N+1];
			while (K-- > 0) {
				st = new StringTokenizer(br.readLine());
				int X = Integer.parseInt(st.nextToken());
				int Y = Integer.parseInt(st.nextToken());
				list[X].add(Y);
				indegree[Y]++;
			}
			
			// 건설중인 건물을 저장할 우선순위 큐
			PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
				public int compare(int[] o1, int[] o2) {
					if (o1[0] != o2[0]) return o1[0] - o2[0];
					return o1[1] - o2[1];
				}
			});
			
			// 승리하기 위해 건설해야 할 건물의 번호
			int W = Integer.parseInt(br.readLine());
			
			// indegree가 0인 건물 힙에 추가
			for (int i=1; i<=N; i++) {
				if (indegree[i] == 0) pq.offer(new int[] {D[i], i});
			}
			
			// 건물 W를 건설완료 하는데 드는 최소시간
			int ans = 0;
			
			// 시뮬레이션
			while (!pq.isEmpty()) {
				int[] cur = pq.poll();
				ans = cur[0];
				
				// 종료 조건
				if (cur[1] == W) break;
				
				for (int nx : list[cur[1]]) {
					if (--indegree[nx] != 0) continue;
					pq.offer(new int[] {ans+D[nx], nx});
				}
			}
			
			// 답 출력
			System.out.println(ans);
		}
	}
}
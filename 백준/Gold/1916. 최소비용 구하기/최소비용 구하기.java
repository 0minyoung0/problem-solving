import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		final int INF = 1000000000;
		
		// 도시의 개수
		int N = Integer.parseInt(br.readLine());
		
		// 버스의 개수
		int M = Integer.parseInt(br.readLine());
		
		// 버스 정보를 인접 리스트로 저장
		List<int[]>[] bus = new List[N+1];
		for (int i=1; i<=N; i++) {
			bus[i] = new ArrayList<>();
		}
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			bus[a].add(new int[] {c, b});
		}
		
		// 구간 출발점과 도착점의 도시 번호
		st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		
		// 출발점에서의 거리 정보를 저장할 배열
		int[] ans = new int[N+1];
		for (int i=1; i<=N; i++) {
			ans[i] = INF;
		}
		ans[s] = 0;
		
		// 우선순위큐에 출발점 넣기
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				if (o1[0] != o2[0]) return o1[0] - o2[0];
				return o1[1] - o2[1];
			}
		});
		pq.offer(new int[] {0, s});
		
		// 다익스트라
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			
			if (cur[0] != ans[cur[1]]) continue;
			
			for (int[] adj : bus[cur[1]]) {
				if (ans[adj[1]] <= ans[cur[1]] + adj[0]) continue;
				ans[adj[1]] = ans[cur[1]] + adj[0];
				pq.offer(new int[] {ans[adj[1]], adj[1]});
			}
		}
		
		// 답 출력
		System.out.println(ans[d]);
	}
}

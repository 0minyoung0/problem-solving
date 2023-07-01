import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 역의 수
		int N = Integer.parseInt(st.nextToken());
		// 한 하이퍼튜브가 서로 연결하는 역의 개수
		int K = Integer.parseInt(st.nextToken());
		// 하이퍼튜브의 개수
		// 하이퍼튜브 번호는 N+1 ~ N+M
		int M = Integer.parseInt(st.nextToken());
		
		// N이 1이면 조기 종료
		if (N == 1) {
			System.out.println(1);
			return;
		}
		
		// 연결 정보를 인접 리스트로 나타냄
		List<Integer>[] list = new List[N+M+1];
		for (int i=1; i<=N+M; i++) {
			list[i] = new ArrayList<>();
		}
		
		// 하이퍼 튜브 정보
		for (int i=N+1; i<=N+M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<K; j++) {
				int station = Integer.parseInt(st.nextToken());
				list[station].add(i);
				list[i].add(station);
			}
		}
		
		// 1번 노드에서부터 BFS
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(1);
		int[] dis = new int[N+M+1];
		dis[1] = 1;
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			// 인접한 노드에 대해서 처리
			for (int nx : list[cur]) {
				
				// 방문한 노드인 경우 continue
				if (dis[nx] > 0) continue;
				
				// N번 노드인 경우
				if (nx == N) {
					
					// 답 출력 후 리턴
					System.out.println(dis[cur] / 2 + 1);
					return;
				}
				
				// 큐에 넣고 거리 표시
				q.offer(nx);
				dis[nx] = dis[cur] + 1;
			}
		}
		
		// 갈 수 없는 경우
		System.out.println(-1);
	}
}
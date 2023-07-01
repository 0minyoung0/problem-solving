import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 헛간의 개수
		int N = Integer.parseInt(st.nextToken());
		
		// 양방향 길의 개수
		int M = Integer.parseInt(st.nextToken());
		
		// 양방향 길 정보를 인접 리스트로 저장
		List<Integer>[] road = new List[N+1];
		for (int i=1; i<=N; i++) {
			road[i] = new ArrayList<>();
		}
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			road[A].add(B);
			road[B].add(A);
		}
		
		// BFS를 위한 Queue
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(1);
		
		// 거리를 저장할 int 배열
		int[] dis = new int[N+1];
		Arrays.fill(dis, -1);
		dis[1] = 0;
		
		// 최대 거리를 저장할 변수
		int mxDis = 1;
		
		// 1번 헛간부터 BFS 돌면서 거리 재기
		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int nx : road[cur]) {
				if (dis[nx] >= 0) continue;
				q.offer(nx);
				dis[nx] = dis[cur] + 1;
				if (mxDis < dis[nx]) mxDis = dis[nx];
			}
		}
		
		// 최대 거리를 가지는 헛간 정보 찾기
		boolean findFirst = false;
		int cnt = 1;
		for (int i=1; i<=N; i++) {
			if (dis[i] == mxDis) {
				if (!findFirst) {
					System.out.print(i + " ");
					findFirst = true;
				}
				else cnt++;
			}
		}
		System.out.print(mxDis + " ");
		System.out.println(cnt);
	}
}
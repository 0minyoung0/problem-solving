import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 전체 사람의 수
		int n = Integer.parseInt(br.readLine());
		
		// 촌수를 계산해야하는 서로 다른 두 사람의 번호
		st = new StringTokenizer(br.readLine());
		int p1 = Integer.parseInt(st.nextToken());
		int p2 = Integer.parseInt(st.nextToken());
		
		// 부모 자식들 간의 관계의 수
		int m = Integer.parseInt(br.readLine());
		
		// 부모 자식간의 관계를 인접 리스트로 저장
		List<Integer>[] relationship = new List[n+1];
		for (int i=1; i<=n; i++) {
			relationship[i] = new ArrayList<>();
		}
		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			relationship[x].add(y);
			relationship[y].add(x);
		}
		
		// p1과 p2의 촌수를 저장할 변수
		int ans = -1;
		
		// p1에서부터 BFS해서 p2까지의 거리 구하기
		Queue<Integer> q = new ArrayDeque<>();
		int[] dis = new int[n+1];
		q.offer(p1);
		dis[p1] = 1;
		find: while(!q.isEmpty()) {
			int cur = q.poll();
			for (int nx : relationship[cur]) {
				if (dis[nx] > 0) continue;
				if (nx == p2) {
					ans = dis[cur];
					break find;
				}
				q.offer(nx);
				dis[nx] = dis[cur] + 1;
			}
		}
		
		// 답 출력
		System.out.println(ans);
		
	}
}

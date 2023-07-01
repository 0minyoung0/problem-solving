import java.io.*;
import java.util.*;

public class Main {
	static int[] p;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 컴퓨터의 수
		int N = Integer.parseInt(br.readLine());
		
		// 연결할 수 있는 선의 수
		int M = Integer.parseInt(br.readLine());
		
		// 선을 저장할 우선순위 큐
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
			public int compare(int[] o1, int[] o2) {
				if (o1[0] != o2[0]) return o1[0] - o2[0];
				if (o1[1] != o2[1]) return o1[1] - o2[1];
				return o1[2] - o2[2];
			}
		});
		
		// 선을 우선 순위큐에 저장
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			pq.offer(new int[] {c, a, b});
		}
		
		// 부모 배열
		p = new int[N+1];
		for (int i=1; i<=N; i++) {
			p[i] = i;
		}
		
		// 모든 컴퓨터를 연결하는데에 필요한 최소 비용
		int ans = 0;
		
		// 크루스칼
		int cnt = 0;
		while (cnt != N-1) {
			int[] cur = pq.poll();
			if (!union(cur[1], cur[2])) continue;
			ans += cur[0];
			cnt++;
		}
		
		// 답 출력
		System.out.println(ans);
	}
	private static boolean union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if (x == y) return false;
		
		p[Math.max(x, y)] = Math.min(x, y);
		return true;
	}
	private static int find(int x) {
		if (x == p[x]) return x;
		return p[x] = find(p[x]);
	}
}
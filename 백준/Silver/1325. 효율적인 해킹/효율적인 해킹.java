import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 컴퓨터의 개수
		int N = Integer.parseInt(st.nextToken());
		
		// 신뢰하는 관계의 개수
		int M = Integer.parseInt(st.nextToken());
		
		// 신뢰하는 관계를 인접리스트로 표현
		List<Integer>[] graph = new List[N+1];
		for (int i=1; i<=N; i++) {
			graph[i] = new ArrayList<>();
		}
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			// B를 해킹하면 A도 해킹 가능
			graph[B].add(A);
		}
		
		// 가장 많이 해킹한 컴퓨터의 수를 저장할 변수
		int hackedN = 0;
		
		// 정답을 저장할 리스트
		List<Integer> ans = new ArrayList<>();
		
		// 각 컴퓨터를 해킹했을 때를 BFS 시뮬
		for (int i=1; i<=N; i++) {
			
			// BFS를 위한 Queue
			Queue<Integer> q = new ArrayDeque<>();
			q.offer(i);
			
			// 각 컴퓨터의 해킹 여부를 체크할 boolean 배열
			boolean[] hacked = new boolean[N+1];
			hacked[i] = true;
			
			// 해킹된 컴퓨터의 수를 셀 변수
			int curHackedN = 1;
			
			// BFS 시뮬
			while (!q.isEmpty()) {
				int cur = q.poll();
				for (int nx : graph[cur]) {
					if (hacked[nx]) continue;
					q.offer(nx);
					hacked[nx] = true;
					curHackedN++;
				}
			}
			
			// 정답 갱신 여부 체크
			if (curHackedN < hackedN) continue;
			if (curHackedN > hackedN) {
				hackedN = curHackedN;
				ans.clear();
			}
			ans.add(i);
		}
		
		// 정답 출력
		Collections.sort(ans);
		StringBuilder sb = new StringBuilder();
		for (int c : ans) {
			sb.append(c).append(" ");
		}
		System.out.println(sb);
	}
}
import java.util.*;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 테스트 케이스 별로 실행
		for (int tc=1; tc<=10; tc++) {
			
			// 정점의 개수
			int V = sc.nextInt();
			// 간선의 개수
			int E = sc.nextInt();
			
			// 인접 리스트에 간선 정보 저장 + indegree 계산
			List<Integer>[] edge = new List[V+1];
			for (int i=1; i<=V; i++) {
				edge[i] = new ArrayList<>();
			}
			int[] indegree = new int[V+1];
			for (int i=0; i<E; i++) {
				int v1 = sc.nextInt();
				int v2 = sc.nextInt();
				edge[v1].add(v2);
				indegree[v2]++;
			}
			
			// indegree가 0인 정점 큐에 넣기
			Queue<Integer> q = new ArrayDeque<>();
			for (int i=1; i<=V; i++) {
				if (indegree[i] == 0) q.offer(i);
			}
			
			// BFS로 순회하며 올바른 작업 순서 출력
			System.out.print("#" + tc);
			while (!q.isEmpty()) {
				int cur = q.poll();
				System.out.print(" " + cur);
				
				for (int adj : edge[cur]) {
					if (--indegree[adj] == 0) q.offer(adj);
				}
			}
			System.out.println();
		}
	}
}

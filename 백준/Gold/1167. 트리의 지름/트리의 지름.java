import java.io.*;
import java.util.*;

public class Main {
	static int V, ans;
	static int[] parent;
	static List<int[]>[] tree;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 트리의 정점의 개수
		V = Integer.parseInt(br.readLine());
		
		// 트리의 부모 정보를 저장할 배열
		parent = new int[V+1];
		
		// 트리의 간선 정보를 인접 리스트에 저장
		tree = new List[V+1];
		for (int i=1; i<=V; i++) {
			tree[i] = new ArrayList<>();
		}
		for (int i=1; i<=V; i++) {
			st = new StringTokenizer(br.readLine());
			
			int n1 = Integer.parseInt(st.nextToken());
			
			while (true) {
				int n2 = Integer.parseInt(st.nextToken());
				if (n2 == -1) break;
				int weight = Integer.parseInt(st.nextToken());
				
				tree[n1].add(new int[] {weight, n2});
			}
		}
		
		// 1번 노드에서 DFS
		DFS(1);
		
		// 답 출력
		System.out.println(ans);
	}
	private static int DFS(int p) {
		
		// 자식이 없는 경우 0 리턴
		if (p != 1 && tree[p].size() == 1) return 0;
		
		// 자식이 하나인 경우
		if ((p != 1 && tree[p].size() == 2)
			|| p == 1 && tree[p].size() == 1) {
			
			for (int i=0; i<2; i++) {
				if (tree[p].get(i)[1] == parent[p]) continue;
				
				parent[tree[p].get(i)[1]] = p;
				int temp = tree[p].get(i)[0] + DFS(tree[p].get(i)[1]);
				
				if (ans < temp) ans = temp;
				return temp;
			}
		}
		
		// 자식이 둘 이상인 경우
		int max1 = -1;
		int max2 = -1;
		for (int[] c : tree[p]) {
			if (c[1] == parent[p]) continue;
			
			parent[c[1]] = p;
			int temp = c[0] + DFS(c[1]);
			if (max1 < temp) {
				max2 = max1;
				max1 = temp;
			}else if (max2 < temp) {
				max2 = temp;
			}
		}
		
		if (ans < max1 + max2) ans = max1 + max2;
		return max1;
	}
}

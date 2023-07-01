import java.io.*;
import java.util.*;

public class Main {
	static int n, ans;
	static List<int[]>[] children;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 노드의 개수
		n = Integer.parseInt(br.readLine());
		
		// 노드의 자식 정보를 인접리스트에 저장
		children = new List[n+1];
		for (int i=1; i<=n; i++) {
			children[i] = new ArrayList<>();
		}
		for (int i=1; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			children[p].add(new int[] {w, c});
		}
		
		// 1번 노드부터 DFS
		DFS(1);
		
		// 답 출력
		System.out.println(ans);
	}
	
	// DFS로 해당 노드에서 리프까지 도달하는 최대 거리 구하기
	private static int DFS(int parent){
		// 자식노드가 없다면 0 리턴
		if (children[parent].size() == 0) return 0;
		
		// 자식노드가 하나인 경우
		if (children[parent].size() == 1) {
			int temp = children[parent].get(0)[0] + DFS(children[parent].get(0)[1]);
			if (ans < temp) ans = temp;
			return temp;
		}
		
		// 자식노드가 둘 이상인 경우
		int max1 = -1;
		int max2 = -1;
		for (int[] c : children[parent]) {
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

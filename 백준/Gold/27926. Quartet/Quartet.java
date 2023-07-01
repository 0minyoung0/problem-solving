import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 후보 학생의 수
		int n = Integer.parseInt(st.nextToken());
		// 시너지의 수
		int m = Integer.parseInt(st.nextToken());
		
		// 시너지를 인접리스트로 저장 (시너지, 연결된 노드)
		List<int[]>[] graph = new List[n+1];
		for (int i=1; i<=n; i++) {
			graph[i] = new ArrayList<>();
		}
		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			graph[u].add(new int[] {d, v});
			graph[v].add(new int[] {d, u});
		}
		
		long ans = 0;
		
		// 각 노드의 리스트를 시너지 내림차순으로 정렬
		for (int i=1; i<=n; i++) {
			Collections.sort(graph[i], new Comparator<int[]>() {
				public int compare(int[] o1, int[] o2) {
					if (o1[0] != o2[0]) return o2[0] - o1[0];
					return o1[1] - o2[1];
				}
			});
		}
		
		// 최대값 2개 저장
		int max1 = 0;
		int max2 = 0;
		
		// 각 간선을 중간으로 하는 연결 다리 만들어보기 (i와 x[1]를 연결: 시너지는 x[0])
		for (int i=1; i<=n; i++) {
			for (int[] x : graph[i]) {
				
				// x[1]이 i보다 큰 경우만 고려
				if (i > x[1]) continue;
				
				if (max1 == 0) {
					max1 = x[0];
				}else if (max2 == 0) {
					max2 = Math.min(x[0], max1);
					max1 = Math.max(x[0], max1);
				}else {
					int temp = Math.min(x[0], max1);
					max1 = Math.max(x[0], max1);
					max2 = Math.max(temp, max2);
				}
				
				// i와 추가로 한명, x[1]과 추가로 한명이 시너지를 내서 네 명이 연결 되는 경우
				for (int j=0; j<3; j++) {
					for (int k=0; k<3; k++) {
						int[] curi;
						int[] curx;
						
						if (j >= graph[i].size()) {
							curi = new int[] {0, 0};
						}else {
							curi = graph[i].get(j);
						}
						
						if (k >= graph[x[1]].size()) {
							curx = new int[] {0, 0};
						}else {
							curx = graph[x[1]].get(k);
						}
						
						// curi[1]과 x[1]이 같거나 curx[1]과 i가 같거나 curi[1]과 curx[1]이 같으면 continue
						if (curi[1] == x[1] || curx[1] == i || curi[1] == curx[1]) continue;
						
						// 네명 연결 되는 경우 갱신
						if (ans < (long)x[0] + (long)curi[0] + (long)curx[0]) {
							ans = (long)x[0] + (long)curi[0] + (long)curx[0];
						}
					}
				}
			}
		}
		
		// 왼쪽 두명, 오른쪽 두명만 연결된 경우
		if (ans < (long)max1 + (long)max2) {
			ans = (long)max1 + (long)max2;
		}
		
		// 답 출력
		System.out.println(ans);
	}
}

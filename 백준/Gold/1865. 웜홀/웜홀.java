import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		final int INF = 987654321;
		
		// 테스트케이스의 개수
		int TC = Integer.parseInt(br.readLine());
		
		// 테스트케이스 별로 실행
		TC: while (TC-- > 0) {
			st = new StringTokenizer(br.readLine());
			
			// 지점의 수
			int N = Integer.parseInt(st.nextToken());
			// 도로의 개수
			int M = Integer.parseInt(st.nextToken());
			// 웜홀의 개수
			int W = Integer.parseInt(st.nextToken());
			
			// 간선 정보를 저장할 리스트 배열
			List<int[]>[] edge = new List[N+1];
			for (int i=1; i<=N; i++) {
				edge[i] = new ArrayList<>();
			}
			
			// 도로 정보 저장
			while (M-- > 0) {
				st = new StringTokenizer(br.readLine());
				
				// 연결된 지점의 번호
				int S = Integer.parseInt(st.nextToken());
				int E = Integer.parseInt(st.nextToken());
				// 도로를 통해 이동하는데 걸리는 시간
				int T = Integer.parseInt(st.nextToken());
				
				edge[S].add(new int[] {T, E});
				edge[E].add(new int[] {T, S});
			}
			
			// 웜홀 정보 저장
			while (W-- > 0) {
				st = new StringTokenizer(br.readLine());

				// 시작 지점
				int S = Integer.parseInt(st.nextToken());
				// 도착 지점
				int E = Integer.parseInt(st.nextToken());
				// 웜홀을 통해 이동하는데 줄어드는 시간
				int T = Integer.parseInt(st.nextToken());
				
				edge[S].add(new int[] {-T, E});
			}
			
			// 1번 지점을 시작점으로 벨만-포드 알고리즘
			int[] dis = new int[N+1];
			Arrays.fill(dis, INF);
			dis[1] = 0;
			
			// 모든 간선을 확인해서 최단 길이 갱신 N번 반복하기
			for (int i=1; i<=N; i++) {
				boolean update = false;
				
				int[] newDis = Arrays.copyOf(dis, N+1);
				
				for (int j=1; j<=N; j++) {
					for (int[] e : edge[j]) {
						if (newDis[e[1]] > dis[j] + e[0]) {
							newDis[e[1]] = dis[j] + e[0];
							update = true;
						}
					}
				}
				
				if (!update) {                 
					System.out.println("NO");
					continue TC;
				}
				
				dis = newDis;
			}
			
			// 변화가 있으면 YES 출력
			System.out.println("YES");
		}
	}
}

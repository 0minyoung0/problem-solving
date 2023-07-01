import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 사다리 + 뱀의 수
		int n = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
		
		// 사다리와 뱀을 타고 이동하는 좌표를 저장할 배열
		int[] move = new int[100];
		Arrays.fill(move, -1);
		
		// 사다리와 뱀을 저장
		while (n-- > 0) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			move[s] = e;
		}
		
		// BFS에 사용할 큐와 거리 배열
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(1);
		int[] dis = new int[101];
		dis[1] = 1;
		
		// BFS
		while (!q.isEmpty()) {
			int cur = q.poll();
			
			for (int dice=1; dice<=6; dice++) {
				int nx = cur + dice;
				
				if (nx > 100) continue;
				if (nx == 100) {
					System.out.println(dis[cur]);
					return;
				}
				
				if (move[nx] != -1) nx = move[nx];
				
				if (dis[nx] > 0) continue;
				
				q.offer(nx);
				dis[nx] = dis[cur] + 1;
			}
		}
	}
}
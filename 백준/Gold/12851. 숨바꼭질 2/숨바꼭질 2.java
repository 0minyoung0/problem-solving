import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 수빈이의 위치
		int n = Integer.parseInt(st.nextToken());
		// 동생이 있는 위치
		int k = Integer.parseInt(st.nextToken());
		
		// 처음부터 같은 위치에 있는 경우
		if (n == k) {
			System.out.println("0\n1");
			return;
		}
		
		// 수빈이가 도달하는 시간을 저장할 배열
		int[] time = new int[100001];
		Arrays.fill(time, -1);
		time[n] = 0;
		
		// 수빈이의 위치를 저장할 큐
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(n);
		
		// 시간을 저장할 변수
		int ans1 = 0;
		
		// 경우의 수를 저장할 변수
		int ans2 = 0;
		
		// BFS 탐색
		while (!q.isEmpty()) {
			ans1++;
			
			// 현재 큐의 크기
			int size = q.size();
			
			// 큐 크기만큼 BFS 탐색 돌리기
			for (int i=0; i<size; i++) {
				int cur = q.poll();
				
				for (int dir=0; dir<3; dir++) {
					int nx = move(cur, dir);
					
					// out of index
					if (nx < 0 || nx > 100000) continue;
					
					// 동생의 위치에 도달한 경우
					if (nx == k) {
						ans2++;
						continue;
					}
					
					// 이전에 이미 도달했던 좌표인 경우
					if (0 < time[nx] && time[nx] < ans1) continue;
					
					// 동생이 해당 좌표에 없고 이전에 도달하지 않은 좌표인 경우
					time[nx] = ans1;
					q.offer(nx);
				}
			}
			
			// ans2가 0보다 크다면 답 출력 후 리턴
			if (ans2 > 0) {
				System.out.println(ans1 + "\n" + ans2);
				return;
			}
		}
	}
	private static int move (int cur, int dir) {
		if (dir == 0) return cur - 1;
		else if (dir == 1) return cur + 1;
		else return 2 * cur;
	}
}

import java.util.*;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 테스트 케이스 별로 실행
		for (int tc=1; tc<=10; tc++) {
			
			// 입력받는 데이터의 길이
			int dataN = sc.nextInt() / 2;
			// 시작점
			int start = sc.nextInt();
			
			// 연락망 정보 인접리스트로 저장
			List<Integer>[] con = new List[101];
			for (int i=1; i<=100; i++) {
				con[i] = new ArrayList<>();
			}
			while (dataN-- > 0) {
				int n1 = sc.nextInt();
				int n2 = sc.nextInt();
				con[n1].add(n2);
			}
			
			// 시작점에서 BFS하기
			int maxDis = 0;
			int[] dis = new int[101];
			dis[start] = 1;
			Queue<Integer> dq = new ArrayDeque<>();
			dq.offer(start);
			
			while (!dq.isEmpty()) {
				int cur = dq.poll();
				for (int nx : con[cur]) {
					if (dis[nx] > 0) continue;
					dis[nx] = dis[cur] + 1;
					if (maxDis < dis[nx]) maxDis = dis[nx];
					dq.offer(nx);
				}
			}
			
			// dis가 최대인 사람 중 가장 큰 숫자인 사람 찾기
			for (int i=100; i>=1; i--) {
				if (dis[i] == maxDis) {
					// 답 출력
					System.out.println("#" + tc + " " + i);
					break;
				}
			}
		}
	}
}

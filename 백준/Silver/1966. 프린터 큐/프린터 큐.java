import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 테스트 케이스 개수
		int t = Integer.parseInt(br.readLine());
		
		// 테스트 케이스 별로 실행
		tc: while (t-- > 0) {
			st = new StringTokenizer(br.readLine());
			// 문서의 개수
			int N = Integer.parseInt(st.nextToken());
			// 출력 순서가 궁금한 문서의 위치
			int M = Integer.parseInt(st.nextToken());
			// 해당 문서의 중요도
			int M_P = -1;
			
			// 중요도별 문서 개수
			int[] P_cnt = new int[10];
			
			// 문서의 중요도
			int[] P = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i=0; i<N; i++) {
				int temp = Integer.parseInt(st.nextToken());
				if (i == M) M_P = temp;
				P_cnt[temp]++;
				P[i] = temp;
			}
			
			// 문서를 큐에 넣기
			Queue<int[]> q = new ArrayDeque<>();
			for (int i=0; i<N; i++) {
				if (i == M) q.add(new int[] {P[i], 1});
				else q.add(new int[] {P[i], 0});
			}
			
			// 문서 인쇄 카운트
			int ans = 0;
			for (int i=9; i>=M_P; i--) {
				while (P_cnt[i] > 0) {
					// 인쇄하기
					if (q.peek()[0] == i) {
						// 출력 순서가 궁금한 문서라면
						if (q.peek()[0] == M_P && q.peek()[1] == 1) {
							// 답 출력 후 다음 테스트 케이스
							System.out.println(++ans);
							continue tc;
						}
						// 출력 순서가 궁금한 문서가 아닌 경우
						else {
							q.poll();
							P_cnt[i]--;
							ans++;
						}
					}
					// 인쇄할 차례가 아닌 경우
					else {
						q.add(q.poll());
					}
				}
			}
		}
	}
}

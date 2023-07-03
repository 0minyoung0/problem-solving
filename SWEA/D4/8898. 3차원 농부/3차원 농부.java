import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 테스트 케이스의 수
		int T = Integer.parseInt(br.readLine());
		
		// 테스트 케이스 별 실행
		for (int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			
			// 소의 수
			int N = Integer.parseInt(st.nextToken());
			
			// 말의 수
			int M = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			
			// 소들의 x좌표
			int c1 = Integer.parseInt(st.nextToken());
			
			// 말들의 x좌표
			int c2 = Integer.parseInt(st.nextToken());
			
			// 소들의 위치
			int[] z1 = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i=0; i<N; i++) {
				z1[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.parallelSort(z1);
			
			// 말들의 위치
			int[] z2 = new int[M];
			st = new StringTokenizer(br.readLine());
			for (int i=0; i<M; i++) {
				z2[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.parallelSort(z2);
			
			// 최소 거리를 저장할 변수
			int minDis = Integer.MAX_VALUE;
			
			// 최소 거리를 만족하는 쌍의 개수를 저장할 변수
			int cnt = 0;
			
			// 투포인터
			int p1 = 0;
			int p2 = 0;
			while (p1 < N) {
				int temp = Math.abs(z1[p1] - z2[p2]);
				if (minDis > temp) {
					minDis = temp;
					cnt = 1;
				}
				else if (minDis == temp) cnt++;
				
				if (p2 == M-1) p1++;
				else if (p1 == N-1) p2++;
				else if (z1[p1] <= z2[p2]) p1++;
				else p2++;
			}
			
			// 답 출력
			System.out.println("#" + tc + " " + (minDis + Math.abs(c1 - c2)) + " " + cnt);
		}
	}
}

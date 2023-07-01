import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
			
			// 사탕 종류의 수
			int N = Integer.parseInt(st.nextToken());
			// 각 가방에 들어가야하는 사탕의 수
			long M = Long.parseLong(st.nextToken());
			
			// 사탕 종류별 개수
			long[] candyN = new long[N];
			st = new StringTokenizer(br.readLine());
			for (int i=0; i<N; i++) {
				candyN[i] = Long.parseLong(st.nextToken());
			}
			
			// 이분탐색으로 찾기 (가능한 최대의 사탕 가방 수 찾기)
			long s = 0;
			long e = 1000000000000000000L;
			
			loop: while (s < e) {
				
				long mid = (s + e + 1) / 2;
				
				// 이번 루프에서 넣은 사탕의 수
				long cnt = 0;
				
				// 종류별로 mid로 나눈 값을 넣어보기
				for (int i=0; i<N; i++) {
					cnt += candyN[i] / mid;
					
					// 넣어야 하는 개수를 넣었다면 
					if (cnt >= M) {
						
						// 그 이상도 가능한지 확인하기 위해 설정 후 continue loop
						s = mid;
						continue loop;
					}
				}
				
				// 불가능한 경우 더 적은 가방 개수 확인을 위해 설정
				e = mid - 1;
			}
			
			// 답 출력
			System.out.println("#" + tc + " " + s);
		}
	}
}

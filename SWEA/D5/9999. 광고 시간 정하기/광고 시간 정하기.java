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
			
			// 올릴 광고의 길이
			int L = Integer.parseInt(br.readLine());
			
			// 피크 시간대의 개수
			int N = Integer.parseInt(br.readLine());
			
			// 피크 시간 시각
			int[] time = new int[2*N];
			for (int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				time[2*i] = Integer.parseInt(st.nextToken());
				time[2*i+1] = Integer.parseInt(st.nextToken());
			}
			
			// i번째 피크시간까지의 구간 합 구해두기
			int[] sum = new int[N];
			sum[0] = time[1] - time[0];
			for (int i=1; i<N; i++) sum[i] = sum[i-1] + time[2*i+1] - time[2*i];
			
			// 답을 저장할 변수
			int ans = 0;
			
			// i번째 피크 시작 시간에 광고를 시작했을 때
			for (int i=0; i<N; i++) {
				
				// 이분탐색으로 i번째 피크 시작 시간에 시작한 광고가 어디에 끼는지 찾기
				int target = Arrays.binarySearch(time, time[2*i] + L);
				
				// 이번 경우의 답을 저장할 변수
				int temp = 0;
				
				// 피크 시간 사이에 안끼는 경우
				if (target >= 0) {
					temp = sum[(target - 1) / 2];
				}
				else if (-target % 2 == 1) {
					temp = sum[(-target - 2) / 2];
				}
				
				// 피크 시간 사이에 끼는 경우
				else {
					// 짤리는 피크 시간 계산해서 답 적용
					temp = sum[(-target - 3) / 2] + time[2*i] + L - time[-target - 2];
				}
				
				if (i != 0) temp -= sum[i-1];
				
				// 답 갱신
				if (ans < temp) ans = temp;
			}
			
			// 답 출력
			System.out.println("#" + tc + " " + ans);
		}
	}
}

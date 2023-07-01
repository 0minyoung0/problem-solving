import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 테스트 케이스의 수
		int T = Integer.parseInt(br.readLine());
		
		// 테스트 케이스 별 실행
		for (int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			
			// 영어 공부를 한 날의 수
			int n = Integer.parseInt(st.nextToken());
			
			// 추가로 체크할 수 있는 날의 수
			int p = Integer.parseInt(st.nextToken());
			
			// 수림이가 영어 공부를 실제로 한 날들의 번호
			int[] studyDays = new int[n];
			st = new StringTokenizer(br.readLine());
			for (int i=0; i<n; i++) {
				studyDays[i] = Integer.parseInt(st.nextToken());
			}
			
			// 답을 저장할 변수
			int ans = 0;
			
			// 투포인터 s와 e는 studyDays의 인덱스
			int s = 0;
			int e = 0;
			
			// 투포인터 돌리기
			while (e < n) {
				
				// s번째 일자부터 e번째 일자까지 연속으로 체크할 수 없으면
				if (studyDays[e] - studyDays[s] - (e - s) > p) {
					s++;
					continue;
				}
				
				// 현재 포인터 기준으로 답 갱신하기
				int temp = e - s + 1 + p;
				if (ans < temp) ans = temp;
				e++;
			}
			
			// 답 출력
			System.out.println("#" + tc + " " + ans);
		}
	}
}

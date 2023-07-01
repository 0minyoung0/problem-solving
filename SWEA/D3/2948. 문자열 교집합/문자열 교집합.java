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
			
			// 두 집합의 원소의 갯수
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			// 첫번째 집합의 원소를 저장할 해시셋
			HashSet<String> set = new HashSet<>();
			
			// 첫번째 집합의 원소 저장
			st = new StringTokenizer(br.readLine());
			while (N-- > 0) {
				set.add(st.nextToken());
			}
			
			// 두 집합에 모두 속하는 문자열 원소의 개수를 셀 변수
			int ans = 0;
			
			// 두번째 집합의 원소를 순회하며 첫번째 집합에 있는지 확인
			st = new StringTokenizer(br.readLine());
			while (M-- > 0) {
				if (set.contains(st.nextToken())) {
					ans++;
				}
			}
			
			// 답 출력
			System.out.println("#" + tc + " " + ans);
		}
	}
}

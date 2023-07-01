import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 테스트 케이스의 수
		int T = Integer.parseInt(br.readLine());
		
		// 테이블 초기화
		int[][] table = new int[1001][1001];
		
		// 테스트 케이스별로 실행
		for (int tc=1; tc<=T; tc++) {
			
			// 문자열 저장
			st = new StringTokenizer(br.readLine());
			char[] s1 = st.nextToken().toCharArray();
			char[] s2 = st.nextToken().toCharArray();
			
			// 테이블 채우기
			for (int i=1; i<=s1.length; i++) {
				for (int j=1; j<=s2.length; j++) {
					
					// s1의 i번째 글자가 s2의 j번째 글자와 같은지 확인
					if (s1[i-1] == s2[j-1]) {
						table[i][j] = table[i-1][j-1] + 1;
					}else {
						table[i][j] = table[i-1][j] > table[i][j-1] ? table[i-1][j] : table[i][j-1];
					}
				}
			}
			
			// 답 출력
			System.out.println("#" + tc + " " + table[s1.length][s2.length]);
		}
	}
}

import java.io.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// 테스트 케이스의 수
		int T = Integer.parseInt(br.readLine());
		
		// 테스트 케이스 별 실행
		for (int tc=1; tc<=T; tc++) {
			sb.append("#").append(tc).append(" ");
			
			// 양초 개수
			long candleN = Long.parseLong(br.readLine());
			
			// 찾기
			int ans = (int)(Math.sqrt(candleN * 2));
			
			// 삼각형을 만들 수 있으면 몇단인지 저장
			if ((long)ans * (ans + 1) / 2 == candleN) sb.append(ans);
			// 삼각형을 만드는 것이 불가능하다면 -1 저장
			else sb.append(-1);
			
			sb.append("\n");
		}
		
		// 답 출력
		System.out.print(sb);
	}
}

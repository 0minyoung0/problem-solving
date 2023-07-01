import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		// 테스트 케이스의 개수
		int T = Integer.parseInt(br.readLine());
		
		// 테스트 케이스 별로 실행
		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			
			// 출발점
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			// 도착점
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			// 행성계의 개수
			int n = Integer.parseInt(br.readLine());
			
			// 최소의 행성계 진입/이탈 횟수를 저장할 변수
			int ans = 0;
			
			// 행성계 정보
			while (n-- > 0) {
				st = new StringTokenizer(br.readLine());
				
				// 행성계의 중점과 반지름
				int cx = Integer.parseInt(st.nextToken());
				int cy = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				
				// 출발점과 도착점이 행성계 내부/외부에 하나씩 있으면 ans에 +1
				int dis1_square = (cx-x1)*(cx-x1)+(cy-y1)*(cy-y1);
				int dis2_square = (cx-x2)*(cx-x2)+(cy-y2)*(cy-y2);
				if ((dis1_square > r*r) != (dis2_square > r*r)) ans++;
			}
			
			// 답 저장
			sb.append(ans).append("\n");
		}
		
		// 답 출력
		System.out.println(sb);
	}
}

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 테스트 케이스의 개수
		int T = Integer.parseInt(br.readLine());
		
		// 테스트 케이스 별로 실행
		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			
			// 조규현의 좌표
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			// 조규현이 계산한 류재명의 거리
			int r1 = Integer.parseInt(st.nextToken());
			// 백승환의 좌표
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			// 백승환이 계산한 류재명의 거리
			int r2 = Integer.parseInt(st.nextToken());
			
			// 무한대인 경우
			if (x1==x2 && y1==y2 && r1==r2) {
				System.out.println(-1);
				continue;
			}
			
			// 조규현과 백승환 사이의 거리
			double r = Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
			
			// 하나 있는 경우
			if (Math.abs(r1 + r2 - r) < 0.000000001
				|| Math.abs(r1 - r2 + r) < 0.000000001
				|| Math.abs(-r1 + r2 + r) < 0.000000001) {
				System.out.println(1);
			}
			// 없는 경우
			else if (r - r1 - r2 > 0.000000001
					|| r1 - r - r2 > 0.000000001
					|| r2 - r - r1 > 0.000000001) {
				System.out.println(0);
			}
			// 두개 있는 경우
			else {
				System.out.println(2);
			}
		}
		
	}
}

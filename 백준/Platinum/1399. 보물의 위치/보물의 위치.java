import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	
	// index 0:북쪽, 1:동쪽, 2:남쪽, 3:서쪽
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 테스트 케이스 개수
		int t = Integer.parseInt(br.readLine());
		
		// 보물 찾기 시행
		for (int i=0; i<t; i++) {
			 st = new StringTokenizer(br.readLine());
			 int k = Integer.parseInt(st.nextToken());
			 int m = Integer.parseInt(st.nextToken());
			 findTreasure(k,m);
		}
		
		// 결과 출력
		System.out.println(sb);
	}
	// k와 m으로부터 보물의 위치를 찾아서  StringBuilder에 append하는 함수
	private static void findTreasure(int k, int m) {
		// 골드 넘버가 1부터 시작하므로 골드 넘버가 0이 되는 경우는 배제해도 됨
		// m이 9를 주기로 같은 패턴이 반복되므로 m은 9의 나머지로 처리 해도 됨 (단, 9는 9로 처리)
		// k는 12를 주기로 같은 패턴이 반복되나, 반복 시작점이 m마다 다르므로 m이 3,6,9일때 고려해야함
		// m이 3,6일 때 반복 시작점 k=3, 반복주기 4
		// m이 9일때 반복 시작점 k=2, 반복주기 4
		
		m %= 9;
		if (m == 0) m = 9;
		
		int g = 1; // 골드 넘버
		int dir = 0; // 시작 방향
		int x = 0; // x 좌표
		int y = 0; // y 좌표

		if (m%3 != 0) { // m이 1,2,4,5,7,8일때
			k %= 12;
			for (int i=0; i<k; i++) {
				// 1. dig(골드 넘버)만큼 앞으로 간다. 그리고 90도 오른쪽으로 회전한다.
				x += g * dx[dir];
				y += g * dy[dir];
				dir = (dir + 1) % 4;
				
				// 2. 골드 넘버에 M을 곱한다. 다음 반복을 위해 아래 조건을 한번에 처리
				// dig(x) = x (0 ≤ x ≤ 9), dig(x) = dig(x의 모든 자리수의 합) (x ≥ 10)
				g *= m;
				if (g >= 10) g %= 9;
				if (g == 0) g = 9;
			}
		}
		else { // m이 3,6,9일때
			if (k>=7) k = k % 4 + 4; // k가 7이상일때 4,5,6,7 중 같은 상태인 값으로 변경
			for (int i=0; i<k; i++) {
				// 1. dig(골드 넘버)만큼 앞으로 간다. 그리고 90도 오른쪽으로 회전한다.
				x += g * dx[dir];
				y += g * dy[dir];
				dir = (dir + 1) % 4;
				
				// 2. 골드 넘버에 M을 곱한다. 다음 반복을 위해 아래 조건을 한번에 처리
				// dig(x) = x (0 ≤ x ≤ 9), dig(x) = dig(x의 모든 자리수의 합) (x ≥ 10)
				g *= m;
				if (g >= 10) g %= 9;
				if (g == 0) g = 9;
			}
		}

		sb.append(x).append(" ").append(y).append("\n");
	}
}
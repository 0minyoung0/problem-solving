import java.io.*;
import java.util.*;

public class Main {
	static int emptyCnt, ans;
	static int[] remain;
	static boolean[][] empty;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
	
		// 크기별로 남은 색종이의 개수
		remain = new int[] {0,5,5,5,5,5};
		
		// 색종이를 붙여야하는 영역
		empty = new boolean[10][10];
		for (int i=0; i<10; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<10; j++) {
				if (st.nextToken().equals("1")) {
					empty[i][j] = true;
					emptyCnt++;
				}
			}
		}
		
		// 필요한 색종이의 최소 개수
		ans = Integer.MAX_VALUE;
		
		// 백트래킹으로 색종이 붙이기
		backTracking(0);
		
		// 불가능한 경우
		if (ans == Integer.MAX_VALUE) ans = -1;
		
		// 답 출력
		System.out.println(ans);
	}
	
	private static void backTracking(int n) {
		
		// 끝까지 도달한 경우
		if (n >= 100) {
			
			// 색종이를 다 붙였으면 사용한 색종이 수를 확인해서 ans 갱신
			if (emptyCnt == 0) {
				int temp = 25;
				for (int i=1; i<=5; i++) {
					temp -= remain[i];
				}
				if (ans > temp) ans = temp;
			}
			
			// 리턴
			return;
		}
		
		// 색종이를 붙일 필요가 없는 칸이면 다음 재귀 호출 후 리턴
		if (!empty[n/10][n%10]) {
			backTracking(n+1);
			return;
		}
		
		// 색종이를 붙일 필요가 있는 칸이면 5x5 부터 1x1까지 붙일 수 있는지 확인해서 붙여보기
		size: for (int size=5; size>=1; size--) {
			
			// out of index
			if (n/10 + size > 10 || n%10 + size > 10) continue;
			
			// 해당 크기의 색종이 남아있는지 확인
			if (remain[size] == 0) continue;
			
			// 붙이면 안되는 영역이 껴있는지 확인
			for (int i=0; i<size; i++) {
				for (int j=0; j<size; j++) {
					if (!empty[n/10+i][n%10+j]) continue size;
				}
			}
			
			// 색종이 붙이기
			remain[size]--;
			for (int i=0; i<size; i++) {
				for (int j=0; j<size; j++) {
					empty[n/10+i][n%10+j] = false;
				}
			}
			emptyCnt -= size*size;
			
			// 재귀 호출
			backTracking(n+size);
			
			// 원상 복구
			remain[size]++;
			for (int i=0; i<size; i++) {
				for (int j=0; j<size; j++) {
					empty[n/10+i][n%10+j] = true;
				}
			}
			emptyCnt += size*size;
		}
	}
}
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 수열을 입력하기 위한 델타 배열 (우,하,좌,상)
		int[] dx = {0,1,0,-1};
		int[] dy = {1,0,-1,0};
				
		// 테스트 케이스 개수
		int T = sc.nextInt();
		
		for (int t=1; t<=T; t++) {	
			// 달팽이의 크기
			int n = sc.nextInt();
			
			// 수열을 저장할 배열 선언
			int[][] arr = new int[n][n];

			// 현재 위치를 나타내는 포인터
			int[] cur = {0,0};
			// 현재 방향을 나타내는 int
			int dir = 0;
			
			// 배열에 숫자 입력 후 cur 이동
			for (int cnt=1; cnt<n*n; cnt++) {
				arr[cur[0]][cur[1]] = cnt;
				int nx;
				int ny;
				// 다음 좌표 찾기
				while (true) {
					nx = cur[0] + dx[dir];
					ny = cur[1] + dy[dir];
					if (nx < 0 || nx >= n || ny < 0 || ny >= n || arr[nx][ny] > 0) {
						dir = (dir + 1) % 4;
						continue;
					}
					break;
				}
				// 다음 좌표 대입
				cur[0] = nx;
				cur[1] = ny;
			}
			arr[cur[0]][cur[1]] = n*n;
			
			System.out.println("#" + t);
			for (int i=0; i<n; i++) {
				for (int j=0; j<n; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
		}
	}
}

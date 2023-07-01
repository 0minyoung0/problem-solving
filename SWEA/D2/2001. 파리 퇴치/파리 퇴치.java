import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 테스트 케이스 개수
		int T = sc.nextInt();
		
		for (int t=1; t<=T; t++) {
			// 영역 크기
			int n = sc.nextInt();
			// 파리채 크기
			int m = sc.nextInt();
			
			// 파리의 수를 저장할 배열
			int[][] flies = new int[n][n];

			// i,j 좌표의 파리 수
			for (int i=0; i<n; i++) {
				for (int j=0; j<n; j++) {
					flies[i][j] = sc.nextInt();
				}
			}
			
			// 최대로 잡는 파리의 수를 저장할 변수 선언
			int ans = 0;
			
			// 파리채가 내리치는 영역중 가장 왼쪽 위의 사각형의 좌표가
			// (x,y)일때 파리채를 (x,y)에 내리쳤다고 정의 하자
			// 이 경우 파리채를 내리칠 수 있는 범위는 x,y 각각 0부터 n-m까지이다
			for (int i=0; i<n-m+1; i++) {
				for (int j=0; j<n-m+1; j++) {
					// i,j 좌표에 파리채를 내리쳤을때 잡는 파리의 수 계산
					int temp = 0;
					for (int x=i; x<i+m; x++) {
						for (int y=j; y<j+m; y++) {
							temp += flies[x][y];
						}
					}
					
					// 현재 좌표에서 잡은 파리의 수가 최대라면 ans에 대입
					ans = Math.max(ans, temp);
				}
			}
			
			System.out.println("#" + t + " " + ans);
		}
	}
}

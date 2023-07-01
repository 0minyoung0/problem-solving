import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int TC=1; TC<=10; TC++) {
			// 테스트케이스 숫자 필요 없어서 버림
			sc.nextInt();
			
			// 배열 선언
			int[][] arr = new int[100][100];
			for (int i=0; i<100; i++) {
				for (int j=0; j<100; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			// 최대값을 저장할 변수 ans, 인풋 범위가 애매해서 Integer 최소값으로 초기화
			int ans = Integer.MIN_VALUE;
			
			// 가로행, 세로열 계산
			for (int i=0; i<100; i++) {
				int temp1 = 0;
				int temp2 = 0;
				for (int j=0; j<100; j++) {
					// i행 합계 계산
					temp1 += arr[i][j];
					// i열 합계 계산
					temp2 += arr[j][i];
				}
				// i행 합계와 i열 합계 중 큰 값이 ans 보다 크다면 ans에 할당
				ans = Math.max(ans, Math.max(temp1, temp2));
			}
			
			// 대각선 계산
			int temp1 = 0;
			int temp2 = 0;
			for (int i=0; i<100; i++) {
				// \ 방향 대각선 합계 계산
				temp1 += arr[i][i];
				// / 방향 대각선 합계 계산
				temp2 += arr[i][99-i];
			}
			// 두 대각선 합계 중 큰 값이 ans 보다 크다면 ans에 할당
			ans = Math.max(ans, Math.max(temp1, temp2));
			
			// 답 출력
			System.out.println("#" + TC + " " + ans);
		}
	}
}

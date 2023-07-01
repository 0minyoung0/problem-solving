import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		testCase: for (int caseNum=1; caseNum<=T; caseNum++) {
			System.out.print("#"+caseNum+" ");
			
			// 판의 길이
			int n = sc.nextInt();
			sc.nextLine();
			
			// 판의 돌의 유무 정보를 저장할 배열 선언
			boolean[][] isStone = new boolean[n][n];
			
			// 돌 정보 입력 받기
			for (int i=0; i<n; i++) {
				String row = sc.nextLine();
				for (int j=0; j<n; j++) {
					if (row.charAt(j) == 'o') {
						isStone[i][j] = true;
					}
				}
			}
			
			// 연속된 돌의 개수를 셀 카운터
			int s = 0;
			
			// 가로 순회
			for (int i=0; i<n; i++) {
				for (int j=0; j<n; j++) {
					if (isStone[i][j]) {
						s++;
						if (s>=5) {
							System.out.println("YES");
							continue testCase;
						}
					}
					else {
						s = 0;
					}
				}
				s = 0;
			}
			
			// 세로 순회
			for (int i=0; i<n; i++) {
				for (int j=0; j<n; j++) {
					if (isStone[j][i]) {
						s++;
						if (s>=5) {
							System.out.println("YES");
							continue testCase;
						}
					}
					else {
						s = 0;
					}
				}
				s = 0;
			}
			
			// \방향 대각선 순회 (line의 인덱스는 x좌표-y좌표)
			for (int line=-n+5; line<=n-5; line++) {
				// 순회 시작점 선언
				int i;
				int j;
				if (line < 0) {
					i = 0;
					j = -line;
				}
				else {
					i = line;
					j = 0;
				}
				for (; i<n && j<n; i++, j++) {
					if (isStone[i][j]) {
						s++;
						if (s>=5) {
							System.out.println("YES");
							continue testCase;
						}
					}
					else {
						s = 0;
					}
				}
				s = 0;
			}
			
			// /방향 대각선 순회 (line의 인덱스는 x좌표+y좌표)
			for (int line=4; line<=2*n-6; line++) {
				// 순회 시작점 선언
				int i;
				int j;
				if (line < n) {
					i = 0;
					j = line - i;
				}
				else {
					i = line - n + 1;
					j = n - 1;
				}
				for (; i<n && j>=0; i++, j--) {
					if (isStone[i][j]) {
						s++;
						if (s>=5) {
							System.out.println("YES");
							continue testCase;
						}
					}
					else {
						s = 0;
					}
				}
				s = 0;
			}
			
			// continue하지 않았으면 오목X
			System.out.println("NO");
		}
	}
}

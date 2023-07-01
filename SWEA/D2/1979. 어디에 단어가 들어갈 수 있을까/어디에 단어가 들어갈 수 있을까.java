import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int caseNum = 1; caseNum <= T; caseNum++) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			
			// 퍼즐 칸 정보 저장할 Boolean[][] 선언
			Boolean[][] isBlank = new Boolean[n][n];
			
			for (int i=0; i<n; i++) {
				for (int j=0; j<n; j++) {
					if (sc.nextInt() == 1) {
						isBlank[i][j] = true;
					}
					else {
						isBlank[i][j] = false;
					}
				}
			}
			
			int ans = 0;

			// 연결된 길이를 저장할 변수
			// length1은 가로줄 순회에 사용
			// length2는 세로줄 순회에 사용
			int length1 = 0;
			int length2 = 0;

			for (int i=0; i<n; i++) {
				for (int j=0; j<n; j++) {
					// 가로줄 순회
					
					// 빈칸일 때
					if (isBlank[i][j]) {
						// 맨 처음 인덱스면
						if (j == 0) {
							length1 = 1;
						}
						// 그 외의 경우
						else {
							length1++;
						}
					}
					// 빈칸이 아닐 때
					else {
						// 측정한 길이가 k일때
						if (length1 == k) {
							ans++;
						}
						// 길이 초기화
						length1 = 0;
					}
					
					// 세로줄 순회
					
					// 빈칸일 때
					if (isBlank[j][i]) {
						// 맨 처음 인덱스면
						if (j == 0) {
							length2 = 1;
						}
						// 그 외의 경우
						else {
							length2++;
						}
					}
					// 빈칸이 아닐 때
					else {
						// 측정한 길이가 k일때
						if (length2 == k) {
							ans++;
						}
						// 길이 초기화
						length2 = 0;
					}
				}
				// 마지막 n-1 인덱스까지 계산했을때 길이가 k인 경우도 카운팅
				if (length1 == k) {
					ans++;
				}
				length1 = 0;
				if (length2 == k) {
					ans++;
				}
				length2 = 0;
			}
			
			System.out.println("#" + caseNum + " " + ans);
		}
	}
}

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int t=1; t<=10; t++) {
			// 찾아야 하는 회문의 길이
			int l = Integer.parseInt(sc.nextLine());
			
			// 글자판 정보
			char[][] arr = new char[8][8];
			for (int i=0; i<8; i++) {
				String s = sc.nextLine();
				for (int j=0; j<8; j++) {
					arr[i][j] = s.charAt(j);
				}
			}
			
			int ans = 0;
			
			for (int i=0; i<8; i++) {
				for (int j=0; j<=8-l; j++) {
					// 회문 찾기 - 가로
					boolean isPalindrome = true;
					// 회문을 판단하기 위한 포인터 두 개
					int p1 = j;
					int p2 = j + l - 1;
					// 포인터 두개를 양쪽 끝에서부터 안쪽으로 하나씩 이동하면서 확인하다가 p1 >= p2가 되면 종료
					while (p1 < p2) {
						if (arr[i][p1++] != arr[i][p2--]) {
							isPalindrome = false;
							break;
						}
					}
					// 회문이면 ans에 +1
					if (isPalindrome) {
						ans++;
					}
					
					// 회문 찾기 - 세로
					isPalindrome = true;
					// 회문을 판단하기 위한 포인터 두 개
					p1 = j;
					p2 = j + l - 1;
					// 포인터 두개를 양쪽 끝에서부터 안쪽으로 하나씩 이동하면서 확인하다가 p1 >= p2가 되면 종료
					while (p1 < p2) {
						if (arr[p1++][i] != arr[p2--][i]) {
							isPalindrome = false;
							break;
						}
					}
					// 회문이면 ans에 +1
					if (isPalindrome) {
						ans++;
					}
				}
			}
			
			System.out.println("#" + t + " " + ans);
		}
	}
}

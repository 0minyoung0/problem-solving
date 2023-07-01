import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int t=1; t<=10; t++) {
			sc.nextLine();
			
			// 배열 저장
			char[][] arr = new char[100][100];
			for (int i=0; i<100; i++) {
				String s = sc.nextLine();
				for (int j=0; j<100; j++) {
					arr[i][j] = s.charAt(j);
				}
			}
			
			// 회문의 최소 길이는 1이므로 1로 초기화
			int ans = 1;
			
			// 길이가 100인 회문부터 2인 회문까지 순차적으로 탐색
			find: for (int l=100; l>1; l--) {
				for (int i=0; i<100; i++) {
					for (int j=0; j<=100-l; j++) {
						// 가로 탐색
						boolean isPalindrome = true;
						int p1 = j;
						int p2 = j+l-1;
						while (p1 < p2) {
							if (arr[i][p1++] != arr[i][p2--]) {
								isPalindrome = false;
								break;
							}
						}
						if (isPalindrome) {
							ans = l;
							break find;
						}
						
						// 세로 탐색
						isPalindrome = true;
						p1 = j;
						p2 = j+l-1;
						while (p1 < p2) {
							if (arr[p1++][i] != arr[p2--][i]) {
								isPalindrome = false;
								break;
							}
						}
						if (isPalindrome) {
							ans = l;
							break find;
						}
					}
				}
			}
			
			System.out.println("#" + t + " " + ans);
		}
	}
}

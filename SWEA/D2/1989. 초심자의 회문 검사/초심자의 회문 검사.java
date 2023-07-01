import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		sc.nextLine();
		
		for (int t=1; t<=T; t++) {
			// 회문인지 의미하는 boolean 선언
			boolean isPalindrome = true;
			
			String word = sc.nextLine();
			
			// 회문을 판단하기 위한 포인터 두 개
			int p1 = 0;
			int p2 = word.length() - 1;

			// 포인터 두개를 양쪽 끝에서부터 안쪽으로 하나씩 이동하면서 확인하다가 p1 >= p2가 되면 종료
			while (p1 < p2) {
				// 만일 종료조건에 도달하지 못했는데 두 포인터가 다른 문자를 가리키면 회문이 아님
				if (word.charAt(p1++) != word.charAt(p2--)) {
					isPalindrome = false;
					break;
				}
			}
			
			if (isPalindrome) {
				System.out.println("#" + t + " " + 1);
			}
			else {
				System.out.println("#" + t + " " + 0);
			}
		}
	}
}

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int t=1; t<=10; t++) {
			// 테스트 케이스
			sc.nextLine();
			
			// 찾으려는 패턴
			String pat = sc.nextLine();
			
			// 검색 대상이 될 문장
			String text = sc.nextLine();
			
			// 검색한 개수를 저장할 변수
			int ans = 0;
			
			// 문장에서 패턴 찾기
			find: for (int i = 0; i <= text.length() - pat.length(); i++) {
				for (int j = 0; j < pat.length(); j++) {
					// 문자열 찾기 실패
					if (text.charAt(i+j) != pat.charAt(j)) {
						continue find;
					}
				}
				// 문자열 찾기에 실패하지 않았다면 ans에 +1
				ans++;
			}

			System.out.println("#" + t + " " + ans);
		}
	}
}

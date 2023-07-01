import java.util.*;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 테스트 케이스 개수
		int T = sc.nextInt();
		
		// 테스트 케이스 별로 실행
		tc: for (int t=1; t<=T; t++) {
			// m의 이진수 표현의 마지막 n비트가 모두 1인지 확인
			int n = sc.nextInt();
			int m = sc.nextInt();
			
			// 끝에 n개의 비트를 확인
			for (int i=0; i<n; i++) {
				// 0인 비트가 있으면 OFF 출력 후 다음 테스트 케이스로 넘어감
				if (m%2 == 0) {
					System.out.println("#" + t + " OFF");
					continue tc;
				}
				m /= 2;
			}
			
			// 0인 비트가 없으면 ON 출력
			System.out.println("#" + t + " ON");
		}
	}
}

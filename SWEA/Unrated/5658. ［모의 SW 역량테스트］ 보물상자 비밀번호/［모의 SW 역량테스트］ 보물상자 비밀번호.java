import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int t=1; t<=T; t++) {
			// 숫자의 개수 n, 원하는 숫자의 크기 순서 k
			int n = sc.nextInt();
			int k = sc.nextInt();
			sc.nextLine();
			
			// 보물상자 뚜껑에 적힌 숫자 정보
			String s = sc.nextLine();
			// 보물상자 뚜껑에 적힌 숫자를 int로 저장할 배열
			int[] arr = new int[n];
			
			// 보물상자 뚜껑에 적힌 숫자 정보를 int로 치환
			for (int i=0; i<n; i++) {
				// 'A'는 97, '0'은 80
				int temp = s.charAt(i) - '0';
				if (temp > 16) {
					temp -= 7;
				}
				// temp에 16진수로 변환한 값을 입력
				arr[i] = temp;
			}
			
			// 보물상자로 만들 수 있는 숫자를 저장할 배열
			// Collections.reverseOrder()를 사용하기 위해서 Integer배열로 선언
			Integer[] ans = new Integer[n];
			
			// 숫자를 계산해서 저장
			for (int i=0; i<n; i++) {
				int temp = 0;
				for (int j=0; j<n/4; j++) {
					temp *= 16;
					temp += arr[(i + j) % n];
				}
				ans[i] = temp;
			}
			
			// 계산된 숫자 정렬
			Arrays.sort(ans, Collections.reverseOrder());
			
			// 순회하면서 k번째 숫자 찾기
			int index = 0;
			int pre = -1;
			int cnt = 1;
			while (cnt != k) {
				// 중복이 아닌경우
				if (ans[index] != pre) {
					// cnt 증가
					cnt++;
				}
				// pre 업데이트 후 index 증가
				pre = ans[index++];
			}
			
			// 출력
			System.out.println("#" + t + " " + ans[index]);
		}
	}
}

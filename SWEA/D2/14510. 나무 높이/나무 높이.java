import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 테스트 케이스 개수
		int T = sc.nextInt();
		
		for (int x=1; x<=T; x++) {
			// 나무 개수
			int n = sc.nextInt();
			
			// 가장 큰 나무 높이
			int mx = 0;
			
			// 나무 높이 배열에 저장
			int[] tree = new int[n];
			for (int i=0; i<n; i++) {
				tree[i] = sc.nextInt();
				if (tree[i] > mx) {
					mx = tree[i];
				}
			}
			
			// 나무 높이 차이 계산
			// 나무 높이 차의 합계
			int s = 0;
			// 나무 높이 차 홀수의 개수
			int odd = 0;
			for (int i=0; i<n; i++) {
				s += mx - tree[i];
				if ((mx - tree[i]) % 2 == 1) {
					odd++;
				}
			}
			
			// 홀수 개수만큼은 무조건 1을 써야함
			s -= odd;
			
			// 필요한 2의 개수가 홀수 개수보다 작은 경우
			if (s / 2 < odd) {
				System.out.println("#" + x + " " + (odd*2-1));
				continue;
			}
			
			// 그 외의 경우 2도 일단 홀수 개수만큼 사용
			s -= 2*odd;
			// 현재 2*odd일 소모
			int day = 2*odd;
			
			// 남은 높이를 6으로 나눈 몫 * 4만큼 일수 더하기
			day += s / 6 * 4;
			
			if (s % 6 == 2) {
				day += 2;
			}else if (s % 6 == 4) {
				day += 3;
			}
			
			System.out.println("#" + x + " " + day);
			
		}
		
	}
}

// 배열로 삽입정렬 구현

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 테스트 케이스 개수
		int T = sc.nextInt();
		
		// 테스트 케이스 별로 실행
		for (int t=1; t<=T; t++) {
			// 숫자의 개수
			int n = sc.nextInt();
			
			// 숫자를 정렬하며 저장할 배열 선언
			int[] arr = new int[n];
			
			// 배열에 넣으면서 삽입정렬 시행
			for (int i=0; i<n; i++) {
				// 새 숫자
				int newNum = sc.nextInt();
				// 새 숫자가 들어갈 인덱스
				int curIdx = i;
				while (curIdx != 0) {
					if (arr[curIdx-1] > newNum) {
						arr[curIdx] = arr[curIdx-1];
						curIdx--;
					} else {
						break;
					}
				}
				arr[curIdx] = newNum;
			}

			// 정렬된 배열 출력
			System.out.print("#" + t);
			for (int i=0; i<arr.length; i++) {
				System.out.print(" " + arr[i]);
			}System.out.println();
		}
	}
}

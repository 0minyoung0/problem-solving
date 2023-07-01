import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 입력 개수
		int n = sc.nextInt();
		// 입력 저장할 배열 선언
		int[] arr = new int[n];
		// 입력 저장
		for (int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		// selection sort
		for (int i=0; i<=n/2; i++) {
			// 점수 범위가 안나와있어서 그냥 Integer Max로 초기화
			int min = Integer.MAX_VALUE;
			int index = -1;
			
			// i번 인덱스의 숫자부터 끝까지 최소값을 탐색
			for (int j=i; j<n; j++) {
				if (min > arr[j]) {
					min = arr[j];
					index = j;
				}
			}
			
			// 최소값과 i번 인덱스의 숫자 자리 바꾸기
			int temp = min;
			arr[index] = arr[i];
			arr[i] = temp;
		}
		
		// n/2번 인덱스의 값 출력
		System.out.println(arr[n/2]);
	}
}

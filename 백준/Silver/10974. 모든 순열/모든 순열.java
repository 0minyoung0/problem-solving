import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// 1부터 N까지로 이루어진 순열
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		for (int i=0; i<N; i++) {
			arr[i] = i+1;
		}
		
		do {
			for (int e : arr) {
				sb.append(e).append(" ");
			}
			sb.append("\n");
		}while (nextPermutation(arr));
		
		// 답 출력
		System.out.println(sb);
	}
	private static boolean nextPermutation(int[] arr) {
		
		// 뒤에서부터 순회하며 최초로 내림차순이 아닌 오른쪽의 인덱스 찾기
		int i = arr.length - 1;
		while (i>0 && arr[i-1]>arr[i]) {
			i--;
		}
		
		// 수열이 모두 내림차순이라면 false 리턴
		if (i == 0) return false;
		
		// 뒤에서부터 순회하며 i-1번 인덱스의 숫자보다 큰 숫자를 가지는 인덱스 찾기
		int j = arr.length - 1;
		while (arr[i-1] > arr[j]) {
			j--;
		}
		
		// i-1번 인덱스와 j번 인덱스의 숫자를 swap
		swap(arr, i-1, j);
		
		// i번 인덱스부터 마지막까지 reverse
		reverse(arr, i);
		
		return true;
	}
	
	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	private static void reverse(int[] arr, int i) {
		int j = arr.length - 1;
		while (i < j) {
			swap(arr, i++, j--);
		}
	}
}
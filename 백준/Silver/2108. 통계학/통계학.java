import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 수의 개수
		int N = Integer.parseInt(br.readLine());
		
		// 수를 저장할 배열
		int[] arr = new int[N];
		
		// 수의 합을 저장할 변수
		int sum = 0;
		
		// 카운팅 배열 + 가장 많이 나온 숫자의 인덱스
		int[] cnt = new int[8001];
		int maxFreq = 0;
		
		// 수 저장
		for (int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
			if (maxFreq < ++cnt[arr[i]+4000]) {
				maxFreq = cnt[arr[i]+4000];
			}
		}
		
		// 산술 평균
		System.out.println(Math.round((float)sum/N));
		
		// 배열 정렬
		Arrays.parallelSort(arr);
		
		// 중앙값
		System.out.println(arr[N/2]);
		
		// 최빈값 구하기
		int maxFreqIdx = -1;
		for (int i=0; i<=8000; i++) {
			if (cnt[i] == maxFreq) {
				if (maxFreqIdx == -1) {
					maxFreqIdx = i;
				}
				else {
					maxFreqIdx = i;
					break;
				}
			}
		}
		
		// 최빈값
		System.out.println(maxFreqIdx-4000);
		
		// 범위
		System.out.println(arr[N-1]-arr[0]);
		
	}
}

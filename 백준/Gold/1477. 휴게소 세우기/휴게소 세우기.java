import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 현재 휴게소의 개수
		int N = Integer.parseInt(st.nextToken());
		// 더 지으려고 하는 휴게소의 개수
		int M = Integer.parseInt(st.nextToken());
		// 고속도로의 길이
		int L = Integer.parseInt(st.nextToken());
		
		// 현재 휴게소의 위치
		int[] location = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			location[i] = Integer.parseInt(st.nextToken());
		}
		location[N] = L;
		Arrays.parallelSort(location);
		
		// 이분탐색으로 휴게소 사이의 최대 간격의 최솟값 찾기
		int s = 1;
		int e = (L + 1) / 2;
		while (s < e) {
			
			// 이번 루프에서 판단할 휴게소의 간격
			int mid = (s + e) / 2;
			
			// 추가로 지을 수 있는 휴게소 개수
			int remain = M;
			
			// 0에서부터 다음 휴게소까지의 거리가 간격보다 크다면 remain에서 빼기
			int cur = 0;
			for (int l : location) {
				remain -= (l - cur - 1) / mid; 
				if (remain < 0) break;
				cur = l;
			}
			
			// 휴게소가 mid 간격일때 가능하다면
			if (remain >= 0) e = mid;
			// 휴게소가 mid 간격일때 불가능하다면
			else s = mid + 1;
		}
		
		// 답 출력
		System.out.println(s);
	}
}

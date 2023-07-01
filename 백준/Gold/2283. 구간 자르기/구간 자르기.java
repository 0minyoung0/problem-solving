import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 구간의 개수
		int N = Integer.parseInt(st.nextToken());
		// 만들고 싶은 길이의 총합
		int K = Integer.parseInt(st.nextToken());
		
		// i~i+1에 존재하는 구간의 개수
		int[] cnt = new int[1000001];
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			
			// 왼쪽 끝점과 오른쪽 끝점 처리
			cnt[Integer.parseInt(st.nextToken())]++;
			cnt[Integer.parseInt(st.nextToken())]--;
		}
		
		// cnt배열을 누적합 해서 각 좌표에 존재하는 구간의 개수 계산
		for (int i=0; i<1000000; i++) {
			cnt[i+1] += cnt[i];
		}
		
		// 특정 좌표 이전까지의 구간의 길이 합을 저장할 배열
		int[] subSum = new int[1000001];
		for (int i=1; i<=1000000; i++) {
			subSum[i] += subSum[i-1] + cnt[i-1];
		}
		
		// 0부터 999999까지의 A에 대해서 B 찾기
		for (int A=0; A<1000000; A++) {
			
			// 찾고 싶은 subSum[B]의 값
			int target = K + subSum[A];
			
			// 탐색할 B의 범위
			int s = A+1;
			int e = 1000000;
			
			// 이분탐색
			while (s < e) {
				int mid = (s + e) / 2;
				
				// 타겟이 더 작거나 같은 경우
				if (subSum[mid] >= target) {
					e = mid;
				}
				
				// 타겟이 더 큰 경우
				else { // subSum[mid] < target
					s = mid + 1;
				}
			}
			
			// 찾은 경우 답 출력 후 리턴
			if (subSum[s] == target) {
				System.out.println(A + " " + s);
				return;
			}
		}
		
		// 조건을 만족하는 A, B가 존재하지 않는 경우
		System.out.println("0 0");
	}
}

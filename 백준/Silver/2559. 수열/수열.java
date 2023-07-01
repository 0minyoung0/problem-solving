import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 전체 날짜의 수
		int N = Integer.parseInt(st.nextToken());
		// 연속적인 K일의 온도의 합이 최대가 되는 값 구하기
		int K = Integer.parseInt(st.nextToken());
		
		// 온도의 누적합
		int[] temperature = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for (int i=1; i<=N; i++) {
			temperature[i] += Integer.parseInt(st.nextToken()) + temperature[i-1];
		}
		
		// k일의 온도의 합의 최대값 구하기
		int ans = Integer.MIN_VALUE;
		for (int i=0; i<=N-K; i++) {
			int temp = temperature[i+K] - temperature[i];
			if (ans < temp) ans = temp;
		}
		
		// 답 출력
		System.out.println(ans);
	}
}

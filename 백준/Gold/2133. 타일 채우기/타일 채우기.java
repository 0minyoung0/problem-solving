import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 3xN 크기의 벽을 2x1, 1x2 크기의 타일로 채우는 경우의 수 구하기
		int N = Integer.parseInt(br.readLine());
		
		// N이 홀수면 0 출력 후 리턴
		if (N % 2 == 1) {
			System.out.println(0);
			return;
		}
		
		// 3X(2i) 크기의 벽을 2x1, 1x2 크기의 타일로 채우는 경우의 수 ans[i]
		long[] ans = new long[N/2+1];
		ans[0] = 1;
		ans[1] = 3;
		for (int i=2; i<=N/2; i++) {
			ans[i] = ans[i-1] * ans[1];
			for (int j=i-2; j>=0; j--) {
				ans[i] += ans[j] * 2;
			}
		}
		
		// 답 출력
		System.out.println(ans[N/2]);
	}
}

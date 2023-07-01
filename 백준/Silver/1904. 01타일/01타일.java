import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 이진 수열의 길이
		int N = Integer.parseInt(br.readLine());
		
		// k자리를 만드는 경우의 수
		int[] ans = new int[N+1];
		ans[0] = 1;
		ans[1] = 1;
		
		// N자리를 만드는 경우까지 계산
		for (int i=2; i<=N; i++) {
			ans[i] = (ans[i-1] + ans[i-2]) % 15746;
		}
		
		// 답 출력
		System.out.println(ans[N]);
	}
}

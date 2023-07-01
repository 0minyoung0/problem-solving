import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 10000 이하의 소수 구하기
		boolean[] isPrime = new boolean[10001];
		Arrays.fill(isPrime, true);
		isPrime[1] = false;
		for (int i=2; i*i<=10000; i++) {
			if (!isPrime[i]) continue;
			for (int j=2*i; j<=10000; j+=i) {
				isPrime[j] = false;
			}
		}
		
		// 테스트 케이스 개수
		int T = Integer.parseInt(br.readLine());
		
		// 테스트 케이스 별로 실행
		tc: while (T-- > 0) {
			
			// 짝수 n의 골드바흐 파티션 구하기
			int n = Integer.parseInt(br.readLine());
			
			// 투포인터로 찾기
			int s = n/2;
			int e = (n+1)/2;
			while (true) {
				// 찾은 경우
				if (isPrime[s] && isPrime[e]) {
					System.out.println(s + " " + e);
					continue tc;
				}
				// 못찾은 경우
				s--;
				e++;
			}
		}
	}
}

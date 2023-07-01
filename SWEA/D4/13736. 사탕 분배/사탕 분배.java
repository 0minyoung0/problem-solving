import java.io.*;
import java.util.*;

public class Solution {
	static HashMap<Integer, Long> map;
	static long S;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 테스트 케이스의 수
		int T = Integer.parseInt(br.readLine());
		
		// 테스트 케이스 별 실행
		for (int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			
			// 사탕 개수 A, B
			long A = Long.parseLong(st.nextToken());
			long B = Long.parseLong(st.nextToken());
			
			// 사탕 개수 합
			S = A + B;
			
			// 연산 횟수 K
			int K = Integer.parseInt(st.nextToken());
			
			// map 초기화
			map = new HashMap<>();
			
			// 2의 K승 구해서 A에 곱한 값을 S로 모듈러 연산
			long ans = twoToThePowerOf(K) * A % S;
			
			// ans가 S의 절반보다 크면 ans를 S-ans로 바꿈
			if (ans > S/2) ans = S - ans;
			
			// 답 출력
			System.out.println("#" + tc + " " + ans);
		}
	}
	private static long twoToThePowerOf(int K) {
		if (K == 1) return 2;
		
		long sq = 0;
		if (map.containsKey(K/2)) sq = map.get(K/2);
		else {
			sq = twoToThePowerOf(K/2);
			map.put(K/2, sq);
		}
		
		if (K % 2 == 0) return sq * sq % S;
		else return sq * sq * 2 % S;
	}
}

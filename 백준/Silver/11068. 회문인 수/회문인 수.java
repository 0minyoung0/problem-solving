import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		// B진법 데이터를 저장할 덱
		Deque<Integer> dq = new ArrayDeque<>();
		
		// 테스트 케이스 개수
		int T = Integer.parseInt(br.readLine());
		
		// 테스트 케이스 별로 실행
		tc: while (T-- > 0) {
			
			// 테스트 데이터
			int data = Integer.parseInt(br.readLine());
			
			// 2~64진법인 경우 각각에 대해서 실행
			for (int B=2; B<=64; B++) {
				
				// 테스트 데이터를 복사
				int copyData = data;
				
				// B진법으로 변환
				while (copyData > 0) {
					dq.offerFirst(copyData%B);
					copyData/=B;
				}
				
				// 회문이면 1 출력후 continue tc
				if (palindrome(dq)) {
					sb.append("1\n");
					continue tc;
				}
			}
			
			// 회문인 경우가 없으면 0 출력
			sb.append("0\n");
		}
		
		System.out.println(sb);
	}
	
	private static boolean palindrome(Deque<Integer> dq) {
		while (dq.size() > 1) {
			if (dq.poll() != dq.pollLast()) {
				dq.clear();
				return false;
			}
		}
		dq.clear();
		return true;
	}
}

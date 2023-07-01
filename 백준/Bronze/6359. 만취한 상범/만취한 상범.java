import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 감옥 닫혔는지 저장할 boolean 배열
		boolean[] close = new boolean[101];
		for (int i=2; i<=100; i++) {
			for (int j=i; j<=100; j+=i) {
				close[j] = !close[j];
			}
		}
		
		// 방의 개수별로 답 저장
		int[] ans = new int[101];
		for (int i=1; i<=100; i++) {
			if (close[i]) ans[i] = ans[i-1];
			else ans[i] = ans[i-1] + 1;
		}
		
		// 테스트 케이스 개수
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			System.out.println(ans[Integer.parseInt(br.readLine())]);
		}
	}
}

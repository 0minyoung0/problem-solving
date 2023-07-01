import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String N = br.readLine();
		
		// 각 숫자의 개수 세기
		int[] cnt = new int[10];
		for (char c : N.toCharArray()) {
			cnt[c-'0']++;
		}
		
		// 0이 없으면 10의 배수를 못만드니까 -1 출력 후 종료
		if (cnt[0] == 0) {
			System.out.println(-1);
			return;
		}
		
		// 3으로 나눈 나머지 계산하기
		int remain = 0;
		for (int i=0; i<10; i++) {
			remain = (remain + i*cnt[i]) % 3;
		}
		
		// 3의 배수가 아닌 경우
		if (remain != 0) {
			System.out.println(-1);
			return;
		}
		
		// 답 출력하기
		StringBuilder sb = new StringBuilder();
		for (int i=9; i>=0; i--) {
			while (cnt[i] > 0) {
				sb.append(i);
				cnt[i]--;
			}
		}
		System.out.println(sb);
	}
}

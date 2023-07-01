import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 스위치 개수
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		
		// 각 사람이 공을 몇번 받았는지 체크할 배열
		int[] receive = new int[n];
		receive[0] = 1;
		
		// 현재 공을 가진 사람의 인덱스
		int cur = 0;
		
		// 공 던지는 횟수를 셀 변수
		int ans = 0;
		
		while (receive[cur] < m) {
			if (receive[cur] % 2 == 1) {
				cur = (cur + l) % n;
			} else {
				cur = (cur - l + n) % n;
			}
			ans++;
			receive[cur]++;
		}
		System.out.println(ans);
	}
}

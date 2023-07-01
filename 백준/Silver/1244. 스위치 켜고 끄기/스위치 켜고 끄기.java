import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 스위치 개수
		int n = Integer.parseInt(br.readLine());
		
		// 스위치의 상태 (1-indexed)
		boolean[] isOn = new boolean[n+1];
		st = new StringTokenizer(br.readLine());
		for (int i=1; i<=n; i++) {
			if (st.nextToken().equals("1")) {
				isOn[i] = true;
			}
		}
		
		// 학생 수
		int m = Integer.parseInt(br.readLine());
		
		// 스위치 조작
		for (int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			char gender = st.nextToken().charAt(0);
			int num = Integer.parseInt(st.nextToken());
			
			// 성별에 따라 다른 방식으로 스위치 조작
			if (gender == '1') {
				int cur = num;
				// num의 배수인 인덱스에 대해서
				while (cur <= n) {
					isOn[cur] = !isOn[cur];
					cur += num;
				}
			}else { // gender == '2'
				isOn[num] = !isOn[num];
				int cur1 = num - 1;
				int cur2 = num + 1;
				// 배열 범위 안벗어나고 대칭인 인덱스에 대해서
				while (cur1 > 0 && cur2 <= n && isOn[cur1] == isOn[cur2]) {
					isOn[cur1] = !isOn[cur1];
					isOn[cur2] = !isOn[cur2];
					cur1--;
					cur2++;
				}
			}
		}
		
		// 스위치 상태 출력
		for (int i=1; i<=n; i++) {
			if (isOn[i]) {
				System.out.print("1 ");
			}else {
				System.out.print("0 ");
			}
			if (i % 20 == 0) {
				System.out.println();
			}
		}
	}
}

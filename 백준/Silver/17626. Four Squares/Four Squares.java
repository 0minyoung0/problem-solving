import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		int[] chk = new int[n+1];
		
		// n이하의 제곱수를 List에 저장
		List<Integer> list = new ArrayList<>();
		for (int i=1; i*i<=n; i++) {
			if (i*i == n) {
				System.out.println(1);
				return;
			}
			chk[i*i] = 1;
			list.add(i*i);
		}
		
		// 답이 2인 경우 찾기
		for (int i=1; i<n; i++) {
			if (chk[i] != 1) continue;
			for (int sq : list) {
				if (i + sq > n) break;
				if (chk[i + sq] > 0) continue;
				if (i + sq == n) {
					System.out.println(2);
					return;
				}
				chk[i + sq] = 2;
			}
		}
		
		// 답이 3인 경우 찾기
		for (int i=1; i<n; i++) {
			if (chk[i] != 2) continue;
			for (int sq : list) {
				if (i + sq > n) break;
				if (chk[i + sq] > 0) continue;
				if (i + sq == n) {
					System.out.println(3);
					return;
				}
			}
		}
		
		// 답이 4인 경우
		System.out.println(4);
	}
}

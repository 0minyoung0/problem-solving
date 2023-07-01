import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		char[] P = new char[2*N+1];
		for (int i=0; i<=2*N; i+=2) {
			P[i] = 'I';
		}
		for (int i=1; i<2*N; i+=2) {
			P[i] = 'O';
		}
		
		int M = Integer.parseInt(br.readLine());
		char[] S = br.readLine().toCharArray();
		
		// P의 실패함수
		int[] f = new int[P.length];
		int j = 0;
		for (int i = 1; i < f.length; i++) {
			while (j > 0 && P[i] != P[j]) j = f[j-1];
			if (P[i] == P[j]) f[i] = ++j;
		}
		
		// 답을 저장할 변수
		int ans = 0;
		
		// KMP
		j = 0;
		for (int i = 0; i < M; i++) {
			while (j > 0 && S[i] != P[j]) j = f[j-1];
			if (S[i] == P[j]) {
				if (++j == P.length) {
					ans++;
					j = f[j-1];
				}
			}
		}
		
		// 답 출력
		System.out.println(ans);
	}
}
import java.io.*;
import java.util.*;

public class Main {
	static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 행렬의 크기
		n = Integer.parseInt(st.nextToken());
		// A의 B제곱 구하기
		long b = Long.parseLong(st.nextToken());
		// 행렬 A
		int[][] a = new int[n][n];
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<n; j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 답 출력
		int[][] ans = matrixPower(a, b);
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				System.out.print(ans[i][j] + " ");
			}System.out.println();
		}
		
	}
	private static int[][] matrixPower(int[][] a, long b) {
		if (b == 0) {
			int[][] e = new int[n][n];
			for (int i=0; i<n; i++) {
				e[i][i] = 1;
			}
			return e;
		}
		
		int[][] r = matrixPower(a, b/2);
		if (b % 2 == 0) {
			return matrixMultiple(r, r);
		}else {
			return matrixMultiple(matrixMultiple(r, r), a);
		}
	}
	private static int[][] matrixMultiple(int[][] a, int[][] b) {
		int[][] result = new int[n][n];
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				int temp = 0;
				for (int k=0; k<n; k++) {
					temp += a[i][k] * b[k][j];
				}
				result[i][j] = temp % 1000;
			}
		}
		
		return result;
	}
}

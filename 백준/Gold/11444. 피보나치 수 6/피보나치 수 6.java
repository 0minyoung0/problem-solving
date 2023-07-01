import java.io.*;

public class Main {
	static final int MOD = 1000000007;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long N = Long.parseLong(br.readLine());
		
		System.out.println(fibo(N)[0][1]);
	}
	
	// 피보나치 행렬을 리턴하는 메서드
	private static long[][] fibo(long n) {
		if (n == 1) {
			long[][] arr = {{1,1},{1,0}};
			return arr;
		}
		long[][] temp = fibo(n/2);
		if (n%2 == 0) return matrixMul(temp, temp);
		return matrixMul(matrixMul(temp, temp), fibo(1));
	}
	
	// 행렬을 곱하는 메서드
	private static long[][] matrixMul(long[][] a, long[][] b) {
		long[][] arr = new long[2][2];
		arr[0][0] = (a[0][0]*b[0][0]%MOD + a[0][1]*b[1][0]%MOD) % MOD;
		arr[1][0] = (a[0][0]*b[0][1]%MOD + a[0][1]*b[1][1]%MOD) % MOD;
		arr[0][1] = (a[1][0]*b[0][0]%MOD + a[1][1]*b[1][0]%MOD) % MOD;
		arr[1][1] = (a[1][0]*b[0][1]%MOD + a[1][1]*b[1][1]%MOD) % MOD;
		return arr;
	}
}

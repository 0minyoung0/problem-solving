import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int[][] p = new int[15][15];
		for (int i=1; i<=14; i++) {
			p[0][i] = i;
		}
		for (int i=1; i<=14; i++) {
			for (int j=1; j<=14; j++) {
				p[i][j] = p[i-1][j] + p[i][j-1];
			}
		}
		
		int T = Integer.parseInt(br.readLine());
		
		while (T-- > 0) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			System.out.println(p[k][n]);
		}
	}
}
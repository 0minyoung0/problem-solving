import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		char[][] board = new char[N][M];
		for (int i=0; i<N; i++) {
			board[i] = br.readLine().toCharArray();
		}
		
		int ans = 32;
		for (int i=0; i<=N-8; i++) {
			for (int j=0; j<=M-8; j++) {
				int temp = 0;
				for (int x=i; x<i+8; x++) {
					for (int y=j; y<j+8; y++) {
						if ((x + y) % 2 == 0) {
							if (board[x][y] == 'B') temp++;
						}
						else {
							if (board[x][y] == 'W') temp++;
						}
					}
				}
				if (temp > 32) temp = 64 - temp;
				if (ans > temp) ans = temp;
			}
		}
		
		System.out.println(ans);
	}
}

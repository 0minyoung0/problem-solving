import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int lowestGround = 256;
		int heightSum = B;
		
		int[][] g = new int[N][M];
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<M; j++) {
				g[i][j] = Integer.parseInt(st.nextToken());
				if (lowestGround > g[i][j]) lowestGround = g[i][j];
				heightSum += g[i][j];
			}
		}
		
		int time = Integer.MAX_VALUE;
		int ans = -1;
		
		for (int height=Math.min(256, heightSum/(N*M)); height>=lowestGround; height--) {
			int temp = 0;
			for (int i=0; i<N; i++) {
				for (int j=0; j<M; j++) {
					if (g[i][j] > height) temp += 2 * (g[i][j] - height);
					else if (g[i][j] < height) temp += height - g[i][j];
				}
			}
			if (time > temp) {
				time = temp;
				ans = height;
			}
		}
		
		System.out.println(time + " " + ans);
	}
}
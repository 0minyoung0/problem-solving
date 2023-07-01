import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] data = new int[N][2];
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			data[i][0] = Integer.parseInt(st.nextToken());
			data[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for (int i=0; i<N; i++) {
			int ans = 1;
			for (int j=0; j<N; j++) {
				if (data[i][0] < data[j][0] && data[i][1] < data[j][1]) ans++;
			}
			System.out.print(ans + " ");
		}
		
	}
}
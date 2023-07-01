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
		
		Arrays.parallelSort(data, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				if (o1[1] != o2[1]) return o1[1] - o2[1];
				return o1[0] - o2[0];
			}
		});
		
		for (int i=0; i<N; i++) {
			System.out.println(data[i][0] + " " + data[i][1]);
		}
		
	}
}
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 전깃줄의 개수
		int n = Integer.parseInt(br.readLine());
		
		// 전깃줄 정보
		int[][] data = new int[n][2];
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			data[i][0] = Integer.parseInt(st.nextToken());
			data[i][1] = Integer.parseInt(st.nextToken());
		}
		
		// 전깃줄을 시작점 기준으로 정렬
		Arrays.parallelSort(data, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		
		// 최장 증가 수열인가 아무튼 그거
		int[] length = new int[n];
		Arrays.fill(length, 1);
		for (int i=1; i<n; i++) {
			for (int j=i-1; j>=0; j--) {
				if (data[j][1] < data[i][1] && length[j] + 1 > length[i]) {
					length[i] = length[j] + 1;
				}
			}
		}
		
		// 답 출력
		int ans = 1;
		for (int i=n-1; i>0; i--) {
			if (ans < length[i]) ans = length[i];
		}
		System.out.println(n - ans);
	}
}
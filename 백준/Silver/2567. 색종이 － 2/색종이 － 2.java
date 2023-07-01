import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 색종이의 수
		int n = Integer.parseInt(br.readLine());
		
		// 도화지
		boolean[][] isCovered = new boolean[100][100];
		
		// 색종이 붙이기
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			for (int j=x; j<x+10; j++) {
				for (int k=y; k<y+10; k++) {
					isCovered[j][k] = true;
				}
			}
		}
		
		// 순회하며 둘레 측정
		int ans = 0;
		for (int i=0; i<100; i++) {
			if (isCovered[i][0]) {
				ans++;
			}
			if (isCovered[0][i]) {
				ans++;
			}
			for (int j=0; j<99; j++) {
				if (isCovered[i][j] != isCovered[i][j+1]) {
					ans++;
				}
				if (isCovered[j][i] != isCovered[j+1][i]) {
					ans++;
				}
			}
			if (isCovered[i][99]) {
				ans++;
			}
			if (isCovered[99][i]) {
				ans++;
			}
		}
		
		System.out.println(ans);
	}
}

import java.io.*;
import java.util.*;

public class Main {
	static int[] p;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 집합의 원소의 개수는 n+1개
		int n = Integer.parseInt(st.nextToken());
		// 연산의 개수
		int m = Integer.parseInt(st.nextToken());
		
		// 원소의 부모 배열
		p = new int[n+1];
		for (int i=1; i<=n; i++) {
			p[i] = i;
		}
		
		// 연산 처리
		StringBuilder sb = new StringBuilder();
		while(m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int oper = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if (oper == 0) {
				union(a, b);
			}else {
				if (find(a) == find(b)) sb.append("yes\n");
				else sb.append("no\n");
			}
		}
		System.out.println(sb);
	}
	private static boolean union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if (x == y) return false;
		
		p[Math.max(x, y)] = Math.min(x, y);
		return true;
	}
	private static int find(int x) {
		if (x == p[x]) return x;
		return p[x] = find(p[x]);
	}
}

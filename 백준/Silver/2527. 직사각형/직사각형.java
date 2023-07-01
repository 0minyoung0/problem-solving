import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int[] x = new int[4];
		int[] y = new int[4];
		
		for (int i=0; i<4; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<4; j++) {
				x[j] = Integer.parseInt(st.nextToken());
				y[j] = Integer.parseInt(st.nextToken());
			}
			
			int x1 = Math.max(x[0], x[2]);
			int x2 = Math.min(x[1], x[3]);
			
			int y1 = Math.max(y[0], y[2]);
			int y2 = Math.min(y[1], y[3]);
			
			if (x1 > x2 || y1 > y2) {
				System.out.println("d");
			}else if (x1 == x2 && y1 == y2) {
				System.out.println("c");
			}else if (x1 < x2 && y1 < y2) {
				System.out.println("a");
			}else {
				System.out.println("b");
			}
		}
	}
}

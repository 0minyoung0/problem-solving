import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 한 변의 크기
		int n = Integer.parseInt(st.nextToken());
		// 찾는 번호
		int m = Integer.parseInt(st.nextToken());
		
		// 재귀로 답 구하기
		int[] ans = find(n, m);
		System.out.println(ans[0] + " " + ans[1]);
	}
	private static int[] find(int size, int num) {
		if (size == 2) {
			if (num == 1) return new int[] {1, 1};
			else if (num == 2) return new int[] {1, 2};
			else if (num == 3) return new int[] {2, 2};
			else return new int[] {2, 1};
		}
		
		int q = size * size / 4;
		if (num <= q) {
			int[] sub = find(size/2, num);
			return new int[] {sub[1], sub[0]};
		}
		else if (num <= 2 * q) {
			int[] sub = find(size/2, num-q);
			return new int[] {sub[0], sub[1]+size/2};
		}
		else if (num <= 3 * q) {
			int[] sub = find(size/2, num-2*q);
			return new int[] {sub[0]+size/2, sub[1]+size/2};
		}
		else {
			int[] sub = find(size/2, num-3*q);
			return new int[] {size+1-sub[1], size/2+1-sub[0]};
		}
	}
}

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 카드의 개수
		int n = Integer.parseInt(st.nextToken());
		// 목표 숫자
		int m = Integer.parseInt(st.nextToken());
		
		// 카드 숫자
		int[] cards = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<n; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}
		
		int ans = 3;
		for (int i=0; i<n-2; i++) {
			for (int j=i+1; j<n-1; j++) {
				for (int k=j+1; k<n; k++) {
					int temp = cards[i] + cards[j] + cards[k];
					if (temp <= m && temp > ans) ans = temp;
				}
			}
		}
		
		System.out.println(ans);
	}
}

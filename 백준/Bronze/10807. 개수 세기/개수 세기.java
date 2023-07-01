import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 정수의 개수
		int N = Integer.parseInt(br.readLine());
		
		// 정수
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 찾을 숫자
		int v = Integer.parseInt(br.readLine());
		
		// v의 개수
		int ans = 0;
		for (int i=0; i<N; i++) {
			if (arr[i] == v) ans++;
		}
		System.out.println(ans);
	}
}

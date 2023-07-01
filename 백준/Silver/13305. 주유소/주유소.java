import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 도시의 개수
		int N = Integer.parseInt(br.readLine());
		
		// 도로의 길이
		int[] dist = new int[N-1];
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N-1; i++) {
			dist[i] = Integer.parseInt(st.nextToken());
		}
		
		// 주유소의 리터당 가격
		int[] cost = new int[N-1];
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N-1; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
		}
		
		// 제일 왼쪽 도시에서 제일 오른쪽 도시로 가는 최소 비용
		long ans = 0;
		int lowestCost = 1000000000;
		for (int i=0; i<N-1; i++) {
			if (lowestCost > cost[i]) lowestCost = cost[i];
			ans += (long)lowestCost * dist[i];
		}
		
		// 답 출력
		System.out.println(ans);
	}
}

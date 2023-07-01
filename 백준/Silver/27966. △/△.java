import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 정점의 개수
		int N = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		// 두 정점 사이 거리 합의 최솟값과 간선 정보를 저장
		sb.append(N - 1 + (long)(N - 1) * (N - 2));
		for (int i=2; i<=N; i++) {
			sb.append("\n1 ").append(i);
		}
		
		// 답 출력
		System.out.println(sb);
	}
}

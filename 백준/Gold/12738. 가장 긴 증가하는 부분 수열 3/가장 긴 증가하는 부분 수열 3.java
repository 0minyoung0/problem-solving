import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 수열 A의 크기
		int N = Integer.parseInt(br.readLine());
		
		// 수열 A
		int[] A = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		// LIS
		TreeSet<Integer> LIS = new TreeSet<>();
		
		// LIS 구하기
		for (int i=0; i<N; i++) {
			
			// A[i]보다 크거나 같은 값이 있으면
			Integer ceilingKey = LIS.ceiling(A[i]);
			if (ceilingKey != null) {
				
				// 해당 키 제거
				LIS.remove(ceilingKey);
			}
			
			// A[i] 삽입
			LIS.add(A[i]);
		}
		
		// LIS의 길이 출력
		System.out.println(LIS.size());
	}
}
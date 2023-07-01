import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 타겟
		int T = Integer.parseInt(br.readLine());
		
		// 배열 A의 크기
		int n = Integer.parseInt(br.readLine());
		
		// 배열 A
		int[] A = new int[n+1];
		st = new StringTokenizer(br.readLine());
		for (int i=1; i<=n; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		// 배열 A의 누적합
		int[] sA = new int[n+1];
		for (int i=1; i<=n; i++) {
			sA[i] = sA[i-1] + A[i];
		}
		
		// 배열A의 부분합으로 만들 수 있는 모든 수를 해시맵에 저장
		HashMap<Integer, Integer> mapA = new HashMap<>();
		for (int i=0; i<n; i++) {
			for (int j=i+1; j<=n; j++) {
				int temp = sA[j] - sA[i];
				if (!mapA.containsKey(temp)) mapA.put(temp, 1);
				else mapA.put(temp, mapA.get(temp) + 1);
			}
		}
		
		// 맵A의 키를 List로 변환
		List<Integer> listA = new ArrayList<>(mapA.keySet());
		
		// 배열 B의 크기
		int m = Integer.parseInt(br.readLine());
		
		// 배열 B
		int[] B = new int[m+1];
		st = new StringTokenizer(br.readLine());
		for (int i=1; i<=m; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}

		// 배열 B의 누적합
		int[] sB = new int[m+1];
		for (int i=1; i<=m; i++) {
			sB[i] = sB[i-1] + B[i];
		}

		// 배열B의 부분합으로 만들 수 있는 모든 수를 해시맵에 저장
		HashMap<Integer, Integer> mapB = new HashMap<>();
		for (int i=0; i<m; i++) {
			for (int j=i+1; j<=m; j++) {
				int temp = sB[j] - sB[i];
				if (!mapB.containsKey(temp)) mapB.put(temp, 1);
				else mapB.put(temp, mapB.get(temp) + 1);
			}
		}
		
		// 맵B의 키를 List로 변환 후 정렬
		List<Integer> listB = new ArrayList<>(mapB.keySet());
		Collections.sort(listB);
		
		// 답을 저장할 변수
		long ans = 0;
		
		// listA의 값에 대해서 (T - 해당값)이 listB에 존재하는지 탐색
		for (int a : listA) {
			int key = T - a;
			int idx = Collections.binarySearch(listB, key);
			if (idx < 0) continue;
			
			// 존재하는 경우 맵을 참조해서 ans 갱신
			ans += (long)mapA.get(a) * mapB.get(key);
		}
		
		// 답 출력
		System.out.println(ans);
	}
}

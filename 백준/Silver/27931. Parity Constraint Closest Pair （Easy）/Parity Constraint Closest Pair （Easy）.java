import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 점의 개수
		int N = Integer.parseInt(br.readLine());
		
		// 짝수
		List<Integer> even = new ArrayList<>();
		// 홀수
		List<Integer> odd = new ArrayList<>();
		
		// 점 좌표 저장
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			int temp = Integer.parseInt(st.nextToken());
			if (temp % 2 == 0) even.add(temp);
			else odd.add(temp);
		}
		
		// 정렬
		Collections.sort(even);
		Collections.sort(odd);
		
		// 서로 다른 두 점의 거리 중 짝수인 최솟값 찾기
		int ans = Integer.MAX_VALUE;
		if (even.size() >= 2) {
			for (int i=0; i<even.size()-1; i++) {
				int temp = even.get(i+1) - even.get(i);
				if (ans > temp) ans = temp;
			}
		}
		if (odd.size() >= 2) {
			for (int i=0; i<odd.size()-1; i++) {
				int temp = odd.get(i+1) - odd.get(i);
				if (ans > temp) ans = temp;
			}
		}
		
		// 없으면
		if (ans == Integer.MAX_VALUE) ans = -1;
		
		// 답 출력
		System.out.print(ans + " ");
		
		// 서로 다른 두 점의 거리 중 홀수인 최솟값 찾기
		if (even.isEmpty() || odd.isEmpty()) {
			System.out.println(-1);
			return;
		}
		ans = Integer.MAX_VALUE;
		int eIdx = 0;
		int oIdx = 0;
		while (eIdx < even.size() && oIdx < odd.size()) {
			if (even.get(eIdx) < odd.get(oIdx)) {
				int temp = odd.get(oIdx) - even.get(eIdx);
				if (ans > temp) ans = temp;
				eIdx++;
			}
			else {
				int temp = even.get(eIdx) - odd.get(oIdx);
				if (ans > temp) ans = temp;
				oIdx++;
			}
		}
		
		// 없으면
		if (ans == Integer.MAX_VALUE) ans = -1;
		
		// 답 출력
		System.out.println(ans);
	}
}

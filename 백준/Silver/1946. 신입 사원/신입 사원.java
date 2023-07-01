import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 테스트 케이스 개수
		int T = Integer.parseInt(br.readLine());
		
		// 테스트 케이스 별로 실행
		while (T-- > 0) {
			
			// 지원자의 숫자
			int N = Integer.parseInt(br.readLine());
			
			// 지원자의 서류심사 성적, 면접 성적
			List<int[]> list = new ArrayList<>();
			for (int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				int s1 = Integer.parseInt(st.nextToken());
				int s2 = Integer.parseInt(st.nextToken());
				list.add(new int[] {s1, s2});
			}
			
			// 지원자를 서류심사 순위가 높은 사람부터 순차적으로 정렬
			Collections.sort(list, new Comparator<int[]>() {
				public int compare(int[] o1, int[] o2) {
					return o1[0] - o2[0];
				}
			});
			
			// 지원자를 순차적으로 순회하며 기존에 나온 가장 높은 면접 순위보다 낮으면 선발 불가능
			int ans = N;
			int highestRank = list.get(0)[1];
			for (int i=1; i<N; i++) {
				if (list.get(i)[1] > highestRank) {
					ans--;
				}else {
					highestRank = list.get(i)[1];
				}
			}
			
			// 답 출력
			System.out.println(ans);
		}
		
	}
}
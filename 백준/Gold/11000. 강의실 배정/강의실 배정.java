import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 수업의 개수
		int N = Integer.parseInt(br.readLine());
		
		// 먼저 시작하는 수업부터 확인하기 위한 수업 정보 저장 후 정렬
		List<int[]> list = new ArrayList<>(N);
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			list.add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
		}
		Collections.sort(list, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				if (o1[0] != o2[0]) return o1[0] - o2[0];
				return o1[1] - o2[1];
			}
		});
		
		// 답을 저장할 변수
		int ans = 0;
		
		// 진행중인 수업의 끝나는 시간을 저장할 힙
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i=0; i<N; i++) {
			
			// 추가할 수업의 시작시간보다 먼저 끝나는 수업 제거
			while (!pq.isEmpty() && pq.peek() <= list.get(i)[0]) {
				pq.poll();
			}
			
			// 힙에 수업이 끝나는 시간을 추가하기
			pq.offer(list.get(i)[1]);
			
			// 힙의 크기가 기존의 최대값보다 크다면 갱신
			if (ans < pq.size()) ans = pq.size();
		}
		
		// 답 출력
		System.out.println(ans);
	}
}
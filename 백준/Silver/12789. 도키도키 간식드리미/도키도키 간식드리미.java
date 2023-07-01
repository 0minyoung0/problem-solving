import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 승환이 앞에 서있는 학생들의 수
		int N = Integer.parseInt(br.readLine());
		
		// 승환이 앞에 서있는 모든 학생들의 번호표
		Queue<Integer> q = new ArrayDeque<>();
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			q.offer(Integer.parseInt(st.nextToken()));
		}
		
		// 한 사람씩 1열로 들어갈 수 있는 공간
		Deque<Integer> s = new ArrayDeque<>();
		
		// 현재 간식을 받을 번호
		int target = 1;
		
		// 시뮬레이션
		while (target <= N) {
			
			// 큐의 맨 앞사람이 target인 경우
			if (!q.isEmpty() && q.peek().equals(target)) {
				q.poll();
				target++;
				continue;
			}
			
			// 스택의 맨 앞사람이 target인 경우
			if (!s.isEmpty() && s.peek().equals(target)) {
				s.poll();
				target++;
				continue;
			}
			
			// 큐의 맨 앞사람을 스택으로 보내야하는 경우
			if (!q.isEmpty() && (s.isEmpty() || q.peek() < s.peek())) {
				s.offerFirst(q.poll());
				continue;
			}
			
			// 불가능한 경우
			System.out.println("Sad");
			return;
		}
		
		// 가능한 경우
		System.out.println("Nice");
		
	}
}

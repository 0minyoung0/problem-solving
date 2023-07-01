import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		tc: while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			int[] pre = new int[10000];
			char[] preOper = new char[10000];
			Arrays.fill(pre, -1);
			pre[A] = 10000;
			
			Queue<Integer> q = new ArrayDeque<>();
			q.offer(A);
			
			while (!q.isEmpty()) {
				int cur = q.poll();
				
				for (int oper=0; oper<4; oper++) {
					int nx = -1;
					switch (oper) {
					case 0:
						nx = (2 * cur) % 10000;
						break;
					case 1:
						nx = (cur + 9999) % 10000;
						break;
					case 2:
						nx = cur % 1000 * 10 + cur / 1000;
						break;
					case 3:
						nx = cur % 10 * 1000 + cur / 10;
						break;
					}
					
					// 방문한적 있는 숫자인 경우
					if (pre[nx] != -1) continue;
					
					// pre와 preOper 갱신
					q.offer(nx);
					pre[nx] = cur;
					preOper[nx] = operi2c(oper);
					
					// B에 도달한 경우
					if (nx == B) {
						
						// 스택에 연산자 저장 후 뒤집어가며 스트링빌더에 저장
						Deque<Character> stack = new ArrayDeque<>();
						while (nx != A) {
							stack.offerFirst(preOper[nx]);
							nx = pre[nx];
						}
						while (!stack.isEmpty()) {
							sb.append(stack.poll());
						}
						sb.append("\n");
						continue tc;
					}
				}
			}
		}
		System.out.println(sb);
	}
	private static char operi2c(int o) {
		switch(o) {
		case 0:
			return 'D';
		case 1:
			return 'S';
		case 2:
			return 'L';
		case 3:
			return 'R';
		}
		return 0;
	}
}
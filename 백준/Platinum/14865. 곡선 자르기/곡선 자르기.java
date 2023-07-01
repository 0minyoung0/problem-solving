import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 꼭짓점의 수
		int n = Integer.parseInt(br.readLine());
		
		// 꼭짓점 받으면서 list에 넣기
		List<int[]> list = new ArrayList<>();
		
		st = new StringTokenizer(br.readLine());
		int pre_x = Integer.parseInt(st.nextToken());
		int pre_y = Integer.parseInt(st.nextToken());
		int first_x = pre_x;
		int first_y = pre_y;
		for (int i=0; i<n-1; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			// 해당 x좌표에서 직선이 바닥에서 올라올때
			if (pre_x == x && pre_y<0 && y>0) {
				list.add(new int[] {x, 0});
			}
			// 해당 x좌표에서 직선이 바닥으로 들어갈 때
			else if (pre_x == x && pre_y>0 && y<0) {
				list.add(new int[] {x, 1});
			}
			// pre 좌표 갱신
			pre_x = x;
			pre_y = y;
		}
		// 처음 좌표와 마지막 좌표가 x축에 닿는 경우
		// 해당 x좌표에서 직선이 바닥에서 올라올때
		if (pre_x == first_x && pre_y<0 && first_y>0) {
			list.add(new int[] {first_x, 0});
		}
		// 해당 x좌표에서 직선이 바닥으로 들어갈 때
		else if (pre_x == first_x && pre_y>0 && first_y<0) {
			list.add(new int[] {first_x, 1});
		}
		
		// list의 첫번째 노드와 두번째 노드가 짝이 아닌 경우
		if (list.get(0)[1] == 1) {
			// 앞에서 제거해서 맨 뒤에 붙이기
			list.add(list.remove(0));
		}
		
		// 리스트를 순회하며 짝이 맞는 노드끼리 작은 값엔 0, 큰 값엔 1을 부여
		for (int i=0; i<list.size(); i+=2) {
			if (list.get(i)[0] < list.get(i+1)[0]) {
				list.set(i, new int[] {list.get(i)[0], 0});
				list.set(i+1, new int[] {list.get(i+1)[0], 1});
			}else {
				list.set(i, new int[] {list.get(i)[0], 1});
				list.set(i+1, new int[] {list.get(i+1)[0], 0});
			}
		}
		
		// 리스트를 value 기준으로 정렬
		Collections.sort(list, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				return o1[0]-o2[0];
			}
		});
		
		// 다른 봉우리에 의해 포함되지 않는 봉우리의 개수
		int ans1 = 0;
		// 다른 봉우리를 포함하지 않는 봉우리의 개수
		int ans2 = 0;
		
		// 정렬된 list의 노드를 stack에 저장하면서 ans1 계산
		Deque<Integer> stack = new ArrayDeque<>();
		for (int i=0; i<list.size(); i++) {
			if (list.get(i)[1] == 0) {
				stack.offerFirst(list.get(i)[0]);
			}else { // list.get(i)[1] == 1
				stack.poll();
				if (stack.isEmpty()) {
					ans1++;
				}
				if (list.get(i-1)[1] == 0) {
					ans2++;
				}
			}
		}
		
		System.out.println(ans1 + " " + ans2);
	}
}

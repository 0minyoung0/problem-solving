import java.util.*;

public class Main {
	static int[] preOrder;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 프리오더 초기화
		preOrder = new int[10001];
		// 인덱스 초기화
		int idx = 0;
		
		// 프리오더 저장
		while (true) {
			if (!sc.hasNext()) break;
			preOrder[idx++] = sc.nextInt();
		}
		
		// 재귀 호출로 포스트 오더 출력
		postOrder(0, idx-1);
	}
	
	private static void postOrder(int root, int end) {
		
		// 범위를 벗어나면 리턴
		if (root > end) return;

		// 왼쪽에서부터 순회하며 루트보다 큰 최초의 값 찾기
		int rightRoot = root+1;
		while (rightRoot <= end && preOrder[rightRoot] < preOrder[root]) {
			rightRoot++;
		}
		
		// 재귀호출
		postOrder(root+1, rightRoot-1);
		postOrder(rightRoot, end);
		
		// 루트 출력
		System.out.println(preOrder[root]);
	}
}

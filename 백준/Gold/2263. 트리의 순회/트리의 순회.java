import java.io.*;
import java.util.*;

public class Main {
	static int n, idx;
	static int[] inOrder, postOrder, preOrder;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		// 정점의 개수
		n = Integer.parseInt(br.readLine());
		
		// 인오더 초기화
		inOrder = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<n; i++) {
			inOrder[i] = Integer.parseInt(st.nextToken());
		}
		
		// 포스트오더 초기화
		postOrder = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<n; i++) {
			postOrder[i] = Integer.parseInt(st.nextToken());
		}
		
		// 프리오더 초기화
		preOrder = new int[n];
		
		// 재귀로 프리오더 찾기
		findPreOrder(0, n-1, 0, n-1);
		
		// 프리오더 출력
		for (int i=0; i<n; i++) {
			sb.append(preOrder[i]).append(" ");
		}
		System.out.println(sb);
	}
	
	private static void findPreOrder(int inS, int inE, int postS, int postE) {

		// 범위를 벗어나는 경우 리턴
		if (inS > inE || postS > postE) return;
		
		// 현재 확인중인 영역의 루트노드를 preOrder에 저장
		preOrder[idx++] = postOrder[postE];
		
		// 인오더에서 루트노드 인덱스 찾기
		int inOrderRootIdx = inS;
		for (int i=inS; i<=inE; i++) {
			if (inOrder[i] == postOrder[postE]) {
				inOrderRootIdx = i;
				break;
			}
		}
		
		// 재귀호출
		findPreOrder(inS, inOrderRootIdx-1, postS, postS+inOrderRootIdx-1-inS);
		findPreOrder(inOrderRootIdx+1, inE, postE+inOrderRootIdx-inE, postE-1);
	}
}

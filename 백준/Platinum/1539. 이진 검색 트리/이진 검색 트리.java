import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 배열의 크기
		int N = Integer.parseInt(br.readLine());
		
		// 배열 정보
		int[] P = new int[N];
		for (int i=0; i<N; i++) {
			P[i] = Integer.parseInt(br.readLine());
		}
		
		// 답이 될 높이의 총 합을 저장할 변수
		long ans = 1;
		
		// 각 노드의 높이를 저장할 트리맵
		TreeMap<Integer, Integer> map = new TreeMap<>();
		map.put(P[0], 1);
		
		// P[1]부터 P[N-1]까지 처리하기
		for (int i=1; i<N; i++) {
			int curNode = P[i];
			
			int height1 = -1;
			int height2 = -1;
			
			if (map.lowerKey(curNode) != null) {
				height1 = map.lowerEntry(curNode).getValue() + 1;
			}
			if (map.higherKey(curNode) != null) {
				height2 = map.higherEntry(curNode).getValue() + 1;
			}
			
			int height = height1 > height2 ? height1 : height2;
			
			map.put(curNode, height);
			
			ans += height;
		}
		
		// 답 출력
		System.out.println(ans);
	}
}

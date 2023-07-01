import java.util.*;

public class Solution {
	static int[] parent;
	public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	
    	// 테스트 케이스의 수
    	int T = sc.nextInt();
    	
    	// 각 테스트 케이스 별로 실행
    	for (int t=1; t<=T; t++) {
    		
    		// 원소의 개수
    		int n = sc.nextInt();
    		// 연산의 개수
    		int m = sc.nextInt();
    		
    		// parent 배열 초기화
    		parent = new int[n+1];
    		for (int i=1; i<=n; i++) {
    			parent[i] = i;
    		}
    		
    		// 연산처리해서 출력
    		System.out.print("#" + t + " ");
    		while (m-- > 0) {
    			int oper = sc.nextInt();
    			int a = sc.nextInt();
    			int b = sc.nextInt();
    			
    			// 합집합 연산
    			if (oper == 0) union(a, b);
    			// 같은 집합 확인 연산
    			else {
    				if (find(a) == find(b)) System.out.print(1);
    				else System.out.print(0);
    			}
    		}
    		System.out.println();
    	}
    }
	private static boolean union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if (x == y) return false;
		
		parent[Math.max(x, y)] = Math.min(x, y);
		return true;
	}
	private static int find(int x) {
		if (parent[x] == x) return x;
		return parent[x] = find(parent[x]);
	}
}	

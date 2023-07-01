import java.util.Scanner;
import java.util.Deque;
import java.util.ArrayDeque;

class Node {
	char data;
	int left;
	int right;
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 테스트케이스 별로 실행
        for (int t=1; t<=10; t++) {
        	// 트리가 가지는 정점의 총 개수
        	int n = sc.nextInt();
        	
        	// n개의 노드를 가지는 트리를 노드 배열로 만들기 (0번은 미사용)
        	Node[] tree = new Node[n+1];
        	for (int i=1; i<=n; i++) {
        		tree[i] = new Node();
        		sc.nextInt();
        		tree[i].data = sc.next().charAt(0);
        		if (2*i <= n) {
        			tree[i].left = sc.nextInt();
        			if (2*i+1 <= n) {
        				tree[i].right = sc.nextInt();
        			}
        		}
        	}
        	
        	// 순회하며 출력
        	System.out.print("#" + t + " ");
        	inorder(tree, 1);
        	System.out.println();
        }
    }
    
    // 트리 중위순회
    private static void inorder(Node[] t, int i) {
    	if (t[i].left != 0) {
    		inorder(t, 2*i);
    	}
    	System.out.print(t[i].data);
    	if (t[i].right != 0) {
    		inorder(t, 2*i+1);
    	}
    }
}
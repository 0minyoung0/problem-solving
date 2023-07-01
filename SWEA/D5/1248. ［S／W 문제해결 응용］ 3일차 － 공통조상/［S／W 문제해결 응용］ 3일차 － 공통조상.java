import java.util.Scanner;

class Node{
	int data;
	Node left;
	Node right;
	Node(int data){
		this.data = data;
	}
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 테스트케이스 개수
        int T = sc.nextInt();
        
        // 테스트케이스 별로 실행
        for (int t=1; t<=T; t++) {
        	// 트리가 가지는 정점의 개수
        	int v = sc.nextInt();
        	
        	// 트리의 정점을 담을 Node 배열 선언
        	Node[] tree = new Node[v+1];
        	for (int i=1; i<=v; i++) {
        		tree[i] = new Node(i);
        	}
        	
        	// 간선의 개수
        	int e = sc.nextInt();
        	
        	// 공통조상을 찾는 두 개의 정점 번호
        	int v1 = sc.nextInt();
        	int v2 = sc.nextInt();
        	
        	// 간선 연결하기
        	for (int i=0; i<e; i++) {
        		int parent = sc.nextInt();
        		int child = sc.nextInt();
        		if (tree[parent].left == null) {
        			tree[parent].left = tree[child];
        		}else {
        			tree[parent].right = tree[child];
        		}
        	}
        	
        	// 최초 공통조상 찾기 (후위순회)
        	Node cAncestor = findCommonAncestor(tree[1], tree[v1], tree[v2]);
        	
        	System.out.println("#" + t + " " + cAncestor.data + " " + subSize(cAncestor));
        }
    }
    
    // 후위순회하면서 공통 조상을 찾았으면 공통조상노드를 리턴
    // p나 q을 찾았으면 p나 q를 리턴하며 올라오기 그 외에는 null
    private static Node findCommonAncestor(Node root, Node p, Node q) {
    	// 노드가 없으면 null 리턴
    	if (root == null) return null;
    	// 찾는 두 노드가 root노드와 같다면 해당 노드를 리턴
    	if (root == p && root == q) return root;
    	
    	// 왼쪽 자식에서 찾아오기
    	Node x = findCommonAncestor(root.left, p, q);
    	// 공통조상을 찾았으면 바로 리턴
    	if (x != null && x != p && x != q) return x;
    	
    	// 오른쪽 자식에서 찾아오기
    	Node y = findCommonAncestor(root.right, p, q);
    	// 공통조상을 찾았으면 바로 리턴
    	if (y != null && y != p && y != q) return y;
    	
    	// 양쪽에서 뭔가 찾아왔다면 지금 루트가 공통조상!
    	if (x != null && y != null) return root;
    	
    	// 현재 루트가 p나 q라면 자기 자신을 리턴 (공통조상일수도 있음)
    	if (root == p || root == q) return root;

    	// 그 외에는 왼쪽이나 오른쪽에서 null이 아닌걸 리턴
    	if (x != null) return x;
    	if (y != null) return y;

    	// 둘다 null이면 null 리턴
    	return null;
    }
    
    private static int subSize(Node root) {
    	if (root == null) return 0;
    	if (root.left == null && root.right == null) return 1;
    	return subSize(root.left) + subSize(root.right) + 1;
    }
}
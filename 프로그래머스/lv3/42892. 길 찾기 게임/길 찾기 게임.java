import java.util.*;

class Solution {
    int[][] answer;
    int idx;
    
    public int[][] solution(int[][] nodeinfo) {
        
        // 노드 배열에 노드 입력 받기
        Node[] nodes = new Node[nodeinfo.length];
        for (int i=0; i<nodeinfo.length; i++) {
            nodes[i] = new Node(nodeinfo[i][0], nodeinfo[i][1], i+1);
        }
        
        // 노드 배열을 y좌표 내림차순으로, y좌표가 같다면 x좌표 오름차순으로 정렬
        Arrays.parallelSort(nodes, new Comparator<Node>(){
            public int compare (Node n1, Node n2) {
                if (n1.y != n2.y) return n2.y - n1.y;
                return n1.x - n2.x;
            }
        });
        
        // 노드 배열로 트리 만들기
        Node root = nodes[0];
        for (int i=1; i<nodes.length; i++) {
            insertNode(root, nodes[i]);
        }
        
        // 답 저장
        answer = new int[2][nodeinfo.length];
        // 전위 순회로 answer[0] 채우기
        idx = 0;
        preorder(root);
        // 후위 순회로 answer[1] 채우기
        idx = 0;
        postorder(root);
        
        // 답 리턴
        return answer;
    }
    
    class Node {
        int x;
        int y;
        int num;
        Node left = null;
        Node right = null;
        
        public Node(int x, int y, int num) {
            this.x = x;
            this.y = y;
            this.num = num;
        }
    }
    
    void insertNode (Node parent, Node child) {
        if (child.x < parent.x) {
            if (parent.left == null) parent.left = child;
            else insertNode(parent.left, child);
        } else {
            if (parent.right == null) parent.right = child;
            else insertNode(parent.right, child);
        }
    }
    
    void preorder(Node node) {
        if (node == null) return;
        answer[0][idx++] = node.num;
        preorder(node.left);
        preorder(node.right);
    }
    
    void postorder(Node node) {
        if (node == null) return;
        postorder(node.left);
        postorder(node.right);
        answer[1][idx++] = node.num;
    }
}
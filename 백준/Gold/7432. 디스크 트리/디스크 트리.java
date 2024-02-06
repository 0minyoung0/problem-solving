import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static class Node {
        Map<String, Node> children = new HashMap<>();
    }

    static void scan(Node node, int level) {
        if (node.children == null) return;
        List<String> list = new ArrayList<>(node.children.keySet());
        Collections.sort(list);
        for (String child : list) {
            for (int i=0; i<level; i++) {
                sb.append(" ");
            }
            sb.append(child).append("\n");
            scan(node.children.get(child), level + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 디렉토리 전체 경로의 개수
        int N = Integer.parseInt(br.readLine());

        // 디렉토리를 저장하기 위한 최초 노드
        Node root = new Node();

        // 디렉토리 경로
        while (N-- > 0) {
            Node node = root;
            String[] dirs = br.readLine().split("\\\\");
            for (String s : dirs) {
                node.children.putIfAbsent(s, new Node());
                node = node.children.get(s);
            }
        }

        // 디렉토리 출력
        scan(root, 0);
        System.out.print(sb);
    }
}

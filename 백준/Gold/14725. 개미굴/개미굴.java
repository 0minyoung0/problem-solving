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
                sb.append("--");
            }
            sb.append(child).append("\n");
            scan(node.children.get(child), level + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 먹이의 정보 개수
        int N = Integer.parseInt(br.readLine());

        // 최초 노드
        Node root = new Node();

        // 개미굴 정보
        while (N-- > 0) {
            Node node = root;
            String str = br.readLine();
            int idx = str.indexOf(" ");
            int K = Integer.parseInt(str.substring(0, idx));
            String[] dirs = str.substring(idx + 1).split(" ");
            for (String s : dirs) {
                node.children.putIfAbsent(s, new Node());
                node = node.children.get(s);
            }
        }

        // 개미굴 출력
        scan(root, 0);
        System.out.print(sb);
    }
}

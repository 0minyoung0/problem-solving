import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer>[] children = new List[N];
        for (int i=0; i<N; i++) {
            children[i] = new ArrayList<>();
        }
        int[] parent = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int root = -1;
        for (int i=0; i<N; i++) {
            int j = Integer.parseInt(st.nextToken());
            parent[i] = j;
            if (j != -1) children[j].add(i);
            else root = i;
        }
        int removeNum = Integer.parseInt(br.readLine());
        if (root == removeNum) {
            System.out.print(0);
            return;
        }
        children[parent[removeNum]].remove(Integer.valueOf(removeNum));
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(root);
        int ans = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            if (children[cur].isEmpty()) {
                ans++;
            }
            else {
                for (int child : children[cur]) {
                    q.offer(child);
                }
            }
        }
        System.out.print(ans);
    }
}
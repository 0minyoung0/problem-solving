import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] edges;
    static boolean[] visit;
    static int maxLength;
    static long maxCount;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());

            edges = new List[n];
            for (int i = 0; i < n; i++) {
                edges[i] = new ArrayList<>();
            }
            char[] label = br.readLine().toCharArray();
            st = new StringTokenizer(br.readLine());
            for (int n1 = 0; n1 < n; n1++) {
                int n2 = Integer.parseInt(st.nextToken()) - 1;
                if (n2 == -1 || label[n1] == label[n2]) {
                    continue;
                }
                edges[n1].add(n2);
                edges[n2].add(n1);
            }

            maxLength = 0;
            maxCount = 0;

            visit = new boolean[n];
            for (int node = 0; node < n; node++) {
                if (visit[node]) {
                    continue;
                }
                func(node);
            }
            sb.append(maxLength).append(' ').append(maxCount).append('\n');
        }
        System.out.print(sb);
    }

    private static int[] func(int node) {
        visit[node] = true;

        List<int[]> children = new ArrayList<>();
        for (int child : edges[node]) {
            if (visit[child]) {
                continue;
            }
            children.add(func(child));
        }

        if (children.size() == 0) {
            updateAns(1, 1);
            return new int[] { 1, 1 };
        }
        if (children.size() == 1) {
            int[] l = children.get(0);
            updateAns(l[0] + 1, l[1]);
            return new int[] { l[0] + 1, l[1] };
        }
        Collections.sort(children, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o2[0] - o1[0];
                }
                return o1[1] - o2[1];
            }
        });

        List<int[]> largest = new ArrayList<>();
        List<int[]> second = new ArrayList<>();
        for (int i = 0; i < children.size(); i++) {
            int[] l = children.get(i);
            if (largest.isEmpty() || largest.get(0)[0] == l[0]) {
                largest.add(l);
            } else if (second.isEmpty() || second.get(0)[0] == l[0]) {
                second.add(l);
            } else {
                break;
            }
        }

        if (largest.size() >= 2) {
            int length = 2 * largest.get(0)[0] + 1;
            long count = 0;
            for (int i = 0; i < largest.size(); i++) {
                for (int j = i + 1; j < largest.size(); j++) {
                    count += (long) largest.get(i)[1] * largest.get(j)[1];
                }
            }
            updateAns(length, count);
        } else {
            int length = largest.get(0)[0] + second.get(0)[0] + 1;
            long count = 0;
            for (int i = 0; i < second.size(); i++) {
                count += (long) largest.get(0)[1] * second.get(i)[1];
            }
            updateAns(length, count);
        }

        int count = 0;
        for (int[] l : largest) {
            count += l[1];
        }
        return new int[] { largest.get(0)[0] + 1, count };
    }

    private static void updateAns(int length, long count) {
        if (maxLength < length) {
            maxLength = length;
            maxCount = 0;
        }
        if (maxLength == length) {
            maxCount += count;
        }
    }
}

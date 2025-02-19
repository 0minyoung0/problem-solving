import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int ans = 0;
        int[] a = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            ans += a[i];
        }

        int[] b = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int i = 0; i < M; i++) {
            int score = 100 - a[i];
            int quotient = score / b[i];
            int remainder = score % b[i];
            if (quotient > 0) {
                treeMap.put(b[i], treeMap.getOrDefault(b[i], 0) + quotient);
            }
            if (remainder > 0) {
                treeMap.put(remainder, treeMap.getOrDefault(remainder, 0) + 1);
            }
        }

        int hours = 24 * N;
        while (!treeMap.isEmpty() && hours > 0) {
            Map.Entry<Integer, Integer> entry = treeMap.lastEntry();
            int score = entry.getKey();
            int count = entry.getValue();

            if (hours < count) {
                count = hours;
            }

            ans += score * count;
            hours -= count;

            treeMap.remove(score);
        }
        System.out.println(ans);
    }
}
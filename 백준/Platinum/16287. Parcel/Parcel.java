import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);

        boolean ans = false;

        HashMap<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                map.put(w - A[i] - A[j], new int[] { i, j });
            }
        }

        find: for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (map.containsKey(A[i] + A[j])) {
                    int[] cur = map.get(A[i] + A[j]);
                    if (cur[0] != i && cur[0] != j && cur[1] != i && cur[1] != j) {
                        ans = true;
                        break find;
                    }
                }
            }
        }

        System.out.println(ans ? "YES" : "NO");
    }
}

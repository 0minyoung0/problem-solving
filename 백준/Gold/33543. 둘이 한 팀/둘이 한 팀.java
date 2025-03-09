import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.add(new int[] { a, b, a - b });
        }

        Collections.sort(list, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                if (o1[2] != o2[2]) {
                    return o1[2] - o2[2];
                }
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });

        long[] a = new long[n + 1];
        long[] b = new long[n + 1];
        int[] diff = new int[n];
        for (int i = 0; i < n; i++) {
            a[n - 1 - i] = a[n - i] + list.get(n - 1 - i)[0];
            b[i + 1] = b[i] + list.get(i)[1];
            diff[i] = list.get(i)[2];
        }

        int q = Integer.parseInt(br.readLine());
        long aTrainingPoint = 0;
        long bTrainingPoint = 0;
        while (q-- > 0) {
            st = new StringTokenizer(br.readLine());
            if (st.nextToken().equals("A")) {
                aTrainingPoint += Integer.parseInt(st.nextToken());
            } else {
                bTrainingPoint += Integer.parseInt(st.nextToken());
            }

            long trainDiff = bTrainingPoint - aTrainingPoint;

            int x;
            if (trainDiff <= -1_000_000) {
                x = 0;
            } else if (trainDiff >= 1_000_000) {
                x = n;
            } else {
                int idx = Arrays.binarySearch(diff, (int) trainDiff);
                if (idx >= 0) {
                    x = idx;
                } else {
                    x = -idx - 1;
                }
            }

            sb.append(aTrainingPoint * (n - x) + bTrainingPoint * x + a[x] + b[x]).append('\n');
        }

        System.out.print(sb);
    }
}
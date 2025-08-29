import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        List<int[]> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        while (T-- > 0) {
            list.clear();
            set.clear();
            int N = Integer.parseInt(br.readLine());

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                set.add(x * 20_001 + y);
                list.add(new int[] { x, y });
            }

            int ans = 0;

            for (int i = 0; i < list.size(); i++) {
                int x1 = list.get(i)[0];
                int y1 = list.get(i)[1];
                for (int j = i + 1; j < list.size(); j++) {
                    int x2 = list.get(j)[0];
                    int y2 = list.get(j)[1];

                    int dx = x1 - x2;
                    int dy = y1 - y2;

                    if ((x1 + x2 + dy) % 2 == 1 || (y1 + y2 + dx) % 2 == 1) {
                        continue;
                    }

                    int nx = (x1 + x2 + dy) / 2;
                    if (nx < -10_000 || nx > 10_000) {
                        continue;
                    }
                    int ny = (y1 + y2 - dx) / 2;
                    if (ny < -10_000 || ny > 10_000) {
                        continue;
                    }
                    if (!set.contains(nx * 20_001 + ny)) {
                        continue;
                    }

                    nx -= dy;
                    if (nx < -10_000 || nx > 10_000) {
                        continue;
                    }
                    ny += dx;
                    if (ny < -10_000 || ny > 10_000) {
                        continue;
                    }
                    if (!set.contains(nx * 20_001 + ny)) {
                        continue;
                    }

                    if (ans < (dx * dx + dy * dy) / 2) {
                        ans = (dx * dx + dy * dy) / 2;
                    }
                }
            }
            System.out.println(ans);
        }
    }
}
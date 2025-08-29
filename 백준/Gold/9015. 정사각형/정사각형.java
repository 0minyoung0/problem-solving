import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        List<int[]> list;
        Set<Integer> set;

        while (T-- > 0) {
            list = new ArrayList<>();
            set = new HashSet<>();
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
                for (int j = i + 1; j < list.size(); j++) {
                    int dx = list.get(i)[0] - list.get(j)[0];
                    int dy = list.get(i)[1] - list.get(j)[1];

                    // +dy, -dx
                    int nx1 = list.get(i)[0] + dy;
                    int ny1 = list.get(i)[1] - dx;
                    int nx2 = list.get(j)[0] + dy;
                    int ny2 = list.get(j)[1] - dx;
                    if (set.contains(nx1 * 20_001 + ny1) && set.contains(nx2 * 20_001 + ny2)) {
                        if (ans < dx * dx + dy * dy) {
                            ans = dx * dx + dy * dy;
                        }
                        continue;
                    }

                    // -dy, +dx
                    nx1 = list.get(i)[0] - dy;
                    ny1 = list.get(i)[1] + dx;
                    nx2 = list.get(j)[0] - dy;
                    ny2 = list.get(j)[1] + dx;
                    if (set.contains(nx1 * 20_001 + ny1) && set.contains(nx2 * 20_001 + ny2)) {
                        if (ans < dx * dx + dy * dy) {
                            ans = dx * dx + dy * dy;
                        }
                    }
                }
            }
            System.out.println(ans);
        }
    }
}
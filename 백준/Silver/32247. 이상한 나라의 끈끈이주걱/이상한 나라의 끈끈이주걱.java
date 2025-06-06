import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            list.add(new int[] { c, x, h });
        }
        list.add(new int[] { 0, N, -1 });

        Collections.sort(list, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        int curX = 0;
        int curY = 0;

        for (int[] l : list) {
            int dx = l[1] - curX;

            if (l[0] == 0) {
                // 아래에서 올라온 끈끈이 주걱
                curY = Math.max(l[2] + 1, curY - dx);
            } else {
                // 위에서 내려온 끈끈이 주걱
                if (curY - dx >= l[2]) {
                    // 끈끈이 주걱에 걸리는 경우
                    System.out.println("adios");
                    return;
                } else {
                    curY -= dx;
                }
            }
            curX += dx;
        }

        if (curY > 0) {
            System.out.println("adios");
        } else {
            System.out.println("stay");
        }
    }
}
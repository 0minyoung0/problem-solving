import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        List<int[]> list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            list.add(new int[] { Integer.parseInt(st.nextToken()), i });
        }
        Collections.sort(list, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1];
            }
        });

        long temp = (long) list.get(N - 1)[0] * 3;
        long max = (long) list.get(N - 1)[0] * 3;
        int startIdx = N - 1;
        for (int i = N - 2; i >= 0; i--) {
            temp += (list.get(i)[0] * 2 - list.get(i + 1)[0]);
            if (max < temp) {
                max = temp;
                startIdx = i;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(N - startIdx).append('\n');
        for (int i = startIdx; i < N; i++) {
            sb.append(list.get(i)[1]).append(' ');
        }
        System.out.print(sb);
    }
}
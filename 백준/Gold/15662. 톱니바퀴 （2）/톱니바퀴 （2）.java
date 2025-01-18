import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        char[][] cogwheel = new char[T][];
        for (int i = 0; i < T; i++) {
            cogwheel[i] = br.readLine().toCharArray();
        }

        // 12시 방향을 나타내는 index
        int[] idx = new int[T];

        int K = Integer.parseInt(br.readLine());
        while (K-- > 0) {
            st = new StringTokenizer(br.readLine());
            // 회전시킨 톱니바퀴 번호
            int x = Integer.parseInt(st.nextToken()) - 1;
            // 회전시킨 방향
            int y = Integer.parseInt(st.nextToken());

            // 같이 회전하는 톱니바퀴 구간 찾기
            int start = x;
            while (start != 0) {
                if (cogwheel[start][(idx[start] + 6) % 8] != cogwheel[start - 1][(idx[start - 1] + 2) % 8]) {
                    start--;
                } else {
                    break;
                }
            }
            int end = x;
            while (end != T - 1) {
                if (cogwheel[end][(idx[end] + 2) % 8] != cogwheel[end + 1][(idx[end + 1] + 6) % 8]) {
                    end++;
                } else {
                    break;
                }
            }

            for (int i = start; i <= end; i++) {
                if ((i - x) % 2 == 0) {
                    if (y == -1) {
                        idx[i] = (idx[i] + 1) % 8;
                    } else { // y == 1
                        idx[i] = (idx[i] + 7) % 8;
                    }
                } else {
                    if (y == -1) {
                        idx[i] = (idx[i] + 7) % 8;
                    } else { // y == 1
                        idx[i] = (idx[i] + 1) % 8;
                    }
                }
            }

        }

        int ans = 0;
        for (int i = 0; i < T; i++) {
            if (cogwheel[i][idx[i]] == '1') {
                ans++;
            }
        }
        System.out.println(ans);
    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int rest;
    static int min;
    static int[] c = new int[5];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        rest = 52 - n;
        int max = Math.min(rest / 5, 8);
        min = max;
        bt(0, 13);

        System.out.print(min + " " + max);
    }

    // c 배열 내의 값의 합을 13을 유지하면서 모든 가능한 경우의 수 탐색
    private static void bt(int depth, int left) {
        if (depth == 5) {
            if (rest == 0) {
                calculateMin();
            }
            return;
        }
        for (int i = 0; i <= left; i++) {
            c[depth] = i;
            rest -= depth * i;
            bt(depth + 1, left - i);
            rest += depth * i;
        }
    }

    private static void calculateMin() {
        int ans = 0;
        int[] temp = Arrays.copyOf(c, 5);

        while (true) {
            if (temp[3] > 0) {
                temp[3]--;
            } else if (temp[4] > 0) {
                temp[4]--;
            } else {
                break;
            }

            if (temp[2] > 0) {
                temp[2]--;
            } else if (temp[4] > 0) {
                temp[4]--;
                temp[2]++;
            } else if (temp[3] > 0) {
                temp[3]--;
            } else {
                break;
            }

            ans++;
        }

        if (min > ans) {
            min = ans;
        }
    }
}

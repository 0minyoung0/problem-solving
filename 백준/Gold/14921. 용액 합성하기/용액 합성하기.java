import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 용액의 개수
        int N = Integer.parseInt(br.readLine());

        // 용액의 특성값
        int[] sol = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sol[i] = Integer.parseInt(st.nextToken());
        }

        // 0에 가장 가까운 특성값
        int ans = 200_000_001;

        // 투포인터
        int s = 0;
        int e = N - 1;
        while (s < e) {
            int newSol = sol[s] + sol[e];
            if (Math.abs(ans) > Math.abs(newSol)) {
                ans = newSol;
            }

            if (newSol < 0) {
                s++;
            } else {
                e--;
            }
        }

        // 답 출력
        System.out.println(ans);

    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 수열 A의 크기
        int N = Integer.parseInt(br.readLine());

        // 수열 A의 정보
        int[] A = new int[N];
        // 해당 숫자를 마지막으로 골랐을 때 현재까지 가장 긴 증가하는 부분 수열의 길이
        int[] length = new int[N];
        Arrays.fill(length, 1);
        // 이전에 고른 숫자
        int[] pre = new int[N];
        Arrays.fill(pre, -1);

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            for (int j = 0; j < i; j++) {
                // i번째 이전의 숫자중에 연결할 수 있는 숫자의 인덱스 j 찾기
                if (A[j] < A[i] && length[i] < length[j] + 1) {
                    length[i] = length[j] + 1;
                    pre[i] = j;
                }
            }
        }

        // 가장 긴 길이
        int maxL = 1;
        int idx = 0;
        for (int i=1; i<N; i++) {
            if (maxL < length[i]) {
                maxL = length[i];
                idx = i;
            }
        }
        System.out.println(maxL);

        // 가장 긴 증가하는 부분 수열 복원
        Deque<Integer> dq = new ArrayDeque<>();
        while (idx != -1) {
            dq.offerFirst(A[idx]);
            idx = pre[idx];
        }
        StringBuilder sb = new StringBuilder();
        while (!dq.isEmpty()) {
            sb.append(dq.poll()).append(" ");
        }
        System.out.println(sb);
    }
}

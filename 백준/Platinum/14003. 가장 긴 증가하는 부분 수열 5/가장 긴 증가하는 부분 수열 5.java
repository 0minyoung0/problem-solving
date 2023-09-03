import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 수열 A의 크기
        int N = Integer.parseInt(br.readLine());

        // 수열 A
        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        // LIS
        List<Integer> LIS = new ArrayList<>();

        // 수열의 각 숫자가 마지막일때의 길이
        int[] length = new int[N];

        // LIS 구하기
        for (int i = 0; i < N; i++) {

            // A[i]보다 크거나 같은 값이 있으면
            int idx = Collections.binarySearch(LIS, A[i]);
            if (idx < 0) {
                idx = -idx - 1;
            }
            if (idx < LIS.size()) {
                LIS.set(idx, A[i]);
            }
            // A[i] 삽입
            else {
                LIS.add(A[i]);
            }
            length[i] = idx + 1;
        }

        // LIS의 길이 출력
        System.out.println(LIS.size());

        // 정답이 될 수 있는 LIS를 출력
        Deque<Integer> dq = new ArrayDeque<>();
        int l = LIS.size();
        for (int i = N - 1; i >= 0; i--) {
            if (length[i] == l) {
                dq.offerFirst(A[i]);
                if (--l == 0) {
                    break;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int e : dq) {
            sb.append(e).append(" ");
        }
        System.out.print(sb);
    }
}
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(list);

        int i = N / 2 - 1;
        int j = N - 1;

        int ans = N;

        while (i >= 0) {
            // 박스에 들어가는 경우
            if (list.get(i) * 2 <= list.get(j)) {
                ans--;
                j--;
            }
            i--;
        }

        System.out.println(ans);
    }
}

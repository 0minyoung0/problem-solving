import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] arr;
    static int[] idx;
    static int max;

    public static void main(String[] args) throws IOException {
        init();
        findMax();
        printAns();
    }
    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];
        idx = new int[N+1];
        for (int i=0; i<N; i++) {
            int temp = Integer.parseInt(st.nextToken());
            arr[i] = temp;
            idx[temp] = i;
        }
    }
    private static void findMax() {
        int[] temp = new int[N+1];
        for (int i=0; i<N; i++) {
            int cur = arr[i];
            if (idx[cur] > idx[cur-1]) temp[cur] = temp[cur-1] + 1;
            else temp[cur] = 1;
            if (max < temp[cur]) max = temp[cur];
        }
    }
    private static void printAns() {
        System.out.print(N - max);
    }
}
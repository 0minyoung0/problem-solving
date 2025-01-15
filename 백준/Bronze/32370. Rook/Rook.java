import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int ans = 2;
        if (a == 0) {
            if (x == 0 && b > y) {
                ans = 3;
            } else {
                ans = 1;
            }
        } else if (b == 0) {
            if (y == 0 && a > x) {
                ans = 3;
            } else {
                ans = 1;
            }
        }

        System.out.println(ans);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            for (int i = 2; N > 1; i++) {
                int temp = 0;
                while (N % i == 0) {
                    temp++;
                    N /= i;
                }
                if (temp > 0) {
                    sb.append(i).append(" ").append(temp).append("\n");
                }
            }
        }
        System.out.print(sb);
    }
}
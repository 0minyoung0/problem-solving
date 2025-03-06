import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int X = Integer.parseInt(br.readLine());

        for (int i = (int) Math.ceil(Math.sqrt(X + 1)); i < 100; i++) {
            if (i * i == Math.pow(i * i / 100 + i * i % 100, 2)) {
                System.out.println(i * i);
                return;
            }
        }
        System.out.println(-1);
    }
}
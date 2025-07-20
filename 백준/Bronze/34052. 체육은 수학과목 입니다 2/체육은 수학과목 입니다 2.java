import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int remainTime = 1800 - 300;
        for (int i = 0; i < 4; i++) {
            remainTime -= Integer.parseInt(br.readLine());
        }

        if (remainTime < 0) {
            System.out.println("No");
        } else {
            System.out.println("Yes");
        }
    }
}
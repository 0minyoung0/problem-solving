import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        boolean[] isPrime = new boolean[100_000];
        Arrays.fill(isPrime, true);
        isPrime[1] = false;
        for (int i = 2; i < 100_000; i++) {
            if (!isPrime[i]) {
                continue;
            }
            for (int j = 2 * i; j < 100_000; j += i) {
                isPrime[j] = false;
            }
        }
        List<Integer> prime = new ArrayList<>();
        for (int i = 10_000; i < 100_000; i++) {
            if (isPrime[i]) {
                prime.add(i);
            }
        }

        int N = Integer.parseInt(br.readLine());

        int luckyScore = 0;
        List<String> luckyName = new ArrayList<>();

        int unluckyScore = 100_000;
        List<String> unluckyName = new ArrayList<>();

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String nums = st.nextToken();

            int X = Integer.parseInt(nums.substring(0, 5));
            int Y = Integer.parseInt(nums.substring(5));

            int min = Math.min(X, Y);
            int max = Math.max(X, Y);

            int minIdx = Collections.binarySearch(prime, min);
            if (minIdx < 0) {
                minIdx = -minIdx - 1;
            }
            int maxIdx = Collections.binarySearch(prime, max);
            if (maxIdx < 0) {
                maxIdx = -maxIdx - 2;
            }

            int score = maxIdx - minIdx + 1;
            if (score < 0) {
                score = 0;
            }

            if (luckyScore < score) {
                luckyScore = score;
                luckyName.clear();
            }
            if (luckyScore == score) {
                luckyName.add(name);
            }
            if (unluckyScore > score) {
                unluckyScore = score;
                unluckyName.clear();
            }
            if (unluckyScore == score) {
                unluckyName.add(name);
            }
        }

        Collections.sort(luckyName);
        System.out.println(luckyName.get(0));
        Collections.sort(unluckyName);
        System.out.println(unluckyName.get(0));
    }
}

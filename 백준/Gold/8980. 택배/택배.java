import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

    static int N, C;
    static int M;
    static TreeMap<Integer, Integer>[] data;
    static TreeMap<Integer, Integer> truck = new TreeMap<>();
    static int c, ans;

    public static void main(String[] args) throws IOException {
        init();
        simulation();
        printAns();
    }
    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(br.readLine());
        data = new TreeMap[N+1];
        for (int i=1; i<=N; i++) {
            data[i] = new TreeMap();
        }
        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (data[a].containsKey(b)) c += data[a].get(b);
            data[a].put(b, c);
        }
    }
    private static void simulation() {
        for (int i=1; i<=N; i++) {
            dropoff(i);
            pickup(i);
        }
    }
    private static void dropoff(int turn) {
        while (!truck.isEmpty() && truck.firstKey().equals(turn)) {
            int temp = truck.remove(turn);
            c -= temp;
            ans += temp;
        }
    }
    private static void pickup(int turn) {
        fill(turn);
        tradeoff(turn);
    }
    private static void fill(int turn) {
        while (c < C && !data[turn].isEmpty()) {
            int key = data[turn].firstKey();
            int value = data[turn].remove(key);
            if (value > C - c) {
                data[turn].put(key, value - (C - c));
                value = C - c;
            }
            c += value;
            if (truck.containsKey(key)) value += truck.get(key);
            truck.put(key, value);
        }
    }
    private static void tradeoff(int turn) {
        while (!data[turn].isEmpty() && truck.lastKey() > data[turn].firstKey()) {
            int key = data[turn].firstKey();
            int value = data[turn].remove(key);
            c += value;
            if (truck.containsKey(key)) value += truck.get(key);
            truck.put(key, value);
            while (c > C) {
                int k = truck.lastKey();
                int v = truck.get(k);
                if (c - v >= C) {
                    truck.remove(k);
                    c -= v;
                }
                else {
                    truck.put(k, v - (c - C));
                    c = C;
                }
            }
        }
    }
    private static void printAns() {
        System.out.print(ans);
    }
}
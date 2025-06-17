import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Integer> listA = new ArrayList<>();
        List<Integer> listB = new ArrayList<>();

        if (N % 3 == 2) {
            listA.add(1);
            listB.add(2);
        }
        for (int i = (N % 3 + 1); i <= N; i += 3) {
            listA.add(i);
            listA.add(i + 1);
            listB.add(i + 2);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(listA.size()).append('\n');
        for (int A : listA) {
            sb.append(A).append(' ');
        }
        sb.append('\n');
        sb.append(listB.size()).append('\n');
        for (int B : listB) {
            sb.append(B).append(' ');
        }
        System.out.println(sb);
    }
}
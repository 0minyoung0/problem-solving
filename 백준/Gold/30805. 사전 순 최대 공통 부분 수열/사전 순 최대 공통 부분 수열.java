import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        List<Integer> listA = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            listA.add(Integer.parseInt(st.nextToken()));
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        List<Integer> listB = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            listB.add(Integer.parseInt(st.nextToken()));
        }

        int startIdxA = 0;
        int startIdxB = 0;

        List<Integer> list = new ArrayList<>();

        while (true) {
            List<Integer> subListA = listA.subList(startIdxA, N);
            List<Integer> subListB = listB.subList(startIdxB, M);

            Set<Integer> intersectionSet = new HashSet<>(subListA);
            intersectionSet.retainAll(new HashSet<>(subListB));

            // 공통 값이 없는 경우
            if (intersectionSet.size() == 0) {
                break;
            }

            int largestCommonValue = -1;
            for (int item : intersectionSet) {
                if (largestCommonValue < item) {
                    largestCommonValue = item;
                }
            }
            list.add(largestCommonValue);

            startIdxA += subListA.indexOf(largestCommonValue) + 1;
            startIdxB += subListB.indexOf(largestCommonValue) + 1;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(list.size()).append('\n');
        for (int item : list) {
            sb.append(item).append(' ');
        }
        System.out.print(sb);
    }
}
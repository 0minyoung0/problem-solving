import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static Map<Integer, Integer> parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        List<Integer> nodeNum = new ArrayList<>();
        Set<Integer> numSet = new HashSet<>();
        Map<Integer, Integer> bound = new HashMap<>();
        parent = new HashMap<>();

        TC: for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            // 1. 데이터 추가
            // r, c를 노드 Map에 추가 <노드 번호, list 인덱스>
            // r, c를 노드 list에 추가
            if (!numSet.contains(r)) {
                numSet.add(r);
                nodeNum.add(r);
                parent.put(r, r);
            }
            if (!numSet.contains(c)) {
                numSet.add(c);
                nodeNum.add(c);
                parent.put(c, c);
            }

            // inbound-outbound 데이터 추가
            bound.put(r, bound.getOrDefault(r, 0) - 1);
            bound.put(c, bound.getOrDefault(c, 0) + 1);

            // 2. 연결 체크
            // 모든 노드가 연결되었는지 체크 (union find)
            union(r, c);
            // 연결 안되었으면 0 출력 후 continue
            int p = find(r);
            for (int num : nodeNum) {
                if (find(num) != p) {
                    sb.append("0\n");
                    continue TC;
                }
            }

            // 3. 오일러 경로 체크
            // 모든 노드의 inbound, outbound 체크
            // 3-1. 모든 노드의 inbound - outbound 값이 0인 경우 노드 번호의 제곱 출력
            // 3-2. inbound - outbound 값이 나머지는 다 0이고 -1, 1인 노드가 하나씩 있는 경우 -1, 1인 노드 번호 곱 출력
            // 3-3. 그 외의 경우 0 출력
            int start = 0;
            int end = 0;
            int max = 0;
            for (int num : nodeNum) {
                if (max < num) {
                    max = num;
                }
                if (bound.get(num) != 0) {
                    if (bound.get(num) == -1 && start == 0) {
                        start = num;
                    } else if (bound.get(num) == 1 && end == 0) {
                        end = num;
                    } else {
                        sb.append("0\n");
                        continue TC;
                    }
                }
            }

            if (start != 0 && end != 0) {
                sb.append(start * end).append('\n');
            } else {
                sb.append(max * max).append('\n');
            }
        }
        System.out.print(sb);
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x == y) {
            return;
        }

        parent.put(Math.max(x, y), Math.min(x, y));
    }

    private static int find(int x) {
        if (parent.get(x) == x) {
            return x;
        }
        parent.put(x, find(parent.get(x)));
        return parent.get(x);
    }
}

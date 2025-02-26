import java.io.*;
import java.util.*;

public class Main {
    static int N;
    // 블록 높이 값을 저장할 펜윅 트리
    static int[] fenwickTree = new int[100_001];
    static HashMap<Integer, Long> newCostMap;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        // key: 높이 값, value: 해당 key보다 작은 블록 모두 제거 시 index
        HashMap<Integer, List<Integer>> adjIdx = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int h = Integer.parseInt(st.nextToken());

            // 자신의 인덱스에서 왼쪽에 자기보다 작은 블록이 몇개인지 세서 빼기. 그 값을 저장
            if (adjIdx.get(h) == null) {
                adjIdx.put(h, new ArrayList<Integer>());
            }
            adjIdx.get(h).add(i - sumTree(h - 1));

            updateTree(h, 1);
        }

        List<Integer> heights = new ArrayList<>(adjIdx.keySet());
        Collections.sort(heights);

        // 각 분기에서 시작 인덱스 및 비용 (이전 분기에서 종료 인덱스)
        HashMap<Integer, Long> costMap = new HashMap<>();
        newCostMap = new HashMap<>();

        costMap.put(1, 0L);

        // 작은 높이부터 순서대로 블록 처리
        // 분기가 발생하므로 특정 높이의 블록을 모두 처리한 분기 끝에서 현재 인덱스와 cost 저장
        for (int h : heights) {
            newCostMap.clear();

            List<Integer> indexes = adjIdx.get(h);
            int firstIndex = indexes.get(0);
            int lastIndex = indexes.get(indexes.size() - 1);
            int newLastIndex = lastIndex - indexes.size();

            for (Map.Entry<Integer, Long> entry : costMap.entrySet()) {
                int prevIndex = entry.getKey();
                long prevCost = entry.getValue();

                int searchIndex = Collections.binarySearch(indexes, prevIndex);

                long newCost;
                // 왼쪽에 없는 경우
                if (searchIndex == 0 || searchIndex == -1) {
                    // left to right
                    newCost = prevCost + (lastIndex - prevIndex) + 1;
                    updateMap(newLastIndex, newCost);
                    updateMap(newLastIndex + 1, newCost);
                }
                // 오른쪽에 없는 경우
                else if (searchIndex == indexes.size() - 1 || searchIndex == -(indexes.size() + 1)) {
                    // right to left
                    newCost = prevCost + (prevIndex - firstIndex) + 1;
                    updateMap(firstIndex - 1, newCost);
                    updateMap(firstIndex, newCost);
                }
                // 양쪽에 있는 경우
                else {
                    // 왼쪽먼저 이동하는 경우
                    int leftCount = searchIndex >= 0 ? searchIndex + 1 : -(searchIndex + 1);
                    newCost = prevCost + (prevIndex - firstIndex) + ((lastIndex - firstIndex) - (leftCount - 1)) + 1;
                    updateMap(newLastIndex, newCost);
                    updateMap(newLastIndex + 1, newCost);

                    // 오른쪽 먼저 이동하는 경우
                    int rightCount = searchIndex >= 0 ? indexes.size() - searchIndex : indexes.size() + searchIndex + 1;
                    newCost = prevCost + (lastIndex - prevIndex) + ((lastIndex - firstIndex) - (rightCount - 1)) + 1;
                    updateMap(firstIndex - 1, newCost);
                    updateMap(firstIndex, newCost);
                }
            }

            costMap = new HashMap<>(newCostMap);
        }

        // 최소 비용 출력
        long ans = Long.MAX_VALUE;
        for (long c : costMap.values()) {
            if (c < ans) {
                ans = c;
            }
        }
        System.out.print(ans);
    }

    private static int sumTree(int pos) {
        int ret = 0;
        while (pos > 0) {
            ret += fenwickTree[pos];
            pos -= (pos & -pos);
        }
        return ret;
    }

    private static void updateTree(int pos, int val) {
        while (pos <= 100_000) {
            fenwickTree[pos] += val;
            pos += (pos & -pos);
        }
    }

    private static void updateMap(int index, long cost) {
        if (!newCostMap.containsKey(index) || cost < newCostMap.get(index)) {
            newCostMap.put(index, cost);
        }
    }
}

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<int[]> list = new ArrayList<>();
        HashSet<Integer> daySet = new HashSet<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());

            list.add(new int[] { S, E, P, D });
            daySet.add(S - 1);
            daySet.add(S);
            daySet.add(E);
        }

        // list를 S 순서로 정렬
        Collections.sort(list, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1];
            }
        });

        // E 순서로 정렬되는 PQ
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return o1[1] != o2[1] ? o1[1] - o2[1] : o1[0] - o2[0];
            }
        });

        // 최소 K개의 아이템을 확보하기 위해 필요한 행동력의 최솟값
        long ans = Long.MAX_VALUE;
        // 시뮬레이션 직전 날짜
        int prevDay = 0;
        // 시뮬레이션 중 현재 행동력 계산값
        long curPoint = 0;
        // 현재 pq에 들어간 D의 총 합
        long totalD = 0;
        // 순회중인 list의 인덱스
        int listIdx = 0;

        // 정렬된 날짜 리스트
        List<Integer> dayList = new ArrayList<>(daySet);
        Collections.sort(dayList);

        // 시뮬레이션
        for (int curDay : dayList) {

            // 지난 날짜와 현재 날짜 사이의 행동력 변화 갱신
            curPoint -= totalD * (curDay - prevDay);

            // list에 S가 현재 날짜와 일치하는 데이터가 있다면 PQ에 추가
            while (listIdx < N && list.get(listIdx)[0] == curDay) {
                int[] cur = list.get(listIdx++);
                pq.offer(cur);
                curPoint += cur[2];
                totalD += cur[3];
            }

            // 현재 날짜가 K개 이상의 아이템을 확보할 수 있다면 행동력 저장
            if (pq.size() >= K) {
                if (ans > curPoint) {
                    ans = curPoint;
                }
            }

            // 다음 시뮬레이션을 위해 현재 날짜가 E와 일치하는 데이터 제거
            while (!pq.isEmpty() && pq.peek()[1] == curDay) {
                int[] cur = pq.poll();
                curPoint -= cur[2] - cur[3] * (cur[1] - cur[0]);
                totalD -= cur[3];
            }

            // 다음 시뮬레이션을 위해 지난 날짜를 현재 날짜로 갱신
            prevDay = curDay;
        }

        if (ans == Long.MAX_VALUE) {
            ans = -1;
        }
        System.out.print(ans);
    }
}

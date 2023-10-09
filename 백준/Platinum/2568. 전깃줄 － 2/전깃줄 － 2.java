import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 전깃줄의 개수
        int N = Integer.parseInt(br.readLine());

        // 전깃줄 정보를 저장할 리스트
        List<int[]> list = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        // 리스트를 시작 번호 기준으로 정렬
        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        // 가장 긴 증가하는 부분수열
        List<Integer> LIS = new ArrayList<>();

        // 해당번째 숫자가 마지막일때의 길이
        int[] length = new int[N];

        // LIS 구하기
        for (int i = 0; i < N; i++) {

            // 새 전깃줄의 위치 찾기
            int idx = -Collections.binarySearch(LIS, list.get(i)[1]) - 1;

            // 기존 값을 작은 값으로 대체
            if (idx < LIS.size()) {
                LIS.set(idx, list.get(i)[1]);
            }
            // 맨 끝에 새 값 추가
            else {
                LIS.add(list.get(i)[1]);
            }
            length[i] = idx + 1;
        }

        // 삭제해야하는 전깃줄의 최소 개수 출력
        System.out.println(N - LIS.size());

        // LIS에 들어가는 전깃줄의 도착번호로 set 만들기
        Set<Integer> set = new HashSet<>();
        int l = LIS.size();
        for (int i = N - 1; i >= 0; i--) {
            if (length[i] == l) {
                set.add(list.get(i)[1]);
                if (--l == 0) {
                    break;
                }
            }
        }

        // LIS에 안들어가는 전깃줄의 시작번호를 저장할 리스트
        List<Integer> ans = new ArrayList<>();
        for (int[] e : list) {
            if (!set.contains(e[1])) {
                ans.add(e[0]);
            }
        }

        // 삭제할 전깃줄의 시작번호를 오름차순으로 출력
        Collections.sort(ans);
        StringBuilder sb = new StringBuilder();
        for (int a : ans) {
            sb.append(a).append("\n");
        }
        System.out.print(sb);
    }
}

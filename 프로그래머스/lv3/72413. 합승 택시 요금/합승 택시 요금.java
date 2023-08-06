import java.util.*;

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        // 택시를 타고 가다가 갈라지는 지점을 x라 할때 (s_x) + (x_a) + (x_b) 비용의 최소를 구하면 됨
        // 플로이드 알고리즘 활용
        
        final int INF = 1_000_000_000;
        
        // 최단 비용 테이블
        int[][] cost = new int[n+1][n+1];
        for (int i=1; i<=n; i++) {
            Arrays.fill(cost[i], 1_000_000_000);
            cost[i][i] = 0;
        }
        
        // fares의 정보를 테이블에 저장
        for (int[] fare : fares) {
            if (cost[fare[0]][fare[1]] > fare[2]) cost[fare[0]][fare[1]] = fare[2];
            if (cost[fare[1]][fare[0]] > fare[2]) cost[fare[1]][fare[0]] = fare[2];
        }
        
        // 플로이드 알고리즘
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=n; j++) {
                for (int k=1; k<=n; k++) {
                    if (cost[j][k] > cost[j][i] + cost[i][k]) {
                        cost[j][k] = cost[j][i] + cost[i][k];
                    }
                }
            }
        }
        
        // 답 계산
        int answer = Integer.MAX_VALUE;
        for (int i=1; i<=n; i++) {
            if (cost[s][i] == INF || cost[i][a] == INF || cost[i][b] == INF) continue;
            if (answer > cost[s][i] + cost[i][a] + cost[i][b]) {
                answer = cost[s][i] + cost[i][a] + cost[i][b];
            }
        }
        return answer;
    }
}
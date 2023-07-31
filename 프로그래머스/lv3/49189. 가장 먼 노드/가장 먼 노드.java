import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        List<Integer>[] graph = new List[n+1];
        for (int i=1; i<=n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] e : edge) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }
        
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(1);
        
        int[] dis = new int[n+1];
        dis[1] = 1;
        
        int maxDis = 1;
        
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int nx : graph[cur]) {
                if (dis[nx] > 0) continue;
                q.offer(nx);
                dis[nx] = dis[cur] + 1;
                if (maxDis < dis[nx]) {
                    maxDis = dis[nx];
                }
            }
        }
        
        int answer = 0;
        
        for (int d : dis) {
            if (d == maxDis) answer++;
        }
        
        return answer;
    }
}
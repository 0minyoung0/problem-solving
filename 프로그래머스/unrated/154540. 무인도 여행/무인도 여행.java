import java.util.*;

class Solution {
    public int[] solution(String[] maps) {
        List<Integer> list = new ArrayList<>();
        
        int r = maps.length;
        int c = maps[0].length();
        
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        
        Queue<int[]> q = new ArrayDeque<>();
        
        boolean[][] vis = new boolean[r][c];
        
        for (int i=0; i<r; i++) {
            for (int j=0; j<c; j++) {
                if (vis[i][j] || maps[i].charAt(j) == 'X') continue;
                int temp = maps[i].charAt(j) - '0';
                q.offer(new int[] {i, j});
                vis[i][j] = true;
                while (!q.isEmpty()) {
                    int[] cur = q.poll();
                    for (int dir=0; dir<4; dir++) {
                        int nx = cur[0] + dx[dir];
                        int ny = cur[1] + dy[dir];
                        if (nx<0 || nx>=r || ny<0 || ny>=c || vis[nx][ny] || maps[nx].charAt(ny) == 'X') continue;
                        temp += maps[nx].charAt(ny) - '0';
                        q.offer(new int[] {nx, ny});
                        vis[nx][ny] = true;
                    }
                }
                list.add(temp);
            }
        }
        
        if (list.size() == 0) return new int[] {-1};
        
        Collections.sort(list);
        
        int[] answer = new int[list.size()];
        for (int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}
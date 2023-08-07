import java.util.*;

class Solution {
    int[][] dp;
    List<Integer>[] tree;
    
    public int solution(int[] sales, int[][] links) {
        // 각 인원이 참가안했을때(0), 참가했을때(1)의 매출액 저장
        dp = new int[sales.length+1][2];
        
        // 트리 구조를 인접 리스트 꼴로 저장
        tree = new List[sales.length+1];
        for (int i=1; i<=sales.length; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int[] link : links) {
            tree[link[0]].add(link[1]);
        }
        
        // 재귀로 돌면서 dp 테이블 계산
        func(1, sales);
        
        // 답 리턴
        return Math.min(dp[1][0], dp[1][1]);
    }
    
    // 재귀로 돌면서 dp 테이블 계산
    private void func(int parent, int[] sales) {
        
        // 자기 아래의 팀원들의 합을 저장
        int childSum = 0;
        
        // 팀원 중 한명이라도 참석했는지 여부 저장
        boolean childAttendance = false;
        
        for (int child : tree[parent]) {
            func(child, sales);
            if (dp[child][0] > dp[child][1]) childAttendance = true;
            childSum += Math.min(dp[child][0], dp[child][1]);
        }
        
        // 자기 아래의 팀원이 없거나 자기 아래의 팀원이 참가한게 최소인 경우
        if (tree[parent].size() == 0 || childAttendance) {
            // 본인이 참가 안하는 경우는 아래 팀원들의 합과 같음
            dp[parent][0] = childSum;
        }
        
        // 자기 아래의 팀원이 있지만 아무도 참가 안하는게 최소인 경우
        else {
            dp[parent][0] = Integer.MAX_VALUE;
            // 돌아가면서 참가시켜보고 본인이 참가하지 않는 경우의 최소값 찾기
            for (int child : tree[parent]) {
                if (dp[parent][0] > childSum - dp[child][0] + dp[child][1]) {
                    dp[parent][0] = childSum - dp[child][0] + dp[child][1];
                }
            }
        }
        
        // 본인이 참가하는 경우
        dp[parent][1] = sales[parent-1] + childSum;
        
    }
}
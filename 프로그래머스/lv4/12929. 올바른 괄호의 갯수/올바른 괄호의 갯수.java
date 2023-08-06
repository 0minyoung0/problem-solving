class Solution {
    char[] string = new char[14];
    int answer = 0;
    int cnt1 = 0;
    int cnt2 = 0;
    
    public int solution(int n) {
        cntAnswer(n, 0);
        return answer;
    }
    
    private void cntAnswer(int n, int k) {
        if (k==n*2) {
            answer++;
            return;
        }
        if (cnt1 < n) {
            cnt1++;
            cntAnswer(n, k+1);
            cnt1--;
        }
        if (cnt2 < n && cnt1 > cnt2) {
            cnt2++;
            cntAnswer(n, k+1);
            cnt2--;
        }
    }
}
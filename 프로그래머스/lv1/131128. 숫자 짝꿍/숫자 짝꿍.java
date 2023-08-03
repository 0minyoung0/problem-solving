class Solution {
    public String solution(String X, String Y) {
        // X와 Y에 있는 숫자 카운팅
        int[] cntX = new int[10];
        int[] cntY = new int[10];
        for (char k : X.toCharArray()) {
            cntX[k-'0']++;
        }
        for (char k : Y.toCharArray()) {
            cntY[k-'0']++;
        }
        
        // 9부터 0까지 해당 숫자의 개수만큼 스트링 빌더에 append
        StringBuilder sb = new StringBuilder();
        for (int i=9; i>=0; i--){
            for (int j=Math.min(cntX[i], cntY[i]); j>0; j--) {
                sb.append(i);
            }
        }
        
        // 겹치는 숫자가 없는 경우
        if(sb.length() == 0) return "-1";
        // 겹치는 숫자가 0뿐인 경우
        if(sb.length() == Math.min(cntX[0], cntY[0])) return "0";
        // 가장 큰 짝꿍 리턴
        return sb.toString();
    }
}
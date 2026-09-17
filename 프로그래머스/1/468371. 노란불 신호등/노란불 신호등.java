class Solution {
    public int solution(int[][] signals) {
        int size = 1;
        for (int[] i : signals) {
            size *= i[0] + i[1] + i[2];
            // size *= 20;
        }
        int[] result = new int[size];
        int k = 1;
        for (int i = 0; i < signals.length;) {
            k += signals[i][0];
            if (k >= size) {
                i++;
                k = 1;
                continue;
            }
            for (int j = 0; j < signals[i][1]; j++) result[k+j]++;
            k += signals[i][1];
            k += signals[i][2];
        }
        
        int answer = -1;
        for (int i = 0; i < size; i++) {
            if (result[i] == signals.length) {
                answer = i;
                break;
            }
        }
        
        return answer;
    }
}
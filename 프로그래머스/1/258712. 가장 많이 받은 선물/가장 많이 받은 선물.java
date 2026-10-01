import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int index = 0;
        HashMap<String, Integer> nameMap = new HashMap<>();
        for (String friend : friends) nameMap.put(friend, index++);
        int[][] giftArr = new int[friends.length][friends.length];
        int[] giftScore = new int[friends.length];
        for (String gift : gifts) {
            String[] split = gift.split(" ");
            int from = nameMap.get(split[0]);
            int to = nameMap.get(split[1]);
            giftArr[from][to]++;
            giftScore[from]++;
            giftScore[to]--;
        }

        int[] nextMonth = new int[friends.length];
        for (int i = 0; i < friends.length; i++) {
            for (int j = i+1; j < friends.length; j++) {
                if (giftArr[i][j] > giftArr[j][i]) nextMonth[i]++;
                else if (giftArr[i][j] < giftArr[j][i]) nextMonth[j]++;
                else if (giftScore[i] > giftScore[j]) nextMonth[i]++;
                else if (giftScore[i] < giftScore[j]) nextMonth[j]++;
            }
        }
        return Arrays.stream(nextMonth).max().getAsInt();
    }
}
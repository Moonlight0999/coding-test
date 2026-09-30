import java.util.HashSet;

class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        HashSet<Integer> lates = new HashSet<>();
        for (int day = 0; day < 7; day++){
            if ((startday + day-1)%7 > 4) continue;

            for (int i = 0;i < schedules.length;i++) {
                if (!lates.contains(i) && (timelogs[i][day]/100)*60+timelogs[i][day]%100 > schedules[i]/100*60 + schedules[i]%100 + 10) {
                    System.out.println(i + " " + timelogs[i][day]);
                    lates.add(i);
                }
            }

        }
        System.out.println(schedules.length + " " +  lates.size());
        int answer = schedules.length - lates.size();
        return answer;
    }
}
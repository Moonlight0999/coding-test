import java.util.Arrays;
import java.util.Stack;

class Solution {
    public int solution(int n, int w, int num) {
        int answer = 1;
        Stack<Integer>[] stack = new  Stack[w];
        for (int i = 0; i < w; i++) {
            stack[i] = new Stack<>();
        }

        int boxNum = 1;
        int flag = 0;
        int count = 0;
        for (int i = 0; true; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < w; j++) {
                    if (boxNum == num) flag = j;
                    stack[j].push(boxNum++);
                    if (++count >= n) break;
                }
            }
            else {
                for (int j = w-1; j >= 0; j--) {
                    if (boxNum == num) flag = j;
                    stack[j].push(boxNum++);
                    if (++count >= n) break;
                }
            }
            if (count >= n) break;
        }
//        System.out.println(Arrays.toString(stack));
        while (!stack[flag].isEmpty() && stack[flag].pop() != num) {
            answer++;
        }
        return answer;
    }
}
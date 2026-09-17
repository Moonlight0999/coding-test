import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

class Solution {
    public int solution(String message, int[][] spoiler_ranges) {
        HashSet<String> noSpoiler = new HashSet<>();
        HashSet<String> spoiler = new HashSet<>();
        StringTokenizer st = new StringTokenizer(message);
        String[] messageTokens = new  String[st.countTokens()];
        int[] messageLengths = new int[st.countTokens()];
        int size = 0;
        while (st.hasMoreTokens()) {
            messageTokens[size] = st.nextToken();
            messageLengths[size] = messageTokens[size].length();
            size++;
        }
        Boolean[] isSpoiler = new Boolean[messageTokens.length];
        for (int i = 0; i < messageTokens.length; i++) {
            isSpoiler[i] = false;
        }

        for (int[] sp : spoiler_ranges) {

            StringTokenizer spoilPart =  new StringTokenizer(message.substring(sp[0], sp[1]+1));
            char[] chMes = message.toCharArray();
            int tokenLen = 0;
            while( spoilPart.hasMoreTokens() ) {
                String token = spoilPart.nextToken();
//                System.out.println("token: " + "\"" + token + "\"");

                int left = sp[0] + tokenLen;
                int right = left + token.length();
                tokenLen += token.length() + 1;
//                System.out.println("sp: " + sp[0] + " " + sp[1]);

                while (left > 0 && chMes[left] != ' ') left--;
                if (chMes[left] == ' ') left++;
                while (right < chMes.length && chMes[right] != ' ') right++;
                String word = ' ' + message.substring(left, right) + ' ';
//                System.out.println("Left, Right, Word: " + left+" "+right+" "+word);

                int len = 0;
                int count = 0;
                while (left > len) len += messageLengths[count++] + 1;
                isSpoiler[count] = true;
//                System.out.println("Len, Count: " + len + " " + count + " \n");
            }
        }
        for (int i = 0; i < messageTokens.length; i++) {
            if (!isSpoiler[i]) {
                noSpoiler.add(messageTokens[i]);
            }
        }
        for (int i = 0; i < messageTokens.length; i++) {
            if (isSpoiler[i] && !noSpoiler.contains(messageTokens[i])) {
                spoiler.add(messageTokens[i]);
            }
        }

//        System.out.println(spoiler);
//        System.out.println(noSpoiler);
//        System.out.println(Arrays.stream(isSpoiler).toList());

        return spoiler.size();
    }
}
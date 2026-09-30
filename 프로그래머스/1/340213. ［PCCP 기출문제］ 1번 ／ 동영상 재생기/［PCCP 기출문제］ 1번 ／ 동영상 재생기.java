class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int now = (time2int(pos));
        int iop_start = time2int(op_start);
        int iop_end = time2int(op_end);
        int ivideo_len = time2int(video_len);
        if (now >= iop_start && now <= iop_end) now = iop_end;
        for (String command : commands) {
            switch (command) {
                case "next":
                    now += 10;
                    break;
                case "prev":
                    now = Math.max(now - 10, 0);
                    break;
            }
            if (now >= iop_start && now <= iop_end) now = iop_end;
            now = Math.min(now, ivideo_len);
        }
        return String.format("%s:%s", now/60 >= 10 ? now/60 : "0"+now/60, now%60 >= 10 ? now%60 : "0"+now%60);
    }
    int time2int(String time) {
        int res = Integer.parseInt(time.substring(0, time.indexOf(":"))) * 60;
        res += Integer.parseInt(time.substring(time.indexOf(":") + 1));
        return res;
    }
}
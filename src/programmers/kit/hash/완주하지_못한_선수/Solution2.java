package programmers.kit.hash.완주하지_못한_선수;

import java.util.*;

class Solution2 {

    public String solution(String[] participant, String[] completion) {
        //배열비교
        Arrays.sort(participant);
        Arrays.sort(completion);

        int size = participant.length;

        for(int i = 0; i < size-1; i++) {
            if(!participant[i].equals(completion[i]))
                return participant[i];
        }

        return participant[size-1];
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        System.out.println(s.solution(new String[]{ "mislav", "stanko", "mislav", "ana"}, new String[]{"stanko", "ana", "mislav"}));
        System.out.println(s.solution(new String[]{ "mislav", "stanko", "mislav", "ana"}, new String[]{"mislav", "stanko", "mislav"}));
    }
}

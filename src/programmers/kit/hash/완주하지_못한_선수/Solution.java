package programmers.kit.hash.완주하지_못한_선수;

import java.util.*;

class Solution {

    public String solution(String[] participant, String[] completion) {
        StringBuilder sb = new StringBuilder();

        Map<String, Integer> map = new HashMap<>();

        for(String p : participant) {
            map.put(p, map.getOrDefault(p, 0) + 1);
        }

        for(String c : completion) {
            map.put(c, map.get(c) - 1);
            if(map.get(c) == 0)
                map.remove(c);
        }

        for(String a : map.keySet()){
            sb.append(a);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new String[]{"mislav", "stanko", "mislav", "ana"}, new String[]{"stanko", "ana", "mislav"}));
    }
}

package programmers.etc.lv2.튜플;

import java.util.*;

class Solution {
    public int[] solution(String s) {
        String inner = s.substring(2,s.length()-2);  // 2},{2,1},{2,1,3
        String[] tuples = inner.split("\\}.\\{");
        //정렬
        List<String> sortedTuple = new ArrayList<>();
        for(String tuple : tuples) {
            sortedTuple.add(tuple);
        }
        Collections.sort(sortedTuple,(a, b) -> a.length() - b.length());

        Set<String> set = new HashSet<>();
        List<String> answerList = new ArrayList<>();

        for(String t : sortedTuple) {
            String[] parts = t.split(",");

            for(String p : parts) {
                if(!set.contains(p)) {
                    set.add(p);
                    answerList.add(p);
                    break;
                }
            }
        }

        int size = answerList.size();
        int[] answer = new int[size];
        for(int i = 0; i<size; i++) {
            answer[i] = Integer.parseInt(answerList.get(i));
        }

        return answer;
    }
}

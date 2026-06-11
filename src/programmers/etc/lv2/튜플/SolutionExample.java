package programmers.etc.lv2.튜플;

import java.util.*;

class SolutionExample {
    public int[] solution(String s) {
        String inner = s.substring(2, s.length() - 2);
        String[] groups = inner.split("\\},\\{");

        Arrays.sort(groups, Comparator.comparingInt(String::length));

        Set<Integer> seen = new HashSet<>();
        List<Integer> result = new ArrayList<>();

        for (String group : groups) {
            String[] numbers = group.split(",");
            for (String numStr : numbers) {
                int num = Integer.parseInt(numStr);
                if (!seen.contains(num)) {
                    seen.add(num);
                    result.add(num);
                }
            }
        }

        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
}

package programmers.kit.heap.이중우선순위큐;

import java.util.*;

// 최소 또는 최대 중 하나만 필요하면 우선순위큐를 쓰고, 둘다 필요하면 트리셋, 트리맵 사용
class Solution {
    public int[] solution(String[] operations) {

        TreeMap<Integer, Integer> treeMap = new TreeMap<>();

        for(String op : operations) {
            String[] parts = op.split(" ");
            String str = parts[0];
            int num = Integer.parseInt(parts[1]);

            if(str.equals("I")) {
                treeMap.put(num, treeMap.getOrDefault(num, 0)+1);
            } else if(str.equals("D")){
                if (num == 1 && !treeMap.isEmpty()) {
                    int n = treeMap.lastKey();
                    treeMap.put(n, treeMap.get(n) - 1);
                    if(treeMap.get(n) == 0)
                        treeMap.remove(n);
                } else if (num == -1 && !treeMap.isEmpty()) {
                    int n = treeMap.firstKey();
                    treeMap.put(n, treeMap.get(n) - 1);
                    if(treeMap.get(n) == 0)
                        treeMap.remove(n);
                }
            }
        }


        int[] answer = new int[2];
        if(treeMap.isEmpty()) {
            return new int[]{0, 0};
        }
        answer[0] = treeMap.lastKey();
        answer[1] = treeMap.firstKey();

        return answer;
    }
}

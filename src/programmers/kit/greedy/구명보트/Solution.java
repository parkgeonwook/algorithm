package programmers.kit.greedy.구명보트;

import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int count = 0;
        Arrays.sort(people);
        int light = 0;
        int heavy = people.length - 1;

        while(light <= heavy) {
            if(people[light] + people[heavy] <= limit) {
                light++;
            }

            heavy--;
            count++;
        }

        return count;
    }
}

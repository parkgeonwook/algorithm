package programmers.kit.sort.가장_큰_수;

import java.util.*;

// *엣지 케이스*: [0, 0, 0]의 경우 "0"을 반환해야 하는데 예외처리하지 않으면 "000"을 반환함.
class Solution {
    public String solution(int[] numbers) {
        int n = numbers.length;
        String[] str = new String[n];

        for(int i = 0; i<n; i++)
            str[i] = String.valueOf(numbers[i]);

        Arrays.sort(str, (a, b) -> (b+a).compareTo(a+b));

        // *0 처리*
        if(str[0].equals("0"))
            return "0";

        StringBuilder sb = new StringBuilder();
        for(String s : str)
            sb.append(s);

        return sb.toString();
    }
}

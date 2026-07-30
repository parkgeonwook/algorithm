package programmers.kit.dp.N으로표현;

import java.util.*;

class Solution {
    public int solution(int N, int number) {

        List<Set<Integer>> setList = new ArrayList<>();
        for(int i = 0; i < 9; i++) {
            setList.add(new HashSet<>());
        }

        setList.get(1).add(N);
        if(N == number)
            return 1;

        for(int i = 2; i<=8; i++) {
            String attach = "";
            for(int j = 0; j<i; j++) {
                attach += N;
            }
            setList.get(i).add(Integer.valueOf(attach));

            for(int k = 1; k <= i/2; k++) {
                for(int numK : setList.get(k)) {
                    for(int numIK : setList.get(i-k)) {
                        int add = numK + numIK;
                        int minus1 = numK - numIK;
                        int minus2 = numIK - numK;
                        int div1 = -1;
                        int div2 = -1;
                        if(numIK != 0) {
                            div1 = numK / numIK;
                        }
                        if(numK != 0) {
                            div2 = numIK / numK;
                        }
                        int mul = numK * numIK;

                        setList.get(i).add(add);
                        setList.get(i).add(minus1);
                        setList.get(i).add(minus2);
                        setList.get(i).add(div1);
                        setList.get(i).add(div2);
                        setList.get(i).add(mul);
                    }
                }
            }

            if(setList.get(i).contains(number))
                return i;
        }

        return -1;

    }
}

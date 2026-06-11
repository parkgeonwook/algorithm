package programmers.etc.lv2.오픈채팅방;

import java.util.*;

class SolutionExample {
    public String[] solution(String[] record) {
        Map<String, String> nicknameMap = new HashMap<>();
        List<String[]> logs = new ArrayList<>();

        for (String r : record) {
            String[] parts = r.split(" ");
            String action = parts[0];
            String id = parts[1];

            if (action.equals("Enter")) {
                nicknameMap.put(id, parts[2]);
                logs.add(new String[]{id, action});
            } else if (action.equals("Leave")) {
                logs.add(new String[]{id, action});
            } else {
                nicknameMap.put(id, parts[2]);
            }
        }

        String[] answer = new String[logs.size()];
        for (int i = 0; i < logs.size(); i++) {
            String id = logs.get(i)[0];
            String action = logs.get(i)[1];
            String nickname = nicknameMap.get(id);

            if (action.equals("Enter")) {
                answer[i] = nickname + "님이 들어왔습니다.";
            } else {
                answer[i] = nickname + "님이 나갔습니다.";
            }
        }

        return answer;
    }
}

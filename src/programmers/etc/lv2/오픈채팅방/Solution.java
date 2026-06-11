package programmers.etc.lv2.오픈채팅방;

import java.util.*;

class Solution {
    public String[] solution(String[] record) {

        Map<String, Person> personMap = new HashMap<>();
        List<Log> logList = new ArrayList<>();

        for(String r : record) {
            String[] parts = r.split(" ");
            String action = parts[0];
            String id = parts[1];
            Person person = null;

            if(action.equals("Enter")) {
                String nickname = parts[2];
                if(!personMap.containsKey(id)) {
                    personMap.put(id, new Person(id, nickname));
                }

                person = personMap.get(id);

                if(!person.nickname.equals(nickname))
                    person.nickname = nickname;

                logList.add(new Log(person, action));
            } else if (action.equals("Leave")) {
                person = personMap.get(id);
                logList.add(new Log(person, action));
            } else {
                person = personMap.get(id);
                person.nickname = parts[2];
            }
        }


        int size = logList.size();
        String[] answer = new String[size];
        for(int i = 0; i<size; i++) {
            Log log = logList.get(i);
            if(log.action.equals("Enter")) {
                answer[i] = log.person.nickname + "님이 들어왔습니다.";
            } else {
                answer[i] = log.person.nickname + "님이 나갔습니다.";
            }
        }


        return answer;
    }

    class Person {
        String id;
        String nickname;

        public Person(String id, String nickname) {
            this.id = id;
            this.nickname = nickname;
        }
    }

    class Log {
        Person person;
        String action;

        public Log(Person person, String action) {
            this.person = person;
            this.action = action;
        }
    }
}

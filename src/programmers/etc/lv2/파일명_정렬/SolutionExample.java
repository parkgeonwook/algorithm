package programmers.etc.lv2.파일명_정렬;

import java.util.*;

class SolutionExample {

    class FileInfo {
        String original;
        String head;
        int number;
        int index;

        public FileInfo(String original, String head, int number, int index) {
            this.original = original;
            this.head = head;
            this.number = number;
            this.index = index;
        }
    }

    public String[] solution(String[] files) {
        List<FileInfo> list = new ArrayList<>();

        for (int i = 0; i < files.length; i++) {
            String file = files[i];

            int start = 0;
            while (!Character.isDigit(file.charAt(start))) {
                start++;
            }

            int end = start;
            while (end < file.length() && Character.isDigit(file.charAt(end)) && end - start < 5) {
                end++;
            }

            String head = file.substring(0, start);
            int number = Integer.parseInt(file.substring(start, end));

            list.add(new FileInfo(file, head.toLowerCase(), number, i));
        }

        list.sort((a, b) -> {
            if (!a.head.equals(b.head)) {
                return a.head.compareTo(b.head);
            }
            if (a.number != b.number) {
                return a.number - b.number;
            }
            return a.index - b.index;
        });

        String[] answer = new String[files.length];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i).original;
        }

        return answer;
    }
}

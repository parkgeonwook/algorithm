package programmers.etc.lv2.파일명_정렬;

import java.util.*;

class Solution {
    public String[] solution(String[] files) {

        List<File> fileList = new ArrayList<>();

        int seq = 0;
        for(String file : files) {
            int firstNum = -1;
            int firstNotNum = -1;
            String head = null;
            int number = -1;
            boolean findNum = false;

            int len = file.length();
            for(int i = 0; i < len; i++) {
                if(!findNum && Character.isDigit(file.charAt(i))) {
                    firstNum = i;
                    head = file.substring(0, firstNum);
                    findNum = true;
                } else if(findNum && !Character.isDigit(file.charAt(i))) {
                    firstNotNum = i;
                    number = Integer.parseInt(file.substring(firstNum, firstNotNum));
                    break;
                }

                if(firstNotNum == -1 && i == len-1) {
                    number = Integer.parseInt(file.substring(firstNum, len));
                }
            }

            fileList.add(new File(file, head.toLowerCase(), number, seq++));

        }

        Collections.sort(fileList);
        int size = fileList.size();
        String[] answer = new String[size];
        for(int i = 0; i < size; i++) {
            answer[i] = fileList.get(i).filename;
        }

        return answer;
    }

    class File implements Comparable<File> {
        String filename;
        String head;
        int num;
        int seq;

        public File(String filename, String head, int num, int seq) {
            this.filename = filename;
            this.head = head;
            this.num = num;
            this.seq = seq;
        }

        public int compareTo(File f) {
            if(this.head.equals(f.head)) {
                if(this.num == f.num) {
                    return this.seq - f.seq;
                }

                return this.num - f.num;
            }


            return this.head.compareTo(f.head);
        }
    }
}

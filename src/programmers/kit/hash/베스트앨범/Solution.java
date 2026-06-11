package programmers.kit.hash.베스트앨범;

import java.util.*;

class Solution {

    class Song {
        int id;
        int plays;

        public Song(int id, int plays) {
            this.id = id;
            this.plays = plays;
        }
    }

    public int[] solution(String[] genres, int[] plays) {

        Map<String, Integer> genreTotalMap = new HashMap<>();
        Map<String, List<Song>> genreSongsMap = new HashMap<>();

        for(int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];

            genreTotalMap.put(genre, genreTotalMap.getOrDefault(genre, 0) + play);

            genreSongsMap.putIfAbsent(genre, new ArrayList<>());
            genreSongsMap.get(genre).add(new Song(i, play));
        }

        List<String> genreList = new ArrayList<>(genreTotalMap.keySet());
        genreList.sort((a,b) -> genreTotalMap.get(b) - genreTotalMap.get(a));

        List<Integer> result = new ArrayList<>();

        for(String genre : genreList) {
            List<Song> songs = genreSongsMap.get(genre);

            songs.sort((a,b) -> {
                if(a.plays == b.plays)
                {
                    return a.id - b.id;
                }

                return b.plays - a.plays;
            });

            result.add(songs.get(0).id);

            if(songs.size() > 1)
                result.add(songs.get(1).id);
        }

        int[] answer = new int[result.size()];
        for(int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
}

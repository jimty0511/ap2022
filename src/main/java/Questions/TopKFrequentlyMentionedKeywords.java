package Questions;

import java.util.*;

public class TopKFrequentlyMentionedKeywords {
    /**
     * Lint 1883
     *
     * @param K:        an integer
     * @param keywords: a list of string
     * @param reviews:  a list of string
     * @return: return the top k keywords list
     */
    public List<String> TopkKeywords(int K, String[] keywords, String[] reviews) {
        // write your code here
        Set<String> keywordsSet = new HashSet<>();
        Map<String, WordState> map = new HashMap<>();
        List<String> ans = new ArrayList<>();

        for (String kw : keywords) {
            keywordsSet.add(kw);
        }

        for (int i = 0; i < reviews.length; i++) {
            String review = reviews[i];
            review = review.replaceAll("[\\!?,;.]", "").toLowerCase();
            review = review.replace("[", "");
            review = review.replace("]", "");
            String[] words = review.split(" ");

            for (int j = 0; j < words.length; j++) {
                String word = words[j];
                if (keywordsSet.contains(word)) {
                    WordState wordState;
                    if (map.containsKey(word)) {
                        wordState = map.get(word);
                    } else {
                        wordState = new WordState(word);
                    }
                    wordState.reviewCnt.add(i);
                    map.put(word, wordState);
                }
            }
        }

        Queue<WordState> pq = new PriorityQueue<>(new Comparator<WordState>() {
            @Override
            public int compare(WordState o1, WordState o2) {
                if (o1.reviewCnt.size() == o2.reviewCnt.size()) {
                    return o1.word.compareTo(o2.word);
                } else {
                    return Integer.compare(o2.reviewCnt.size(), o1.reviewCnt.size());
                }
            }
        });

        pq.addAll(map.values());

        if (K > pq.size()) {
            for (int i = 0; i < keywords.length && !pq.isEmpty(); i++)
                ans.add(pq.poll().word);
        } else {
            for (int i = 0; i < K; i++)
                ans.add(pq.poll().word);
        }

        return ans;
    }

    private class WordState {
        String word;
        Set<Integer> reviewCnt;

        public WordState(String s) {
            this.word = s;
            reviewCnt = new HashSet<>();
        }
    }
}

package Questions;

import java.util.*;

public class TopKFrequentWords {
    /**
     * Lint 471
     *
     * @param words: an array of string
     * @param k:     An integer
     * @return: an array of string
     */
    public String[] topKFrequentWords(String[] words, int k) {
        // write your code here
        String[] res = new String[k];
        Map<String, Integer> freq = new HashMap<>();
        for (String w : words) {
            freq.put(w, freq.getOrDefault(w, 0) + 1);
        }

        Queue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o1.getValue() == o2.getValue()) {
                    return o1.getKey().compareTo(o2.getKey());
                } else {
                    return Integer.compare(o2.getValue(), o1.getValue());
                }
            }
        });

        pq.addAll(freq.entrySet());
        int i = 0;
        while (!pq.isEmpty() && i < k) {
            res[i++] = pq.poll().getKey();
        }

        return res;
    }
}

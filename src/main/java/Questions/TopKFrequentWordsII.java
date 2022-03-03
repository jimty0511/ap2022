package Questions;

import java.util.*;

public class TopKFrequentWordsII {
    TreeSet<String> set;
    Map<String, Integer> cnt;
    int k;

    /*
     * @param k: An integer
     */
    public TopKFrequentWordsII(int k) {
        // do intialization if necessary
        this.k = k;
        cnt = new HashMap<>();
        set = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                int cntA = cnt.getOrDefault(a, 0);
                int cntB = cnt.getOrDefault(b, 0);
                if (cntA == cntB)
                    return a.compareTo(b);
                return Integer.compare(cntB, cntA);
            }
        });
    }

    /*
     * @param word: A string
     * @return: nothing
     */
    public void add(String word) {
        // write your code here
        set.remove(word);
        cnt.put(word, cnt.getOrDefault(word, 0) + 1);
        set.add(word);
        if (set.size() > k)
            set.pollLast();
    }

    /*
     * @return: the current top k frequent words.
     */
    public List<String> topk() {
        // write your code here
        return new ArrayList<>(set);
    }
}

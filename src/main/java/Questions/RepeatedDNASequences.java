package Questions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RepeatedDNASequences {
    /**
     * Lint 1335
     *
     * @param s: a string
     * @return: return List[str]
     */
    public List<String> findRepeatedDnaSequences(String s) {
        // write your code here
        Set<String> res = new HashSet<>();
        Set<String> set = new HashSet<>();
        for (int i = 0; i <= s.length() - 10; i++) {
            String sub = s.substring(i, i + 10);
            if (!set.add(sub))
                res.add(sub);
        }

        return new ArrayList<>(res);
    }
}

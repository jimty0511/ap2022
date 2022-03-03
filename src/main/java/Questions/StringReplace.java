package Questions;

import java.util.ArrayList;
import java.util.List;

public class StringReplace {
    /**
     * Lint 841
     *
     * @param a: The A array
     * @param b: The B array
     * @param s: The S string
     * @return: The answer
     */
    public String stringReplace(String[] a, String[] b, String s) {
        // Write your code here
        int n = a.length, len = s.length();
        long seed = 31L, mod = 1_000_000_000_7L;
        List<Long> aHash = new ArrayList<>(), sHash = new ArrayList<>(), baseHash = new ArrayList<>();
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < n; i++) {
            long tmp = 0L;
            for (int j = 0; j < a[i].length(); j++) {
                tmp = (tmp * seed + a[i].charAt(j)) % mod;
            }

            aHash.add(tmp);
        }

        long sTmp = 0L, baseTmp = 1L;
        sHash.add(sTmp);
        baseHash.add(baseTmp);
        for (int i = 0; i < len; i++) {
            sTmp = (sTmp * seed + s.charAt(i)) % mod;
            sHash.add(sTmp);
            baseTmp = baseTmp * seed % mod;
            baseHash.add(baseTmp);
        }

        int i = 0;
        while (i < len) {
            int max = 0, idx = -1;
            for (int j = 0; j < n; j++) {
                int aLen = a[j].length();
                if (i + aLen > len)
                    continue;

                long A = aHash.get(j) % mod;
                long B = ((sHash.get(i + aLen) - baseHash.get(aLen) * sHash.get(i) % mod) + mod) % mod;
                if (A == B && aLen > max) {
                    max = aLen;
                    idx = j;
                }
            }

            if (idx != -1) {
                sb.replace(i, i + max, b[idx]);
                i = i + max;
            } else {
                i += 1;
            }
        }

        return sb.toString();
    }
}

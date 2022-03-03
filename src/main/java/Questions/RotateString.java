package Questions;

public class RotateString {
    /**
     * Leet 796
     *
     * @param s
     * @param goal
     * @return
     */
    public boolean rotateString(String s, String goal) {
        if (s.equals(goal))
            return true;

        long mod = 1_000_000_00_7L, power = 1L;
        long sHash = 0, goalHash = 0, preHash = 1L;
        int n = s.length(), m = goal.length();
        for (int i = 0; i < n; i++) {
            sHash = (sHash * 31 + s.charAt(i)) % mod;
            goalHash = (goalHash * 31 + goal.charAt(i)) % mod;
            power = power * 31 % mod;
        }

        if (sHash == goalHash)
            return true;

        for (int i = 0; i < n - 1; i++) {
            long minus = (s.charAt(i) - 'a') * (preHash) % mod;
            long plus = (s.charAt(i) - 'a') * (power) % mod;
            sHash = (sHash + plus - minus + mod) % mod;
            preHash *= m;
            preHash %= mod;
            power *= m;
            power %= mod;
            if (sHash == (goalHash * preHash) % mod && goal.equals(s.substring(i + 1, n) + s.substring(0, i + 1)))
                return true;
        }

        return false;
    }

    public boolean two(String A, String B) {
        long mod = 1_000_000_00_7, m = 31;

        if (A.length() != B.length()) return false;
        int len = A.length();
        long hashA = 0L, hashB = 0L;
        for (int i = len - 1; i >= 0; i--) {
            hashA *= m;
            hashA %= mod;
            hashA += A.charAt(i);
            hashA %= mod;
            hashB *= m;
            hashB %= mod;
            hashB += B.charAt(i);
            hashB %= mod;
        }
        if (hashA == hashB) {
            if (A.equals(B)) return true;
        }
        long preM = 1;
        long suffixM = 1;
        for (int i = 0; i < len; i++) {
            suffixM *= m;
            suffixM %= mod;
        }

        for (int i = 0; i < len - 1; i++) {
            long minus = A.charAt(i) * (preM) % mod;
            long plus = A.charAt(i) * (suffixM) % mod;
            hashA = (hashA + plus - minus + mod) % mod;
            preM *= m;
            preM %= mod;
            suffixM *= m;
            suffixM %= mod;
            if (hashA == (hashB * preM) % mod && B.equals(A.substring(i + 1, len) + A.substring(0, i + 1))) {
                return true;
            }
        }
        return false;
    }
}

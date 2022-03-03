package Questions;

public class Fibonacci {
    /**
     * Lint 366
     *
     * @param n: an integer
     * @return: an ineger f(n)
     */
    public int fibonacci(int n) {
        // write your code here
        int[] fib = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (i <= 2) {
                fib[i] = i - 1;
            } else {
                fib[i] = fib[i - 1] + fib[i - 2];
            }
        }

        return fib[n];
    }

    public int two(int n) {
        int[] fib = new int[2];
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i <= n; i++) {
            fib[i % 2] = fib[0] + fib[1];
        }

        return fib[(n + 1) % 2];
    }
}

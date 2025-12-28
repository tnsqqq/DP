// package QuestionsFibonacci;

import java.util.*;

public class ClimbingStairs {

  // recursion - 2^n -> n = 10^5
  // public static int countWays(int n) {
  // if (n == 0)
  // return 1;
  // if (n < 0)
  // return 0;

  // return countWays(n - 1) + countWays(n - 2);

  // }

  // Memoization - O(n)
  public static int countWays(int n, int ways[]) {
    if (n == 0)
      return 1;
    if (n < 0)
      return 0;

    if (ways[n] != -1) { // already calculated
      return ways[n];
    }

    ways[n] = countWays(n - 1, ways) + countWays(n - 2, ways);
    return ways[n];

  }

  // Tabulation
  // 1. Create Table + initialize(base case)
  // 2. meaning for index
  // 3. fill (small to large)

  // ways(1) = ways(0) + ways(-1)

  public static int countWaysTabulation(int n) { // O(n)
    int dp[] = new int[n + 1]; // 0 to n
    dp[0] = 1;

    // tabulation
    for (int i = 1; i <= n; i++) {
      if (i == 1) {
        dp[i] = dp[i - 1] + 0;
      } else {
        dp[i] = dp[i - 1] + dp[i - 2];
      }
    }
    return dp[n];
  }

  public static void main(String[] args) {
    int n = 5; // n=3 -> 3 & n=4 -> 5 => 8
    int ways[] = new int[n + 1]; // 0 0 0 0
    Arrays.fill(ways, -1); // -1 -1 -1 -1
    // System.out.println(countWays(n));
    // System.out.println(countWays(n, ways));
    System.out.println(countWaysTabulation(n));
  }
}

// Count ways to reach the nth stair. The person can climb either 1 stair or 2
// stairs at a time.

// fibonacci code approach

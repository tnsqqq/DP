// package QuestionsKnapsack;

public class 01Knapsack {

  // recursion
  public static int knapsack(int val[], int wt[], int W, int n) {
    if (W == 0 || n == 0) {
      return 0;
    }

    if (wt[n - 1] <= W) { // valid
      // include
      int ans1 = val[n - 1] + knapsack(val, wt, W - wt[n - 1], n - 1);
      // exclude
      int ans2 = knapsack(val, wt, W, n - 1);
      return Math.max(ans1, ans2);
    } else { // not valid
      return knapsack(val, wt, W, n - 1);
    }
  }

  // memoization
  // -> int dp[][] = new int[n+1][W+1], n = val.length
  public static int knapsack(int val[], int wt[], int W, int n, int dp[][]) { // O(n * W)
    if (W == 0 || n == 0) {
      return 0;
    }

    if(dp[n][W] != -1){
      return dp[n][W];
    }

    if (wt[n - 1] <= W) { // valid
      // include
      int ans1 = val[n - 1] + knapsack(val, wt, W - wt[n - 1], n - 1, dp);
      // exclude
      int ans2 = knapsack(val, wt, W, n - 1, dp);
      dp[n][W] = Math.max(ans1, ans2);
      return dp[n][W];
    } else { // not valid
      dp[n][W] = knapsack(val, wt, W, n - 1, dp);
      return dp[n][W];
    }
  }

  public static void main(String args[]) {
    int val[] = { 15, 14, 10, 45, 30 };
    int wt[] = { 2, 5, 1, 3, 4 };
    int W = 7;
    int dp[][] = new int[val.length+1][W+1];
    for(int i=0; i<dp.length; i++){
      for(int j=0; j<dp[0].length; j++){
        dp[i][j] = -1;
      }
    }

    System.out.println(knapsack(val, wt, W, val.length)); // 75
    System.out.println(knapsack(val, wt, W, val.length, dp)); // 75

  }
}

// val[] = 15,14,10,45,30
// wt[] = 2,5,1,3,4
// W(total allowed weight) = 7
// ans = max Profit

// 1. choice
// 2. optimal -> best solution possible

// item(val, wt)
// include(1), exclude(0)
// wt <= W

// case1: wt <= W
// 1 or 0
// 1: W = W-wt

// if(wt <= W) valid
// -> include W-wt, i+1
// -> exclude W, i+1  
// else not valid
// -> exclude W, i+1

// base
// -> W(capacity) = 0, ans = 0
// -> index i
// i=0 to n (i=n)
// i=n to 0 (i=0), ans = 0

// if(W==0 || i==0){
// return 0; }

// Time Complexity - 2^n -> nW

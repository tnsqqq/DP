// package QuestionsKnapsack;

public class 01Knapsack {

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

  public static void main(String args[]) {
    int val[] = { 15, 14, 10, 45, 30 };
    int wt[] = { 2, 5, 1, 3, 4 };
    int W = 7;

    System.out.println(knapsack(val, wt, W, val.length)); // 75

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

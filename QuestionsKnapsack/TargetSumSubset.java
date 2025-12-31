public class TargetSumSubset {
  // Tabulation
  // public static boolean targetSum(int arr[], int sum) {
  // int n = arr.length;
  // boolean dp[][] = new boolean[n + 1][sum + 1];
  // // i=items & j=target sum
  // for (int i = 0; i < n + 1; i++) {
  // dp[i][0] = true;
  // }

  // for (int i = 1; i < n + 1; i++) {
  // for (int j = 1; j < sum + 1; j++) {
  // int v = arr[i - 1];
  // // include
  // if (v <= j && dp[i - 1][j - v] == true) {
  // dp[i][j] = true;
  // }
  // // exclude
  // else if (dp[i - 1][j] == true) {
  // dp[i][j] = true;
  // }
  // }
  // }
  // print(dp);
  // return dp[n][sum];
  // }

  // recursion
  // public static boolean targetSum(int[] arr, int n, int sum) { // 2^n
  // // base case
  // if (sum == 0)
  // return true;
  // if (n == 0)
  // return false;

  // // include
  // if (arr[n - 1] <= sum) {
  // return targetSum(arr, n - 1, sum - arr[n - 1]) || targetSum(arr, n - 1, sum);
  // }
  // // exclude
  // else {
  // return targetSum(arr, n - 1, sum);
  // }
  // }

  // Memoization
  public static boolean targetSum(int[] arr, int n, int sum, Boolean[][] dp) { // O(n*sum)
    if (sum == 0)
      return true;
    if (n == 0)
      return false;

    if (dp[n][sum] != null)
      return dp[n][sum];

    if (arr[n - 1] <= sum) {
      dp[n][sum] = targetSum(arr, n - 1, sum - arr[n - 1], dp) || targetSum(arr, n
          - 1, sum, dp);
    } else {
      dp[n][sum] = targetSum(arr, n - 1, sum, dp);
    }
    return dp[n][sum];
  }

  // public static void print(boolean dp[][]) {
  // for (int i = 0; i < dp.length; i++) {
  // for (int j = 0; j < dp[0].length; j++) {
  // System.out.print(dp[i][j] + " ");
  // }
  // System.out.println();
  // }
  // System.out.println();
  // }

  public static void main(String[] args) {
    int arr[] = { 4, 2, 7, 1, 3 };
    int sum = 10;
    // System.out.println(targetSum(arr, sum));
    Boolean[][] dp = new Boolean[arr.length + 1][sum + 1];
    System.out.println(targetSum(arr, arr.length, sum, dp));
  }

}

// numbers[] = 4,2,7,1,3
// Target Sum = 10

// variation of 0-1 Knapsack
// subset of numbers -> sum = target
// total subsets -> 2^n

// 1. choice of elements
// subsets ->
// 1. {7,3} -> sum = 10,
// 2. {7,2,1} -> sum = 10,
// 3. {4,2,1} -> sum = 10

// 2. limit on max allowed capacity
// 3. val = W

// Tabulation
// 1. table
// 2. meaning + initialize
// 3. bottom up manner (small to large)

// dp[n+1][sum+1] 2D array

// ans -> n items -> subset sum = target ? T/F
// dp(i,j), i items -> subset sum = j ? T/F

// i=3, j=5 3items subset=5 ? (j)(target)

// j=0 -> True (initialization set)

// for(int i=1 to n+1)
// for(int j=1 to sum+1)

// ith
// -> valid arr[i-1] <= sum
// -> invalid -> exclude

// 1. include
// dp[i-1][j-v] = T
// dp[i][j] = T

// 2. exclude
// dp[i-1][j] = T
// dp[i][j] = T

// V > targetSum -> exclude

// include (v = arr[i-1])
// if(v<=j && dp[i-1][j-v] = T)
// dp[i][j] = T

// exclude
// if(dp[i-1][j] = T)
// dp[i][j] = T

// final ans
// dp[n][sum]

// time complexity - O(n*Sum)

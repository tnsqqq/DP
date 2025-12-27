// DP is optimized recursion

// How to identify DP?
// a. Optimal Problem
// b. some choice is given (multiple branches in recursion tree)

// DP Definition
// DP is a technique in computer programming that helps to efficiently solve a
// class of problems that have overlapping subproblems and optimal susbtructure
// property.

// 1. choice, 2. optimal

// Ways of DP

// 1. Memoization (Top Down)
// fibonacci
// 1. normal recusion
// 2. subproblem -> storage -> reuse

// when stack is full our memo approach fails

// 2. Tabulation (Bottom Up) -> Iteration
// make a table/set/storage
// more efficient
// in stack overflow condition (recursion call stores here)
// a point where this stack fulls we use tabulation otherwise memo

// 1. initialization
// 2. meaning of index
// ex. dp[i] ith fib
// dp[o] oth fib
// dp[1] 1st fib
// dp[n] nth fib
// 3. filling (small to large)

// dp[n+1]
// for(int i=2; i<=n; i++){
// dp[i] = dp[i-1] + dp[i-2]
// }
// ans = dp[n]
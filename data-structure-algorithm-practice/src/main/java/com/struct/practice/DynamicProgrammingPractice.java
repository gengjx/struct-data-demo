package com.struct.practice;

/**
 * 动态规划练习
 * 练习内容：
 * 1. 斐波那契数列
 * 2. 爬楼梯问题
 * 3. 最长公共子序列
 * 4. 最长递增子序列
 * 5. 0-1背包问题
 * 6. 完全背包问题
 * 7. 编辑距离
 * 8. 最大子数组和
 */
public class DynamicProgrammingPractice {

    /**
     * 练习1：斐波那契数列（递归）
     * 时间复杂度：O(2^n)
     */
    public static int fibonacciRecursive(int n) {
        // TODO: 实现递归版本的斐波那契
        // 如果n <= 1，返回n
        // 否则返回fibonacci(n-1) + fibonacci(n-2)
        return 0;
    }

    /**
     * 练习2：斐波那契数列（动态规划）
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    public static int fibonacciDP(int n) {
        // TODO: 使用动态规划实现
        // 1. 创建dp数组，dp[i]表示第i个斐波那契数
        // 2. 初始化dp[0] = 0, dp[1] = 1
        // 3. 从2开始，dp[i] = dp[i-1] + dp[i-2]
        // 4. 返回dp[n]
        return 0;
    }

    /**
     * 练习3：斐波那契数列（空间优化）
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public static int fibonacciOptimized(int n) {
        // TODO: 空间优化版本
        // 只需要保存前两个值，不需要整个数组
        return 0;
    }

    /**
     * 练习4：爬楼梯问题
     * 问题：每次可以爬1或2个台阶，爬到n阶有多少种方法
     */
    public static int climbStairs(int n) {
        // TODO: 实现爬楼梯问题
        // 类似斐波那契数列
        // dp[i] = dp[i-1] + dp[i-2]
        return 0;
    }

    /**
     * 练习5：最长公共子序列（LCS）
     * 问题：求两个字符串的最长公共子序列长度
     */
    public static int longestCommonSubsequence(String text1, String text2) {
        // TODO: 实现最长公共子序列
        // 1. 创建dp数组，dp[i][j]表示text1[0..i]和text2[0..j]的LCS长度
        // 2. 如果text1[i] == text2[j]，dp[i][j] = dp[i-1][j-1] + 1
        // 3. 否则，dp[i][j] = max(dp[i-1][j], dp[i][j-1])
        // 4. 返回dp[m][n]
        return 0;
    }

    /**
     * 练习6：最长递增子序列（LIS）
     * 问题：求数组的最长递增子序列长度
     */
    public static int lengthOfLIS(int[] nums) {
        // TODO: 实现最长递增子序列
        // 方法1：O(n²)
        // dp[i]表示以nums[i]结尾的最长递增子序列长度
        // dp[i] = max(dp[j]) + 1，其中j < i且nums[j] < nums[i]
        
        // 方法2：O(nlogn) - 使用二分查找优化
        return 0;
    }

    /**
     * 练习7：0-1背包问题
     * 问题：有n个物品，每个物品有重量和价值，背包容量为W，求最大价值
     */
    public static int knapsack01(int[] weights, int[] values, int capacity) {
        // TODO: 实现0-1背包问题
        // dp[i][w]表示前i个物品在容量w下的最大价值
        // dp[i][w] = max(dp[i-1][w], dp[i-1][w-weights[i]] + values[i])
        return 0;
    }

    /**
     * 练习8：完全背包问题
     * 问题：每个物品可以无限使用
     */
    public static int knapsackComplete(int[] weights, int[] values, int capacity) {
        // TODO: 实现完全背包问题
        // dp[i][w] = max(dp[i-1][w], dp[i][w-weights[i]] + values[i])
        // 注意：第二个状态是dp[i]而不是dp[i-1]
        return 0;
    }

    /**
     * 练习9：编辑距离
     * 问题：将word1转换为word2需要的最少操作次数（插入、删除、替换）
     */
    public static int minDistance(String word1, String word2) {
        // TODO: 实现编辑距离
        // dp[i][j]表示word1[0..i]转换为word2[0..j]的最小操作数
        // 如果word1[i] == word2[j]，dp[i][j] = dp[i-1][j-1]
        // 否则，dp[i][j] = min(
        //     dp[i-1][j] + 1,      // 删除
        //     dp[i][j-1] + 1,      // 插入
        //     dp[i-1][j-1] + 1     // 替换
        // )
        return 0;
    }

    /**
     * 练习10：最大子数组和
     * 问题：求数组中和最大的连续子数组
     */
    public static int maxSubArray(int[] nums) {
        // TODO: 实现最大子数组和（Kadane算法）
        // dp[i]表示以nums[i]结尾的最大子数组和
        // dp[i] = max(nums[i], dp[i-1] + nums[i])
        // 可以优化为O(1)空间复杂度
        return 0;
    }

    /**
     * 练习11：硬币找零
     * 问题：用最少的硬币凑成目标金额
     */
    public static int coinChange(int[] coins, int amount) {
        // TODO: 实现硬币找零
        // dp[i]表示凑成金额i需要的最少硬币数
        // dp[i] = min(dp[i - coin]) + 1，其中coin是可用硬币
        return 0;
    }

    // 测试方法
    public static void main(String[] args) {
        System.out.println("=== 动态规划练习 ===");
        
        // 测试斐波那契
        System.out.println("斐波那契(10): " + fibonacciDP(10));
        
        // 测试爬楼梯
        System.out.println("爬10阶楼梯的方法数: " + climbStairs(10));
        
        // 测试最长公共子序列
        String text1 = "abcde";
        String text2 = "ace";
        System.out.println("最长公共子序列长度: " + longestCommonSubsequence(text1, text2));
        
        // 测试最大子数组和
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("最大子数组和: " + maxSubArray(nums));
    }
}


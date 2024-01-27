public class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int x : nums){
            sum += x;
        }
        if(sum % 2 == 1){
            return false;
        }
        int target = sum / 2;

        int n = nums.length;

        boolean[][] dp = new boolean[n + 1][target + 1];
        dp[0][0] = true;

        for(int i = 1; i < n + 1; i++){
            dp[i][0] = true;
            for(int j = 1; j < target + 1; j++){
                dp[i][j] = dp[i - 1][j] || (j - nums[i - 1] >= 0 && dp[i - 1][j - nums[i - 1]]);
                if(j == target && dp[i][j]){
                    return true;
                }
            }
        }
        //for(int i = 0; i < n + 1; i++){
        //  System.out.println(Arrays.toString(dp[i]));
        //}

        return false;
    }
}

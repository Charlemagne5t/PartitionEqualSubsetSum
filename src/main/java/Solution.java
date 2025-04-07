class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int x: nums){
            sum+= x;
        }
        if(sum % 2 != 0){
            return false;
        }
        int target = sum / 2;
        for(int x : nums){
            if(x > target){
                return false;
            }
            if(x == target) {
                return true;
            }
        }
        boolean[][] dp = new boolean[n][target + 1];
        for(int i = 0; i < n; i++){
            dp[i][0] = true;
        }
        dp[0][nums[0]] = true;
        for(int i = 1; i < n; i++){
            for(int j = 1; j <= target; j++){
                if(dp[i - 1][j]){
                    dp[i][j] = true;
                }else if(j - nums[i] >= 0){
                    dp[i][j] = dp[i - 1][j - nums[i]];
                }

                if(dp[i][target]){
                    return true;
                }
            }

        }

        return false;
    }
}
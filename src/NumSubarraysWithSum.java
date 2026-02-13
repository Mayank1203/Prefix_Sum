
public class NumSubarraysWithSum {
    public static void main(String[] args){

        int[] nums = {0,0,0,0,0};
        int goal = 0 ;
        System.out.println(numSubarraysWithSum(nums, goal));
    }

    public static int cntSubarrayWithLessThanEqual(int[] nums, int goal) {
        if(goal < 0) return 0;

        int n = nums.length;
        int count = 0, l = 0, r = 0, sum = 0;

        while(r < n) {
            sum += nums[r];

            while(sum > goal) {
                sum = sum - nums[l];
                l++;
            }

            count += (r - l + 1);
            r++;
        }

        return count;
    }

    public static int numSubarraysWithSum(int[] nums, int goal) {
        int cnt1 = cntSubarrayWithLessThanEqual(nums, goal);
        int cnt2 = cntSubarrayWithLessThanEqual(nums, goal-1);

        return cnt1 - cnt2;
    }
}
// Question Link -> https://leetcode.com/problems/binary-subarrays-with-sum/

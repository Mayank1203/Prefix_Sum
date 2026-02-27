import java.util.HashMap;
import java.util.Map;

public class SubArraysDivByK {

    public static void main(String[] args) {
        int[] nums = {1,1,1};
        int k = 2;
        System.out.println(subarraysDivByK(nums, k));

    }
    public static int subarraysDivByK(int[] nums, int k) {
        // int n = nums.length ;

        // for(int i =1 ; i<n ; i++){
        //     nums[i] += nums[i-1] ;
        // }

        // int result = 0;

        // for(int i = 0 ; i<n ; i++){
        //     for(int j = i; j<n; j++){
        //         int sum = (i==0) ? nums[j] : nums[j]-nums[i-1] ;

        //         if(sum % k == 0){
        //             result++ ;
        //         }
        //     }
        // }

        // return result;

        int n = nums.length;

        Map<Integer, Integer> mp = new HashMap<>();
        int sum = 0;

        // Initialize with remainder 0
        mp.put(0, 1);

        int result = 0;

        for (int i = 0; i < n; i++) {
            sum += nums[i];

            int rem = sum % k;

            if (rem < 0) {
                rem += k;  // handle negative remainders
            }

            if (mp.containsKey(rem)) {
                result += mp.get(rem);
            }

            mp.put(rem, mp.getOrDefault(rem, 0) + 1);
        }

        return result;
    }
}
// Question Link -> https://leetcode.com/problems/subarray-sums-divisible-by-k/
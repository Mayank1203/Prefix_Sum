import java.util.HashMap;

public class SubArrSum {
    public static void main(String[] args) {
      int[] nums = {1,1,1};
      int k = 2 ;

      System.out.println(subArraySum(nums , k));
    }

    public static int subArraySum(int[] nums , int k){
        // BRUTE fORCE : O(N^2)
        // int ans = 0 ;
        // int n = nums.length ;
        // for(int i = 0 ; i<n ; i++){
        //     int sum = 0 ;
        //     for(int j = i ; j<n; j++){
        //         sum += nums[j];
        //         if(sum == k) ans++;
        //     }
        // }

        // return ans ;

        // OPTIMIZED : O(N)

        int n = nums.length ;
        int sum = 0 ;
        int result = 0 ;
        HashMap<Integer , Integer> map = new HashMap<>() ;
        map.put(0,1);

        for(int i = 0 ; i<n ; i++){
            sum += nums[i];

            if(map.containsKey(sum-k)){
                result += map.get(sum-k);
            }

            map.put(sum , map.getOrDefault(sum , 0)+1);
        }

        return result ;
    }
}

// Question Link -> https://leetcode.com/problems/subarray-sum-equals-k/
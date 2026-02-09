import java.util.Arrays;

public class ProductExceptSelf {
    public static void main(String[] args) {
        int[] nums = {-1,1,0,-3,3};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length ;
        int[] ans = new int[n];
        int product = 1 ;
        int zeroCount = 0 ;

        for(int i : nums){
            if(i==0){
                zeroCount++;
            }else{
                product *= i ;
            }
        }

        for(int i = 0 ; i<n ; i++){
            if(zeroCount>1){
                ans[i] = 0 ;
            }
            else if(zeroCount == 1){
                ans[i] = (nums[i]==0) ? product : 0 ;
            }else{
                ans[i] = product/nums[i];
            }
        }

        return ans ;
    }
}

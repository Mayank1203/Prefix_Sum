import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaxNonOverlapping {
    public static void main(String args[]) {
        int[] arr = {-1,3,5,1,4,2,-9} ;
        int target = 6 ;

        System.out.println(maxNonOverlapping(arr,target));
    }

    public static int maxNonOverlapping(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);

        int res = 0;

        int sum = 0;

        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            if (map.containsKey(sum - target)) {
                res = Math.max(res, map.get(sum - target) + 1);
            }
            map.put(sum, res);
        }

        return res;
    }
}

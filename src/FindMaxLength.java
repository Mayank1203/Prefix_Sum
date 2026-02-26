import java.util.HashMap;

public class FindMaxLength {

    public static void main(String[] args) {
        int[] arr = {0,1,1,1,1,1,0,0,0} ;
        System.out.println(find_maxLength(arr));
    }
    public static int find_maxLength(int[] nums) {
        // int n = nums.length ;
        // int[] sum = new int[n];
        // int value = 0 ;
        // for (int i = 0; i < n; i++) {
        //     if (nums[i] == 1) {
        //         value += 1;
        //     } else {
        //         value -= 1;
        //     }
        //     sum[i] = value;
        // }

        // int length = 0 ;

        //  for (int i = 0; i < n; i++) {
        //     for (int j = i; j < n; j++) {
        //         if (i == 0 && sum[j] == 0) {
        //             length = Math.max(length, j - i + 1);
        //         } else if (i > 0 && sum[j] == sum[i - 1]) {
        //             length = Math.max(length, j - i + 1);
        //         }
        //     }
        // }

        // return length;

        // this ABOVE APPROACH GIVES RUN TIME EXCEED

        HashMap<Integer , Integer> map = new HashMap<>();
        map.put(0,-1);
        int count = 0 ;
        int length = 0 ;
        for(int i = 0 ; i<nums.length; i++){
            if(nums[i]==1){
                count++;
            }else{
                count--;
            }


            if(map.containsKey(count)){
                length = Math.max(length , i-map.get(count));
            }else{
                map.put(count , i);
            }
        }

        return length ;
    }
}
// Question Link -> https://leetcode.com/problems/contiguous-array/
import java.util.Arrays;

public class ThreeSumClosest {
    public static void main(String[] args) {
        System.out.println("Anil");
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int al = nums.length;
        int diff = Integer.MAX_VALUE;
        for(int i = 0; i < al-2; i ++){
            int li = i+1;
            int ri = al-1;
            do{
                int complement = nums[i]+nums[li]+nums[ri];
                //if(complement < target && )
            }while(li < ri & diff != 0);
        }
        return 0;
    }
}

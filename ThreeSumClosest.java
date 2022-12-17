import java.util.Arrays;

public class ThreeSumClosest {
    public static void main(String[] args) {
        int[] nums = new int[]{0,0,0};
        ThreeSumClosest tc = new ThreeSumClosest();
        int r = tc.threeSumClosest(nums,1);
        System.out.println(r);
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int al = nums.length;
        int diff = Integer.MAX_VALUE;
        for(int i = 0; i < al-2 && diff != 0; i ++){
            int li = i+1;
            int ri = al-1;
            do{
                int complement = nums[i]+nums[li]+nums[ri];
                if(complement == target){
                    diff = 0;
                    break;
                }else if(complement < target){
                    li++;
                }else{
                    ri--;
                }
                if(Math.abs(target - complement) < Math.abs(diff)){
                    diff = target - complement;
                }
            }while(li < ri & diff != 0);
        }
        return target-diff;
    }
}

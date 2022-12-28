import java.util.Arrays;

public class ProductofArrayExceptSelf {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4};
        ProductofArrayExceptSelf p = new ProductofArrayExceptSelf();
        System.out.println(Arrays.toString(p.productExceptSelf(nums)));
    }
    public int[] productExceptSelf(int[] nums) {
        int[] r = new int[nums.length];
        int temp = 1;
        r[0] = 1;
        for(int i = 1; i < nums.length; i++){
            temp = nums[i-1] * temp;
            r[i] = temp;
        }
        temp = 1;
        for(int i = nums.length-2; i >= 0; i--){
            temp = nums[i+1] * temp;
            r[i] = r[i] * temp;
        }
        return r;
    }
}

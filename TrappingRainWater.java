public class TrappingRainWater {
    public static void main(String[] args) {
        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        TrappingRainWater t = new TrappingRainWater();
        int water = t.trap(height);
        System.out.println(water);
    }

    public int trap(int[] height) {
        int[] leftMaxArr = new int[height.length];
        int[] rightMaxArr = new int[height.length];
        int leftMax = 0;
        int rightMax = 0;
        int water = 0;
        for(int i = 0; i < height.length; i++){
            leftMax = Math.max(leftMax,height[i]);
            leftMaxArr[i] = leftMax;
        }

        for(int i = height.length-1; i >=0; i--){
            rightMax = Math.max(rightMax,height[i]);
            rightMaxArr[i] = rightMax;
        }

        for(int i = 0; i < height.length; i++)
            water += Math.min(leftMaxArr[i],rightMaxArr[i])-height[i];
        return water;
    }
}

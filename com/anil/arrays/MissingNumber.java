package com.anil.arrays;

public class MissingNumber {
    public static void main(String[] args) {
        int[] nums = new int[]{9,6,4,2,3,5,7,0,1};
        MissingNumber m = new MissingNumber();
        int mn = m.missingNumber(nums);
        System.out.println(mn);
        mn = m.missingNumberByXor(nums);
        System.out.println(mn);
    }
    //Formula (n*(n+1))/2
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sn = (n * (n + 1))/2;
        int as = 0;
        for (int i = 0; i < nums.length; i++)
            as += nums[i];
        return (sn - as);
    }
    //Bitwise XOR
    public int missingNumberByXor(int[] nums){
        int m = nums.length;
        for(int i = 0; i < nums.length; i++)
            m ^= i^nums[i];
        return m;
    }
}

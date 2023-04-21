package com.anil.sortingandsearching;

public class MedianOfTwoSortedArray {

    public static void main(String[] args) {
        MedianOfTwoSortedArray m = new MedianOfTwoSortedArray();
        double median = m.findMedianSortedArrays(new int[]{1,3},new int[]{2,4});
        System.out.println(median);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double median = 0.0;
        int[] merged = new int[nums1.length+nums2.length];

        for(int i = 0, i1 = 0, i2 = 0; i < merged.length && (i1 < nums1.length || i2 < nums2.length); i++){
            if(i1 < nums1.length && (i2 == nums2.length || nums1[i1] <= nums2[i2])){
                merged[i] = nums1[i1];
                i1++;
            }else{
                merged[i] = nums2[i2];
                i2++;
            }
        }
        if(merged.length%2 == 0 && merged.length > 0){
            median = Double.valueOf(merged[merged.length/2] + merged[(merged.length/2)-1])/2 ;
        }else{
            median = Double.valueOf(merged[merged.length/2]);
        }
        return median;
    }
}

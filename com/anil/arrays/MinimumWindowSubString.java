package com.anil.arrays;

import java.util.HashMap;

public class MinimumWindowSubString {
    public String minWindow(String s, String t) {
        if(s.length() == 0 || t.length() == 0 ){
            return "";
        }
        var distT = new HashMap<Character,Integer>();
        var msDistT = new HashMap<Character, Integer>();
        for(int i = 0; i < t.length(); i++){
            Integer count = distT.getOrDefault(t.charAt(i), 0);
            distT.put(t.charAt(i),count+1);
        }
        int required = distT.size();
        int[] ans = {-1,0,0};
        int l = 0, r = 0, found = 0;
        while(r < s.length()){
            char c = s.charAt(r);
            Integer count = msDistT.getOrDefault(c, 0);
            msDistT.put(c,count+1);

            if(distT.containsKey(c) && distT.get(c).intValue() == msDistT.get(c).intValue()){
                found++;
            }

            while(l <= r && found == required){
                if(ans[0] == -1 || ans[0] > r-l+1){
                    ans[0] = r-l+1;
                    ans[1] = l;
                    ans[2] = r;
                }

                char lc = s.charAt(l);
                int mcount = msDistT.get(lc).intValue();
                msDistT.put(lc,mcount-1);
                if(distT.containsKey(lc) && msDistT.get(lc).intValue() < distT.get(lc).intValue()){
                    found--;
                }
                l++;
            }
            r++;
        }

        return ans[0] == -1? "" : s.substring(ans[1],ans[2]+1);
    }

    public static void main(String[] args) {
        MinimumWindowSubString m = new MinimumWindowSubString();
        String s = "a", t = "aa";
        String s1 = m.minWindow(s, t);
        System.out.println(s1);
    }
}

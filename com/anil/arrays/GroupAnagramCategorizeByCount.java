package com.anil.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GroupAnagramCategorizeByCount {
    public static void main(String[] args) {
        String[] strs = new String[]{"eat","tea","tan","ate","nat","bat"};
        var ga = new GroupAnagramCategorizeByCount();
        //ga.groupAnagrams(strs);
        System.out.println(ga.groupAnagrams(strs));
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        for (var str : strs) {
            int[] count = new int[26];
            for(char c : str.toCharArray())
                count[c-'a']++;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                sb.append("#");
                sb.append(count[i]);
            }
            String key = sb.toString();
            map.putIfAbsent(key,new ArrayList<>());
            map.get(key).add(str);
        }
        return map.values().stream().toList();
    }
}

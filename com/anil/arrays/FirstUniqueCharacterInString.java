package com.anil.arrays;

import java.util.*;

public class FirstUniqueCharacterInString {
    public static void main(String[] args) {
        var s = "aabb";
        var f = new FirstUniqueCharacterInString();
        int i = f.firstUniqChar(s);
        System.out.println(i);
    }

    public int firstUniqChar(String s){
        int r = -1;
        Map<Character,Integer> charMap = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            int count = charMap.getOrDefault(c,0);
            charMap.put(c,count+1);
        }
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(charMap.get(c) == 1){
                return i;
            }
        }
        return r;
    }
    public int firstUniqCharMine(String s) {
        int r = -1;
        Set<Character> charSet = new HashSet<>();
        Map<Character,Integer> uniqueMap = new LinkedHashMap<>();
        for(int i = s.length()-1; i >= 0; i--){
            char c = s.charAt(i);
            if(!charSet.contains(c)){
                uniqueMap.put(c,i);
            }else{
                uniqueMap.remove(c);
            }
            charSet.add(c);
        }
        if(uniqueMap.size() > 0) {
            Set<Character> characters = uniqueMap.keySet();
            Character[] chArr = new Character[characters.toArray().length];
            characters.toArray(chArr);
            r = uniqueMap.get(chArr[chArr.length-1]);
        }
        return r;
    }
}

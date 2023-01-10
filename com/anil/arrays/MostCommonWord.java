package com.anil.arrays;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MostCommonWord {
    List<Character> symbols = "!?',;.".chars().mapToObj(c -> (char) c).collect(Collectors.toList());
    public static void main(String[] args) {
        /*
        "Bob. hIt, baLl"
["bob", "hit"]
         */
        var paragraph = "Bob. hIt, baLl";//"Bob hit a ball, the hit BALL flew far after it was hit.";
        var banned = new String[]{"bob", "hit"};//new String[]{"hit"};
        MostCommonWord mcw = new MostCommonWord();
        String result = mcw.mostCommonWord(paragraph, banned);
        System.out.println(result);
    }

    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedSet = new HashSet<>();
        bannedSet.addAll(Arrays.asList(banned));

        String normalizedStr = paragraph.replaceAll("[^a-zA-Z0-9 ]"," ").toLowerCase();

        String[] words = normalizedStr.split("\\s+");

        Map<String, Long> wordCount = Arrays.asList(words).stream()
                .filter(word -> !bannedSet.contains(word))
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

        return Collections.max(wordCount.entrySet(), Map.Entry.comparingByValue()).getKey();

    }
    public String mostCommonWord01(String paragraph, String[] banned) {
        char[] pChars = paragraph.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int w = 0; w < pChars.length; w++) {
            if (symbols.contains(pChars[w])) {
                pChars[w] = ' ';
            }
            sb.append(pChars[w]);
        }
        paragraph = sb.toString().toLowerCase();
        var bannedList = Arrays.asList(banned).stream().map(s -> s.toLowerCase()).collect(Collectors.toList());
        bannedList.add("");
        String result = "";
        int mrCount = 0;
        String[] pArray = paragraph.split(" ");
        Map<String,Integer> wordMap = new HashMap<>();
        for(int i = 0; i < pArray.length; i++){
            var word = pArray[i];
            if(!bannedList.contains(word)){
                Integer count = wordMap.getOrDefault(word, 0);
                count = count+1;
                wordMap.put(word,count+1);
                if(count > mrCount){
                    mrCount = count;
                    result = word;
                }
            }
        }
        return result;
    }
}

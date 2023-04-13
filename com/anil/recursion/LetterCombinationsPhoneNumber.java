package com.anil.recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LetterCombinationsPhoneNumber {
    Map<Character,char[]> digitsMap = Map.of(
            '2',new char[]{'a','b','c'},
            '3',new char[]{'d','e','f'},
            '4',new char[]{'g','h','i'},
            '5',new char[]{'j','k','l'},
            '6',new char[]{'m','n','o'},
            '7',new char[]{'p','q','r','s'},
            '8',new char[]{'t','u','v'},
            '9',new char[]{'w','x','y','z'}
    );
    List<String> comninations = new ArrayList<>();

    public static void main(String[] args) {
        LetterCombinationsPhoneNumber l = new LetterCombinationsPhoneNumber();
        List<String> comninations = l.letterCombinations("24");
        System.out.println(comninations);
    }

    public List<String> letterCombinations(String digits) {
        if(digits.length() > 0){
            backTrack(0,digits,new StringBuilder());
        }
        return comninations;
    }

    private void backTrack(int index, String digits, StringBuilder path){
        if(path.length() == digits.length()){
            comninations.add(path.toString());
            return;
        }
        char[] possibleLetters = digitsMap.get(digits.charAt(index));
        for(char letter: possibleLetters){
            path.append(letter);
            backTrack(index+1,digits,path);
            path.deleteCharAt(path.length()-1);
        }
    }

    private List<String> combination(String input){
        List<String> result = new ArrayList<>();
        if(input.length() == 1) {
            for (char c : digitsMap.get(input.charAt(0))){
                result.add(String.valueOf(c));
            }
            return result;
        }
        char[] chars = input.toCharArray();
        System.out.println("input : "+input);
        List<String> combinations = combination(new String(chars,1,chars.length-1));
        for (char c: digitsMap.get(chars[0])) {
            result.addAll(combinations.stream().map(s -> c+s).collect(Collectors.toList()));
        };
        return result;
    }
}

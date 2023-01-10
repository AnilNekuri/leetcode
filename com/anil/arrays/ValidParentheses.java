package com.anil.arrays;

import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    Map<Character,Character> parentheese = Map.of(')','(','}','{',']','[');
    public static void main(String[] args) {
        String s = "()[]}";
        ValidParentheses v = new ValidParentheses();
        boolean isValid = v.isValid(s);
        System.out.println(isValid);
    }
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(parentheese.containsValue(c)){
                stack.push(c);
            }else if(parentheese.containsKey(c) && !stack.isEmpty()){
                char pop = stack.pop();
                if(parentheese.get(c) != pop){
                    return false;
                }
            }else{
                return false;
            }
        }
        return stack.isEmpty();
    }

    private boolean containsChar(char[] charr, char c){
        for (int i = 0; i < charr.length; i++){
            if(c == charr[i]){
                return true;
            }
        }
        return false;
    }
}

package com.anil.reursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    static char openP = '(';
    static char closeP = ')';
    static List<String> combinations;
    public static void main(String[] args) {
        GenerateParentheses g = new GenerateParentheses();
        List<String> combs = g.generateParenthesis(3);
        System.out.println(combs);

    }

    public List<String> generateParenthesis(int n) {
        combinations = new ArrayList<>();
        backTrack(n,0,0, new StringBuilder());
        return combinations;
    }

    private void backTrack(int n, int open, int close, StringBuilder comb){
        if(n == open && n == close){
            combinations.add(comb.toString());
            return;
        }

        if(open >= close && open < n){
            comb.append(openP);
            backTrack(n,open+1,close,comb);
            comb.deleteCharAt(comb.length()-1);
        }
        if(open > close){
            comb.append(closeP);
            backTrack(n,open,close+1,comb);
            comb.deleteCharAt(comb.length()-1);
        }
    }
}

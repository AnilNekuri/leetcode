package com.anil.recursion;

import java.util.ArrayList;
import java.util.List;

public class WordSearchII {
    public static void main(String[] args) {
        //char[][] board = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        char[][] board = {{'o','a','b','n'},{'o','t','a','e'},{'a','h','k','r'},{'a','f','l','v'}};
        //String[] words = {"oath","pea","eat","rain"};
        String[] words = {"oa","oaa"};
        WordSearchII w = new WordSearchII();
        List<String> fwords = w.findWords(board,words);
        System.out.println(fwords);
    }
    static int[][] directions = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    static char[][] board;
    static int BROWS;
    static int BCOLS;

    public List<String> findWords(char[][] board, String[] words) {
        List<String> found = new ArrayList<>();
        this.board = board;
        this.BROWS = board.length;
        this.BCOLS = board[0].length;


        for(String word: words){
            if(findWord(board,word)) found.add(word);
        }

        return found;
    }
    public boolean findWord(char[][] board, String word) {
        for(int r = 0; r < board.length; r++){
            for(int c = 0; c < board[r].length; c++){
                if(backTrack(r,c,word,0)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean backTrack(int r, int c, String word,int index) {
        if (index >= word.length()){
            return true;
        }
        if (r < 0 || r >= BROWS || c < 0 || c >= BCOLS || word.charAt(index) != this.board[r][c]){
            return false;
        }
        this.board[r][c] = '#';
        boolean ret = false;
        for(int d = 0; d < directions.length; d++){
            ret = backTrack(r+directions[d][0],c+directions[d][1],word,index+1);
            if(ret) break;
        }
        this.board[r][c] = word.charAt(index);
        return ret;
    }
}

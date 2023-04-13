package com.anil.recursion;

import java.util.HashSet;
import java.util.Set;

public class WordSearch {
    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}};
        //"ABCESEEEFS"
        //char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        //char[][] board = {{'a','b'},{'c','d'}};
        WordSearch w = new WordSearch();
        w.exist(board,"ABCESEEEFS");
        System.out.println(exist);
    }
    static boolean exist = false;
    static int[][] directions = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};


    public boolean exist(char[][] board, String word) {
        exist = false;
        eleminateChars(board, word);
        char firstChar = word.charAt(0);
        for(int r = 0; r < board.length; r++){
            for(int c = 0; c < board[r].length; c++){
                if(board[r][c] == firstChar){
                    boolean[][] visited = new boolean[board.length][board[0].length];
                    StringBuilder eWord = new StringBuilder();
                    eWord.append(firstChar);
                    visited[r][c] = true;
                    findWord(0,r,c,board,visited,word,eWord);
                    if(exist) return exist;
                }
            }
        }
        return false;
    }

    private void findWord(int index, int r, int c, char[][] board, boolean[][] visited, String word, StringBuilder eWord) {
        //System.out.println(eWord);
        if(word.equals(eWord.toString())){
            exist = true;
            return;
        }
        if(!exist && index < word.length()-1){
            for(int d = 0; d < directions.length; d++){
                int dr = r+directions[d][0];
                int dc = c+directions[d][1];
                if(0 <= dr && dr < board.length &&
                        0 <= dc && dc < board[0].length &&
                        !visited[dr][dc] && board[dr][dc] != '0'){

                    if(board[dr][dc] == word.charAt(index+1)){
                        eWord.append(board[dr][dc]);
                        visited[dr][dc] = true;
                        findWord(index+1,dr,dc,board,visited,word,eWord);
                        eWord.deleteCharAt(eWord.length()-1);
                        visited[dr][dc] = false;
                    }
                }
            }
        }
    }

    private void eleminateChars(char[][] board, String word) {
        Set<Character> wordCharSet = new HashSet<>() ;
        for (char character : word.toCharArray()) {
            wordCharSet.add(character);
        }
        for(int r = 0; r < board.length; r++){
            for(int c = 0; c < board[r].length; c++){
                if(!wordCharSet.contains(board[r][c])){
                    board[r][c] = '0';
                }
            }
        }
    }

}

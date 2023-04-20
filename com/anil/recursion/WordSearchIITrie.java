package com.anil.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordSearchIITrie {

    public static void main(String[] args) {
        WordSearchIITrie w = new WordSearchIITrie();
        //char[][] board = {{'o','a','b','n'},{'o','t','a','e'},{'a','h','k','r'},{'a','f','l','v'}};
        char[][] board = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        //String[] words = {"oath","pea","eat","rain"};
        String[] words = {"oath","pea","eat","rain","oathi","oathk","oathf","oate","oathii","oathfi","oathfii"};
        List<String> result = w.findWords(board, words);
        System.out.println(result);
    }
    static char[][] board;
    static int BROWS;
    static int BCOLS;

    static List<String> result;
    static int[][] directions = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public List<String> findWords(char[][] board, String[] words){
        this.board = board;
        BROWS = board.length;
        BCOLS = board[0].length;
        TrieNode root = new TrieNode();
        result = new ArrayList<>();
        for (String word: words) {
            TrieNode node = root;
            for(char c: word.toCharArray()){
                if(node.children.containsKey(c)){
                    node = node.children.get(c);
                }else{
                    TrieNode newNode = new TrieNode();
                    node.children.put(c,newNode);
                    node = newNode;
                }
            }
            node.word = word;
//            System.out.println(word);
        }
        //readTrie(root);
        for(int r = 0; r < BROWS; r++){
            for(int c = 0; c < BCOLS; c++){
                if(root.children.containsKey(board[r][c])){
                    backTrack(r,c,root);
                }
            }
        }
        return result;
    }

    private void readTrie(TrieNode node){
        if(node.word!=null){
            System.out.println(node.word);
        }
//        System.out.println(node.children.size());
//        System.out.println(node.children);
        for (Map.Entry<Character, TrieNode> set :
                node.children.entrySet()) {

            System.out.println(set.getKey());
            readTrie(set.getValue());
        }
    }

    private void backTrack(int r, int c, TrieNode node){
        if(node.word!=null){
            result.add(node.word);
            node.word = null;
        }
        if(r < 0 || c < 0 || r >= BROWS || c >= BCOLS || !node.children.containsKey(board[r][c])){
            return;
        }
        char tmp = board[r][c];
        TrieNode child = node.children.get(board[r][c]);
        board[r][c] = '#';
        for(int i = 0; i < directions.length; i++){
            int dr = r+directions[i][0];
            int dc = c+directions[i][1];
            backTrack(dr,dc,child);
        }
        board[r][c] = tmp;
        if(child.children.size() == 0){
            node.children.remove(tmp);
        }
    }
}

class TrieNode{
    HashMap <Character,TrieNode> children = new HashMap<>();
    String word;
}

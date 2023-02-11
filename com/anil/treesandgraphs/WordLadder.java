package com.anil.treesandgraphs;

import java.util.*;

public class WordLadder {

    public static void main(String[] args) {
        WordLadder wl = new WordLadder();
        int i = wl.ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
        System.out.println(i);
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int length = 0;
        Queue<String> ladder = new LinkedList<>();
        Set<String> wordSet = new HashSet<>(wordList);
        wordSet.remove(beginWord);
        ladder.add(beginWord);
        while (!ladder.isEmpty()){
            int size = ladder.size();
            length++;
            if(ladder.contains(endWord)) return length;
            for(int i = 0; i < size; i++){
                String word = ladder.poll();
                List<String> neighbours =  findNeighbours(word,wordSet);
                ladder.addAll(neighbours);
            }
        }
        return 0;
    }
    private List<String> findNeighbours(String word,Set<String> wordSet){
        List<String> neighbours = new ArrayList<>();
        for(int i = 0; i < word.length(); i++){
            char[] wordChars = word.toCharArray();
            for(char c = 'a'; c <= 'z'; ++c){
                wordChars[i] = c;
                String nWord = new String(wordChars);
                if(wordSet.contains(nWord)){
                    neighbours.add(nWord);
                    wordSet.remove(nWord);
                }
            }
        }
        return neighbours;
    }
}

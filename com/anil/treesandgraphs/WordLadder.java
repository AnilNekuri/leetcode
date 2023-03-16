package com.anil.treesandgraphs;

import java.util.*;

public class WordLadder {

    List<List<String>> transPaths = new ArrayList<>();
    public static void main(String[] args) {
        WordLadder wl = new WordLadder();
        int i = wl.ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
        System.out.println(i);
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int length = 0;
        List<String> subTree = new ArrayList<>();
        Queue<String> ladder = new LinkedList<>();
        Set<String> wordSet = new HashSet<>(wordList);
        wordSet.remove(beginWord);
        ladder.add(beginWord);
        subTree.add(beginWord);
        while (!ladder.isEmpty()){
            int size = ladder.size();
            length++;
            if(ladder.contains(endWord)) return length;
            for(int i = 0; i < size; i++){
                String word = ladder.poll();
                subTree = new ArrayList<>(subTree);
                subTree.add(word);
                List<String> neighbours =  findNeighbours(word,endWord,subTree,wordSet);
                ladder.addAll(neighbours);
            }
        }
        return 0;
    }
    private List<String> findNeighbours(String word,String endWord,List<String> subTree,Set<String> wordSet){
        List<String> neighbours = new ArrayList<>();
        for(int i = 0; i < word.length(); i++){
            char[] wordChars = word.toCharArray();
            for(char c = 'a'; c <= 'z'; ++c){
                wordChars[i] = c;
                String nWord = new String(wordChars);
                if(wordSet.contains(nWord)){
                    neighbours.add(nWord);
                    if(!nWord.equals(endWord)){
                        wordSet.remove(nWord);
                    }else{
                        subTree.add(nWord);
                        transPaths.add(subTree);
                    }
                }
            }
        }
        return neighbours;
    }
}

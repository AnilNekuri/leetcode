package com.anil.treesandgraphs;

import java.util.*;

public class WorkLadderII {
    List<String> currPath = new ArrayList<>();
    List<List<String>> shortestPaths = new ArrayList<>();
    public static void main(String[] args) {
        WorkLadderII workLadderII = new WorkLadderII();
        List<List<String>> ladders = workLadderII.findLadders("aaaaa", "ggggg", Arrays.asList("aaaaa","caaaa","cbaaa","daaaa","dbaaa","eaaaa","ebaaa","faaaa","fbaaa","gaaaa","gbaaa","haaaa","hbaaa","iaaaa","ibaaa","jaaaa","jbaaa","kaaaa","kbaaa","laaaa","lbaaa","maaaa","mbaaa","naaaa","nbaaa","oaaaa","obaaa","paaaa","pbaaa","bbaaa","bbcaa","bbcba","bbdaa","bbdba","bbeaa","bbeba","bbfaa","bbfba","bbgaa","bbgba","bbhaa","bbhba","bbiaa","bbiba","bbjaa","bbjba","bbkaa","bbkba","bblaa","bblba","bbmaa","bbmba","bbnaa","bbnba","bboaa","bboba","bbpaa","bbpba","bbbba","abbba","acbba","dbbba","dcbba","ebbba","ecbba","fbbba","fcbba","gbbba","gcbba","hbbba","hcbba","ibbba","icbba","jbbba","jcbba","kbbba","kcbba","lbbba","lcbba","mbbba","mcbba","nbbba","ncbba","obbba","ocbba","pbbba","pcbba","ccbba","ccaba","ccaca","ccdba","ccdca","cceba","cceca","ccfba","ccfca","ccgba","ccgca","cchba","cchca","cciba","ccica","ccjba","ccjca","cckba","cckca","cclba","cclca","ccmba","ccmca","ccnba","ccnca","ccoba","ccoca","ccpba","ccpca","cccca","accca","adcca","bccca","bdcca","eccca","edcca","fccca","fdcca","gccca","gdcca","hccca","hdcca","iccca","idcca","jccca","jdcca","kccca","kdcca","lccca","ldcca","mccca","mdcca","nccca","ndcca","occca","odcca","pccca","pdcca","ddcca","ddaca","ddada","ddbca","ddbda","ddeca","ddeda","ddfca","ddfda","ddgca","ddgda","ddhca","ddhda","ddica","ddida","ddjca","ddjda","ddkca","ddkda","ddlca","ddlda","ddmca","ddmda","ddnca","ddnda","ddoca","ddoda","ddpca","ddpda","dddda","addda","aedda","bddda","bedda","cddda","cedda","fddda","fedda","gddda","gedda","hddda","hedda","iddda","iedda","jddda","jedda","kddda","kedda","lddda","ledda","mddda","medda","nddda","nedda","oddda","oedda","pddda","pedda","eedda","eeada","eeaea","eebda","eebea","eecda","eecea","eefda","eefea","eegda","eegea","eehda","eehea","eeida","eeiea","eejda","eejea","eekda","eekea","eelda","eelea","eemda","eemea","eenda","eenea","eeoda","eeoea","eepda","eepea","eeeea","ggggg","agggg","ahggg","bgggg","bhggg","cgggg","chggg","dgggg","dhggg","egggg","ehggg","fgggg","fhggg","igggg","ihggg","jgggg","jhggg","kgggg","khggg","lgggg","lhggg","mgggg","mhggg","ngggg","nhggg","ogggg","ohggg","pgggg","phggg","hhggg","hhagg","hhahg","hhbgg","hhbhg","hhcgg","hhchg","hhdgg","hhdhg","hhegg","hhehg","hhfgg","hhfhg","hhigg","hhihg","hhjgg","hhjhg","hhkgg","hhkhg","hhlgg","hhlhg","hhmgg","hhmhg","hhngg","hhnhg","hhogg","hhohg","hhpgg","hhphg","hhhhg","ahhhg","aihhg","bhhhg","bihhg","chhhg","cihhg","dhhhg","dihhg","ehhhg","eihhg","fhhhg","fihhg","ghhhg","gihhg","jhhhg","jihhg","khhhg","kihhg","lhhhg","lihhg","mhhhg","mihhg","nhhhg","nihhg","ohhhg","oihhg","phhhg","pihhg","iihhg","iiahg","iiaig","iibhg","iibig","iichg","iicig","iidhg","iidig","iiehg","iieig","iifhg","iifig","iighg","iigig","iijhg","iijig","iikhg","iikig","iilhg","iilig","iimhg","iimig","iinhg","iinig","iiohg","iioig","iiphg","iipig","iiiig","aiiig","ajiig","biiig","bjiig","ciiig","cjiig","diiig","djiig","eiiig","ejiig","fiiig","fjiig","giiig","gjiig","hiiig","hjiig","kiiig","kjiig","liiig","ljiig","miiig","mjiig","niiig","njiig","oiiig","ojiig","piiig","pjiig","jjiig","jjaig","jjajg","jjbig","jjbjg","jjcig","jjcjg","jjdig","jjdjg","jjeig","jjejg","jjfig","jjfjg","jjgig","jjgjg","jjhig","jjhjg","jjkig","jjkjg","jjlig","jjljg","jjmig","jjmjg","jjnig","jjnjg","jjoig","jjojg","jjpig","jjpjg","jjjjg","ajjjg","akjjg","bjjjg","bkjjg","cjjjg","ckjjg","djjjg","dkjjg","ejjjg","ekjjg","fjjjg","fkjjg","gjjjg","gkjjg","hjjjg","hkjjg","ijjjg","ikjjg","ljjjg","lkjjg","mjjjg","mkjjg","njjjg","nkjjg","ojjjg","okjjg","pjjjg","pkjjg","kkjjg","kkajg","kkakg","kkbjg","kkbkg","kkcjg","kkckg","kkdjg","kkdkg","kkejg","kkekg","kkfjg","kkfkg","kkgjg","kkgkg","kkhjg","kkhkg","kkijg","kkikg","kkljg","kklkg","kkmjg","kkmkg","kknjg","kknkg","kkojg","kkokg","kkpjg","kkpkg","kkkkg","ggggx","gggxx","ggxxx","gxxxx","xxxxx","xxxxy","xxxyy","xxyyy","xyyyy","yyyyy","yyyyw","yyyww","yywww","ywwww","wwwww","wwvww","wvvww","vvvww","vvvwz","avvwz","aavwz","aaawz","aaaaz"));
        System.out.println(ladders);
    }

    public Map<String,List<String>> getAdjEdges(){
        return adjEdges;
    }
    Map<String,List<String>> adjEdges = new HashMap<>();

    private void bfs(String beginWord,Set<String> wordSet){
        Queue<String> queue = new LinkedList<>();
        Set<String> path = new HashSet<>();
        queue.add(beginWord);
        if(wordSet.contains(beginWord)){
            wordSet.remove(beginWord);
        }

        while(!queue.isEmpty()){
            List<String> visited = new ArrayList<>();
            int size = queue.size();
            for(int i = 0; i < size; i++){
                String word = queue.poll();
                List<String> neighbours = findNeighbours(word,wordSet);
                for (String nbr: neighbours) {
                    visited.add(nbr);
                    List<String> edges = adjEdges.getOrDefault(nbr, new ArrayList<>());
                    edges.add(word);
                    adjEdges.put(nbr, edges);

                    if (!path.contains(nbr)) {
                        path.add(nbr);
                        queue.add(nbr);
                    }
                }
            }
            wordSet.removeAll(visited);
        }
    }

    private List<String> findNeighbours(String word, Set<String> wordSet){
        List<String> neighbours = new ArrayList<>();
        for(int i = 0; i < word.length(); i++){
            char[] wordChars = word.toCharArray();
            char tempC = wordChars[i];
            for(char c = 'a'; c <= 'z'; c++){
                wordChars[i] = c;
                String newWord = String.copyValueOf(wordChars);
                if(wordSet.contains(newWord) && !newWord.equals(word)){
                    neighbours.add(newWord);
                }
            }
            wordChars[i] = tempC;
        }
        return neighbours;
    }

    private void backTrack(String source, String destination){
        if(source.equals(destination)){
            List<String> tempPath = new ArrayList<>(currPath);
            Collections.reverse(tempPath);
            shortestPaths.add(tempPath);
        }

        if(!adjEdges.containsKey(source)){
            return;
        }

        for(int i = 0; i < adjEdges.get(source).size(); i++){
            currPath.add(adjEdges.get(source).get(i));
            backTrack(adjEdges.get(source).get(i),destination);
            currPath.remove(currPath.size()-1);
        }
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        bfs(beginWord,wordSet);
        currPath.add(endWord);
        backTrack(endWord,beginWord);
        return shortestPaths;
    }
}

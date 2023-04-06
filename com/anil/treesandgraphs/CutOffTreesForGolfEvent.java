package com.anil.treesandgraphs;

import java.util.*;

public class CutOffTreesForGolfEvent {

    static int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
    public static void main(String[] args) {
        int[][] input = new int[][]{{69438,55243,0,43779,5241,93591,73380},{847,49990,53242,21837,89404,63929,48214},{90332,49751,0,3088,16374,70121,25385},{14694,4338,87873,86281,5204,84169,5024},{31711,47313,1885,28332,11646,42583,31460},{59845,94855,29286,53221,9803,41305,60749},{95077,50343,27947,92852,0,0,19731},{86158,63553,56822,90251,0,23826,17478},{60387,23279,78048,78835,5310,99720,0},{74799,48845,60658,29773,96129,90443,14391},{65448,63358,78089,93914,7931,68804,72633},{93431,90868,55280,30860,59354,62083,47669},{81064,93220,22386,22341,95485,20696,13436},{50083,0,89399,43882,0,13593,27847},{0,12256,33652,69301,73395,93440,0},{42818,87197,81249,33936,7027,5744,64710},{35843,0,99746,52442,17494,49407,63016},{86042,44524,0,0,26787,97651,28572},{54183,83466,96754,89861,84143,13413,72921},{89405,52305,39907,27366,14603,0,14104},{70909,61104,70236,30365,0,30944,98378},{20124,87188,6515,98319,78146,99325,88919},{89669,0,64218,85795,2449,48939,12869},{93539,28909,90973,77642,0,72170,98359},{88628,16422,80512,0,38651,50854,55768},{13639,2889,74835,80416,26051,78859,25721},{90182,23154,16586,0,27459,3272,84893},{2480,33654,87321,93272,93079,0,38394},{34676,72427,95024,12240,72012,0,57763},{97957,56,83817,45472,0,24087,90245},{32056,0,92049,21380,4980,38458,3490},{21509,76628,0,90430,10113,76264,45840},{97192,58807,74165,65921,45726,47265,56084},{16276,27751,37985,47944,54895,80706,2372},{28438,53073,0,67255,38416,63354,69262},{23926,75497,91347,58436,73946,39565,10841},{34372,69647,44093,62680,32424,69858,68719},{24425,4014,94871,1031,99852,88692,31503},{24475,12295,33326,37771,37883,74568,25163},{0,18411,88185,60924,29028,69789,0},{34697,75631,7636,16190,60178,39082,7052},{24876,9570,53630,98605,22331,79320,88317},{27204,89103,15221,91346,35428,94251,62745},{26636,28759,12998,58412,38113,14678,0},{80871,79706,45325,3861,12504,0,4872},{79662,15626,995,80546,64775,0,68820},{25160,82123,81706,21494,92958,33594,5243}};
        //int[][] input = new int[][]{{87831103,65854898,2779857,44204411,19079948,69410679,87618788},{21145230,46057433,91028222,21139600,71738422,94523119,68042744},{54778025,56455791,37381542,39938846,65988101,48544100,26370707},{23819845,17948839,19801915,60592386,77379668,80566086,9890856},{79375973,89519557,33435287,78827274,57470052,79006461,26468447},{39356777,268254,99534840,69855179,59998856,44225326,46783243},{16722565,20373932,59356985,98603797,25499764,31549350,7421797},{5770474,47592403,29997381,59695202,20261576,55571427,26565722}};
        //int[][] input = {{1,2,3},{0,0,0},{7,6,5}};
        List<List<Integer>> forest = new ArrayList<>();
        for(int i = 0; i < input.length; i++){
            List<Integer> fRow = new ArrayList<>();
            for(int j = 0; j < input[i].length; j++){
                fRow.add(input[i][j]);
            }
            forest.add(fRow);
        }
        CutOffTreesForGolfEvent c = new CutOffTreesForGolfEvent();
        int steps = c.cutOffTree(forest);
        System.out.println(steps);
    }
    static int minSteps = Integer.MAX_VALUE;
    public int cutOffTree(List<List<Integer>> forest) {
        //Initiate total number of steps to cut all trees
        int totalSteps = 0;
        //Sort trees in ascending order
        List<int[]> sortedTrees = sortTrees(forest);
        //Loop sorted trees
        if(forest.size() == 0 || forest.get(0).size() == 0)
            return totalSteps;

        int[] start = new int[]{forest.get(0).get(0),0,0};
        for(int i = 0; i < sortedTrees.size(); i++){
            //The Shortest steps bw two trees in order
            int stepsReq = minSteps(forest,start,sortedTrees.get(i));
            //System.out.println(stepsReq+" - "+start[0]+" - "+sortedTrees.get(i)[0]);
            if(stepsReq==-1) return stepsReq;
            //Add the shortest steps to total steps variable
            totalSteps += stepsReq;
            start = sortedTrees.get(i);
        }
        return totalSteps;
    }

    private int minSteps(List<List<Integer>> forest, int[] source, int[] destination){
        Set<Integer> visited = new HashSet<>();
        int minSteps = 0;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(source);
        visited.add(source[0]);

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int[] node = queue.poll();

                if(node[0] == destination[0]){
                    return minSteps;
                }
                for(int d = 0; d < directions.length; d++){
                    int x = node[1] + directions[d][0];
                    int y = node[2] + directions[d][1];
                    if(x >= 0 && x < forest.size() &&
                            y >= 0 && y < forest.get(0).size() &&
                            forest.get(x).get(y) != 0 && !visited.contains(forest.get(x).get(y))){
                        queue.add(new int[]{forest.get(x).get(y),x,y});
                        visited.add(forest.get(x).get(y));
                    }
                }
            }
            minSteps++;
        }

        return -1;
    }
    private List<int[]> sortTrees(List<List<Integer>> forest){
        List<int[]> trees = new ArrayList<>();
        for(int x = 0; x < forest.size(); x++){
            for(int y = 0; y < forest.get(x).size(); y++){
                int treeHeight = forest.get(x).get(y);
                if(treeHeight > 1) {
                    trees.add(new int[]{forest.get(x).get(y), x, y});
                }
            }
        }
        trees.sort(Comparator.comparing(a -> a[0]));
        return trees;
    }

}

package com.anil.treesandgraphs;

import java.util.ArrayDeque;
import java.util.Queue;

public class NumberOfIslands {
    public static void main(String[] args) {
        char[][] grid = {
          {'1','1','1','1','0'},
          {'1','1','0','1','0'},
          {'1','1','0','0','0'},
          {'0','0','0','0','0'}
        };
        NumberOfIslands n = new NumberOfIslands();
        int numIslands = n.numIslands(grid);
        System.out.println(numIslands);
    }

    private void dfs(char[][] grid,int r,int c){
        int re = grid.length-1;
        int ce = grid[0].length-1;

        if(r < 0 || r > re || c < 0 || c > ce || grid[r][c] == '0')
            return;
        grid[r][c] = '0';
        dfs(grid,r-1,c);
        dfs(grid,r+1,c);
        dfs(grid,r,c-1);
        dfs(grid,r,c+1);
    }
    public int numIslandsRecursive(char[][] grid) {
        int numIslands = 0;

        for(int r = 0; r < grid.length; r++){
            for (int c = 0; c < grid[0].length; c++){
                if(grid[r][c] == '1'){
                    numIslands++;
                    dfs(grid,r,c);
                }
            }
        }
        return numIslands;
    }

    //Iterative
    public int numIslands(char[][] grid) {
        int numIslands = 0;
        for(int r = 0; r < grid.length; r++){
            for (int c = 0; c < grid[0].length; c++){
                if(grid[r][c] == '1'){
                    numIslands++;
                    sinkIsland(grid,r,c);
                }
            }
        }
        return numIslands;
    }

    private void sinkIsland(char[][] grid,int r,int c){
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{r,c});
        while(!queue.isEmpty()){
            int[] rc = queue.poll();
            int tempR = rc[0];
            int tempC = rc[1];
            if(tempC+1 < grid[0].length && grid[tempR][tempC+1] == '1'){
                grid[tempR][tempC+1] = '0';
                queue.add(new int[]{tempR,tempC+1});
            }
            if(tempC-1 >= 0 && grid[tempR][tempC-1] == '1'){
                grid[tempR][tempC-1] = '0';
                queue.add(new int[]{tempR,tempC-1});
            }
            if(tempR+1 < grid.length && grid[tempR+1][tempC] == '1'){
                grid[tempR+1][tempC] = '0';
                queue.add(new int[]{tempR+1,tempC});
            }
            if(tempR-1 >= 0 && grid[tempR-1][tempC] == '1'){
                grid[tempR-1][tempC] = '0';
                queue.add(new int[]{tempR-1,tempC});
            }

        }
    }

}

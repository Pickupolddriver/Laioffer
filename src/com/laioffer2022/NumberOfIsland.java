package com.laioffer2022;

public class NumberOfIsland {
    public int numIslands(char[][] grid) {
        // Corner case
        if(grid==null || grid.length==0 || grid[0].length==0){
            return 0;
        }
        int res =0;

        for(int row=0;row<grid.length;row++){
            for(int col=0;col<grid[0].length;col++){
                if(grid[row][col]=='1'){
                    res++;
                    dfs(grid,row,col);
                }
            }
        }
        return res;
    }

    public void dfs(char[][] grid, int row, int col){
        // Terminate condition
        if(row>=grid.length || row<0 || col<0 || col>=grid[0].length || grid[row][col]=='0'){
            return;
        }
        // Expanding Rule
        grid[row][col] = '0';
        dfs(grid,row+1,col);
        dfs(grid,row-1,col);
        dfs(grid,row,col+1);
        dfs(grid,row,col-1);
    }
}

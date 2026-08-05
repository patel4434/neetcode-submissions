class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();

        int rows = grid.length;
        int cols = grid[0].length;


        for(int i = 0 ; i < rows; i++){
            for(int j = 0 ; j< cols; j++){
                if(grid[i][j] == 0){
                    queue.offer(new int[]{i,j});
                }
            }
        }

        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};

        while(!queue.isEmpty()){
            int[] curr = queue.poll();

            int row = curr[0];
            int col = curr[1];

            for(int[] dir : directions ){
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if( newRow < 0 ||
                    newRow >= rows ||
                    newCol < 0 ||
                    newCol >= cols ||
                    grid[newRow][newCol] != Integer.MAX_VALUE) continue ;

                grid[newRow][newCol] = grid[row][col]+1;

                queue.offer(new int[]{newRow,newCol});                   
            }



        }
    }
}

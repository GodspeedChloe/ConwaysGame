package GameBoard;

import java.util.ArrayList;

/**
 * Created by Chloe on 1/28/2016.
 * Purpose: To keep track of all the cellular automata in the world + define the world
 */
public class Board {

    //ArrayList for all the alive cells
    private ArrayList<Cell> Cells;

    public Board() {
        setCells(new ArrayList<>());
    }

    /**
     * Displays the Board's information at a specific tick
     * @param tick the specific tick at which the board is displayed
     */
    public void toDisplay(int tick){

        System.out.println("\nAT TICK NUMBER " + Integer.toString(tick) + ":\n");
        //Print every Cell
        for(Cell alive : getCells()) {
            System.out.println(alive.toString());
        }
    }

    /**
     * Method to run the game by executing rules 1-4
     * Updates the board after the rules have been executed
     */
    public void playBall(){

        //we want to save which cells we are adding and removing
        ArrayList<Cell> removeList = new ArrayList<>();

        //For every alive Cell
        for (Cell curr : getCells()){

            //find out how many neighbors it has
            int rules = curr.neighborCount(getCells());

            //1. Any live cell with fewer than two live neighbours dies, as if caused by under-population.
            if (rules < 2){
                removeList.add(curr);
            }

            //2. Any live cell with two or three live neighbours lives on to the next generation.
            //Because nothing happens in this case we can omit any functions here by checking rules 1,3,and 4

            //3. Any live cell with more than three live neighbours dies, as if by over-population.
            else if (rules > 3){
                removeList.add(curr);
            }
        }

        //4. Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.
        //as long as we have three live cells or more

        //find and add all the cells that will become alive
        if (getCells().size() > 2) {
            ArrayList<Cell> add_list = getCells();
            for (Cell to_add : shareNeighbor()) {
                if (containsCell(to_add,getCells()) >= 0){
                    continue;
                }
                add_list.add(to_add);
            }
            setCells(add_list);
        }

        //iterate through the removeList and all the alive cells, removing all the matches
        for(Cell remove_kebab : removeList) {
            int index_to_remove = containsCell(remove_kebab, getCells());
            removeCell(index_to_remove);
        }
    }

    /**
     * This method returns the list of Cells that should become alive due to
     * reproduction (rule #4)
     * This method is the most complicated due to how many iterative loops are executed
     * @return
     */
    public ArrayList<Cell> shareNeighbor(){

        //our List for the cells we are going to be giving life to
        ArrayList<Cell> lazarus = new ArrayList<>();

        //go through all the alive cells
        for (Cell curr : getCells()) {

            //get the live cell's neighbors
            ArrayList<Cell> nbors1 = curr.getNeighbors();
            for (Cell nbor : nbors1){

                //if the neighbor is dead
                if (containsCell(nbor,getCells()) == -1){

                    //check how many neighbors to this cell are alive
                    int n = nbor.neighborCount(getCells());

                    //if exactly three live neighbors, add it once to list
                    if (n == 3){

                        //if cell hasn't already been marked for birth
                        if (containsCell(nbor,lazarus) == -1){
                            lazarus.add(nbor);
                        }
                    }
                }
            }
        }
        return lazarus;
    }

    /**
     * Method for seeing if a cell is already alive
     * @param query the cell we're seeing if is already alive
     * @return yes or no to whether it exists
     */
    public int containsCell(Cell query, ArrayList<Cell> liveCells){
        for (int i = 0; i < liveCells.size(); i++){
            if (liveCells.get(i).sameCell(query)){
                return i;
            }
        }
        return -1;
    }

    /**
     * Method for removing a cell as if by death
     */
    public void removeCell(int index_to_remove){
        ArrayList<Cell> removed = getCells();
        removed.remove(index_to_remove);
        setCells(removed);
    }

    public ArrayList<Cell> getCells() {
        return Cells;
    }

    public void setCells(ArrayList<Cell> cells) {
        Cells = cells;
    }
}



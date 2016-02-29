package Game.GameBoard;

import java.util.ArrayList;

/**
 * Created by Chloe on 1/28/2016.
 * File purpose: To keep track of all the cellular automata in the world + define the world
 */
public class Board {

    //ArrayList for all the alive cells
    private ArrayList<Cell> Cells;

    /**
     * Constructor for the board
     */
    public Board() {
        setCells(new ArrayList<>());
    }


    /**
     * This method displays the Board's information at a specific tick
     * @param tick the specific tick at which the board is displayed
     */
    public void displayBoard(int tick){

        System.out.println("\nAT TICK NUMBER " + Integer.toString(tick) + ":\n");
        //Print every Cell
        for(Cell alive : getCells()) alive.toString();
    }


    /**
     * Method to run the game by executing rules 1-4
     * Updates the board after the rules have been executed
     */
    public void executeTick(){

        //we want to save which cells we are adding and removing
        ArrayList<Cell> removeList = new ArrayList<>();

        //For every alive Cell
        for (Cell alive : getCells()){

            //find out how many neighbors it has
            int rules = alive.neighborCount(this);

            //1. Any live cell with fewer than two live neighbors dies, as if caused by under-population.
            if (rules < 2){
                removeList.add(alive);
            }

            //2. Any live cell with two or three live neighbors lives on to the next generation.
            //Because nothing happens in this case we can omit any functions here by checking rules 1,3,and 4

            //3. Any live cell with more than three live neighbors dies, as if by over-population.
            else if (rules > 3){
                removeList.add(alive);
            }
        }

        //4. Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
        //as long as we have three live cells or more

        //find and add all the cells that will become alive
        if (getCells().size() > 2) {

            ArrayList<Cell> add_list = getCells();
            for (Cell baby_cell : birthCells()) {
                add_list.add(baby_cell);
            }
            setCells(add_list);
        }

        //iterate through the removeList and all the alive cells, removing all the matches
        for(Cell dying_cell : removeList) {
            int remove_index = containsCell(dying_cell, getCells());
            removeCell(remove_index);
        }
    }


    /**
     * This method returns the list of Cells that should become alive due to
     * reproduction (rule #4)
     * @return the list of cells that need to be added to the board
     */
    public ArrayList<Cell> birthCells(){

        //our List for the cells we are going to be giving life to
        ArrayList<Cell> new_cells = new ArrayList<>();

        //go through all the alive cells
        for (Cell curr : getCells()) {

            //go through the live cell's neighbors
            for (Cell neighbor : curr.getNeighbors()){

                //if the neighbor is dead
                if (containsCell(neighbor,getCells()) == -1){

                    //check how many neighbors to this cell are alive
                    int n = neighbor.neighborCount(this);

                    //if exactly three live neighbors, add it once to list
                    if (n == 3){

                        //if cell hasn't already been marked for birth
                        if (containsCell(neighbor,new_cells) == -1){
                            new_cells.add(neighbor);
                        }
                    }
                }
            }
        }
        return new_cells;
    }


    /**
     * Method for seeing if a cell is already alive
     * @param query the cell we're seeing if it's already alive
     * @return the index where a cell is or -1 if it isn't found
     */
    public int containsCell(Cell query, ArrayList<Cell> liveCells){
        for (int cell_index = 0; cell_index < liveCells.size(); cell_index++){
            if (liveCells.get(cell_index).sameCell(query)){
                return cell_index;
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


    /**
     * Getter method for the world's Cells
     * @return The list of alive cells
     */
    public ArrayList<Cell> getCells() {
        return Cells;
    }


    /**
     * Setter method for the world's Cells
     * @param cells The new list of alive cells
     */
    public void setCells(ArrayList<Cell> cells) {
        Cells = cells;
    }
}



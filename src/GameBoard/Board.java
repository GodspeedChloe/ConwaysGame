package GameBoard;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by Chloe on 1/28/2016.
 * Purpose: To keep track of all the cellular automata in the world + define the world
 */
public class Board {

    //HashSet for all the alive cells
    public ArrayList<Cell> Cells = new ArrayList<>();


    /**
     * Displays the Board's information at a specific tick
     * @param tick the specific tick at which the board is displayed
     */
    public void toDisplay(int tick){

        System.out.println("\nAT TICK NUMBER " + Integer.toString(tick) + ":\n\n");
        //Print every Cell in quadrant 1


    }

    /**
     * Method to run the game by executing rules 1-4
     * Updates the board after the rules have been executed
     */
    public void playBall(){

        //we want to save which cells we are adding and removing
        ArrayList<Cell> addList = new ArrayList<>();
        ArrayList<Cell> removeList = new ArrayList<>();

        //For every alive Cell
        for (Cell curr : this.Cells){

            //find out how many neighbors it has
            int rules = curr.neighborCount(this.Cells);

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
        if (this.Cells.size() > 2){
            //find all the cells that will become alive
            addList.addAll(this.shareNeighbor());
        }

        //iterate through the removeList and all the alive cells, removing all the matches
        for(Cell remove_kebab : removeList)
            for (Cell curr : this.Cells) {
                //if cells are equal
                if (remove_kebab.sameCell(curr)) {
                    int curr_index = this.Cells.indexOf(curr);
                    this.Cells.remove(curr_index);
                }
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
        for (Cell curr : this.Cells){
            //get the live cell's neighbors
            ArrayList<Cell> nbors1 = curr.getNeighbors();

            //go through all the alive cells once more
            for (Cell other : this.Cells){
                //make sure that the cell in this loop is not the same as our first one
                if (curr.sameCell(other)){
                    continue;
                }
                //get this live cell's neighbors
                ArrayList<Cell> nbors2 = other.getNeighbors();

                //go through all the alive cells a third time
                for (Cell last : this.Cells){
                    //make sure that the cell in this loop does not match the first one or second one
                    if (curr.sameCell(last) || other.sameCell(last)){
                        continue;
                    }
                    //get this live cell's neighbors
                    ArrayList<Cell> nbors3 = last.getNeighbors();

                    //Now we have any individual three live cell's neighbors, and now we need to find the
                    //dead neighbors that these three cell's share, thus finding the dead cells with three neighbors

                    //for every neighbor in the first cell's neighbors
                    for (Cell nbor1 : nbors1){

                        //make sure it is dead
                        for (Cell cont : this.Cells) {
                            if (nbor1.sameCell(cont)) {
                                continue;
                            }
                        }

                        //for every neighbor in the second cell's neighbors
                        for (Cell nbor2 : nbors2){

                            //make sure it is dead
                            for (Cell cont : this.Cells) {
                                if (nbor2.sameCell(cont)) {
                                    continue;
                                }
                            }

                            //for every neighbor in the third cell's neighbors
                            for (Cell nbor3 : nbors3){

                                //make sure it is dead
                                for (Cell cont : this.Cells) {
                                    if (nbor3.sameCell(cont)) {
                                        continue;
                                    }
                                }

                                //if all of these neighbors is the same dead cell
                                if (nbor1.sameCell(nbor2) && nbor2.sameCell(nbor3)){
                                    //assume it is not already added to lazarus
                                    boolean add = true;
                                    //make sure it is not already added to lazarus
                                    for (Cell to_add : lazarus){
                                        //if our dead neighbor already is in our list
                                        if (to_add.sameCell(nbor1)){
                                            add = false;
                                            break;
                                        }
                                    }
                                    //if it isn't already in lazarus
                                    if (add){
                                        lazarus.add(nbor1);
                                    }
                                }
                            }
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
    public void removeCell(int index_to_remove, ArrayList<Cell> liveCells){
        liveCells.remove(index_to_remove);
    }
}



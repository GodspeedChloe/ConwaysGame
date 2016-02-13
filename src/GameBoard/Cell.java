package GameBoard;

import java.util.ArrayList;

/**
 * Created by Chloe on 1/28/2016.
 * Cells are the individual automata in the world
 * The quadrant signifies where in relation to "the origin" the direction of X and Y values are
 */
public class Cell {

    //horizontal absolute cartesian position
    public int x = 0;
    //vertical absolute cartesian position
    public int y = 0;


    /**
     * This method fetches all neighboring cells of an alive cell, either dead of alive
     * Will be used prior to the 'four basic rules' logic to cross compare which neighbors are actually alive
     * sides work on the following logic:
     *      side 1 is absolutely above the cell
     *      all other cells go clockwise from side 1
     * @return list of neighboring cells regardless of living status
     */
    public ArrayList<Cell> getNeighbors(){

        //List for storing the neighbors of a cell
        ArrayList<Cell> neighbors = new ArrayList<>();
        for (int side = 1; side < 9; side++) {
            Cell neighbor = new Cell();
            //if above the cell
            if (side == 1){
                neighbor.x = this.x;
                neighbor.y = this.y + 1;
            }
            //if diagonally up + right of the cell
            else if (side == 2){
                neighbor.x = this.x + 1;
                neighbor.y = this.y + 1;
            }
            //if adjacently right to the cell
            else if (side == 3){
                neighbor.x = this.x + 1;
                neighbor.y = this.y;
            }
            //if diagonally down + right of the cell
            else if (side == 4){
                neighbor.x = this.x + 1;
                neighbor.y = this.y - 1;
            }
            //if below the cell
            else if (side == 5){
                neighbor.x = this.x;
                neighbor.y = this.y - 1;
            }
            //if diagonally down + left of the cell
            else if (side == 6){
                neighbor.x = this.x - 1;
                neighbor.y = this.y - 1;
            }
            //if adjacently left to the cell
            else if (side == 7){
                neighbor.x = this.x - 1;
                neighbor.y = this.y;
            }
            //if diagonally up + left of the cell
            else if (side == 8){
                neighbor.x = this.x - 1;
                neighbor.y = this.y + 1;
            }
            neighbors.add(neighbor);
        }
        return neighbors;
    }

    /**
     * counts how many neighboring cells are alive
     * @param liveCells the list of alive cells
     * @return
     */
    public int neighborCount(ArrayList<Cell> liveCells){
        int nbor_count = 0;
        for (Cell curr_cell : liveCells) {
            ArrayList<Cell> nbors = this.getNeighbors();
            for (Cell curr_nbor : nbors) {
                Cell other = curr_cell;
                if (other.x == curr_nbor.x && other.y == curr_nbor.y){nbor_count ++;}
            }
        }
        return nbor_count;
    }

    public boolean sameCell(Cell comp){
        if (this.x == comp.x && this.y == comp.y){
            return true;
        }
        return false;
    }

    @Override
    public String toString(){
        return("X-COORDINATE: " + Integer.toString(this.x) + "        Y-COORDINATE: " + Integer.toString(this.y));
    }
}

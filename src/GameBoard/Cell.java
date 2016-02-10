package GameBoard;

import java.util.ArrayList;

/**
 * Created by Chloe on 1/28/2016.
 * Cells are the individual automata in the world
 * The quadrant signifies where in relation to "the origin" the direction of X and Y values are
 */
public class Cell {

    //FOR QUESTIONS ON THE COORDINATE LOGIC REFER TO README.txt.
    //  TL;DR: every quadrant has a (0,0) point, and all points in this quadrant
    //         are positive integers.  Drawn out, the board has a y-axis positive in both directions
    //         and an x-axis positive in both directions


    //quadrants follow typical cartesian form (I, II, III, IV)
    public int quadrant = 0;
    //horizontal absolute pseudo-cartesian position
    public int x = 0;
    //vertical absolute pseudo-cartesian position
    public int y = 0;


    /**
     * This method uses the four quadrant infinity I've chosen to fetch all the neighboring cells, alive or dead
     * Will be used prior to the 'four basic rules' logic to cross compare which neighbors are actually alive
     * sides work on the following logic:
     *      side 1 is absolutely above the cell
     *      side 2 is absolutely to the right of the cell
     *      side 3 is absolutely below the cell
     *      side 4 is absolutely to the left of the cell
     *      side 5 is absolutely diagonally to right and above the cell
     *      side 6 is absolutely diagonally to the right and below the cell
     *      side 7 is absolutely diagonally to the left and below the cell
     *      side 8 is absolutely diagonally to the left and above the cell
     * @return list of neighboring cells regardless of living status
     */
    public ArrayList<Cell> getNeighbors(){

        //List for storing the neighbors of a cell
        ArrayList<Cell> neighbors = new ArrayList<>();

        //if we're in quadrant 1
        if (this.quadrant == 1) {

            //iterate through every side of this cell
            for (int side = 1; side < 9; side++) {
                //create our neighbor cell
                Cell nbor = new Cell();

                //if we're sides 1,2, or 5
                if (side == 1 || side == 2 || side == 5) {
                    nbor.quadrant = this.quadrant;
                    //if we're above the cell
                    if (side == 1) {nbor.x = this.x;nbor.y = this.y ++;}
                    //if we're to the right of the cell
                    else if (side == 2){nbor.x = this.x ++; nbor.y = this.y;}
                    //if we're diagonally up and to the right of the cell
                    else {nbor.x = this.x ++; nbor.y = this.y ++;}
                }
                //if we're sides 3 or 6
                else if (side == 3 || side == 6){
                    //if we're not right against the x-axis
                    if (this.y > 0){nbor.quadrant = this.quadrant;
                        nbor.x = this.x;
                        nbor.y = this.y --;
                    }
                    //if we're right against the x-axis
                    else {nbor.quadrant = 4;
                        nbor.x = this.x;
                        nbor.y = this.y;
                    }
                    //if we're diagonally down and to the right of the cell
                    if (side == 6){nbor.x = this.x ++;}
                }
                //if we're sides 4 or 8
                else if (side == 4 || side == 8){
                    if (this.x > 0){nbor.quadrant = this.quadrant;
                        nbor.x = this.x --;
                        nbor.y = this.y;
                    }
                    else{nbor.quadrant = 2;
                        nbor.x = this.x;
                        nbor.y = this.y;
                    }
                    if (side == 8){nbor.y++;}
                }
                else if (side == 7){
                    if (this.x == 0 && this.y == 0){nbor.quadrant = 3;
                        nbor.x = this.x;
                        nbor.y = this.y;
                    }
                    else if (this.x > 0 && this.y == 0){nbor.quadrant = 4;
                        nbor.x = this.x --;
                        nbor.y = this.y;
                    }
                    else if (this.y > 0 && this.x == 0){nbor.quadrant = 2;
                        nbor.x = this.x;
                        nbor.y = this.y --;
                    }
                    else{nbor.quadrant = this.quadrant;
                        nbor.x = this.x --;
                        nbor.y = this.y --;
                    }
                }
                neighbors.add(nbor);
            }
        }
        else if (this.quadrant == 2){
            for (int side = 1; side < 9; side++) {
                Cell nbor = new Cell();
                if (side == 1 || side == 4 || side == 8) {
                    nbor.quadrant = this.quadrant;
                    if (side == 1) {nbor.x = this.x; nbor.y = this.y ++;}
                    else if (side == 4) {nbor.x = this.x ++; nbor.y = this.y;}
                    else {nbor.x = this.x ++; nbor.y = this.y ++;}
                }
                if (side == 2 || side == 5){
                    if (this.x > 0) {nbor.quadrant = this.quadrant;
                        nbor.x = this.x --;
                        nbor.y = this.y;
                    }
                    else{nbor.quadrant = 1;
                        nbor.x = this.x;
                        nbor.y = this.y;
                    }
                    if (side == 5){nbor.y = this.y ++;}
                }
                if (side == 3 || side == 7){
                    if (this.y > 0){nbor.quadrant = this.quadrant;
                        nbor.x = this.x;
                        nbor.y = this.y --;
                    }
                    else{nbor.quadrant = 4;
                        nbor.x = this.x;
                        nbor.y = this.y;
                    }
                    if (side == 7){nbor.x ++;}
                }
                if (side == 6){
                    if (this.x == 0 && this.y == 0){nbor.quadrant = 4;
                        nbor.x = this.x;
                        nbor.y = this.y;
                    }
                    else if (this.x > 0 && this.y == 0){nbor.quadrant = 3;
                        nbor.x = this.x --;
                        nbor.y = this.y;
                    }
                    else if (this.y > 0 && this.x == 0){nbor.quadrant = 1;
                        nbor.x = this.x;
                        nbor.y = this.y --;
                    }
                    else{nbor.quadrant = this.quadrant;
                        nbor.x = this.x --;
                        nbor.y = this.y --;
                    }
                }
                neighbors.add(nbor);
            }
        }
        else if (this.quadrant == 3){
            for (int side = 1; side < 9; side++){
                Cell nbor = new Cell();
                if (side == 1 || side == 8){
                    if (this.y > 0){nbor.quadrant = this.quadrant;
                        nbor.x = this.x;
                        nbor.y = nbor.y --;
                    }
                    else{nbor.quadrant = 2;
                        nbor.x = this.x;
                        nbor.y = this.y;
                    }
                    if (side == 8){nbor.x = this.x ++;}
                }
                if (side == 2 || side == 6){
                    if (this.x > 0){nbor.quadrant = this.quadrant;
                        nbor.x = this.x --;
                        nbor.y = this.y;
                    }
                    else{nbor.quadrant = 4;
                        nbor.x = this.x;
                        nbor.y = this.y;
                    }
                    if (side == 6){nbor.y ++;}
                }
                if (side == 5){
                    if (this.x == 0 && this.y == 0){nbor.quadrant = 1;
                        nbor.x = this.x;
                        nbor.y = this.y;
                    }
                    else if (this.x > 0 && this.y == 0){nbor.quadrant = 2;
                        nbor.x = this.x --;
                        nbor.y = this.y;
                    }
                    else if (this.y > 0 && this.x == 0){nbor.quadrant = 4;
                        nbor.x = this.x;
                        nbor.y = this.y --;
                    }
                    else{nbor.quadrant = this.quadrant;
                        nbor.x = this.x --;
                        nbor.y = this.y --;
                    }
                }
                if (side == 3 || side == 7 || side == 4){
                    nbor.quadrant = this.quadrant;
                    if (side == 3) {nbor.x = this.x; nbor.y = this.y ++;}
                    else if (side == 4){nbor.x = this.x ++; nbor.y = this.y;}
                    else{ nbor.x = this.x ++; nbor.y = this.y ++;}
                }
                neighbors.add(nbor);
            }
        }
        else {
            for (int side = 1; side < 9; side++) {
                Cell nbor = new Cell();
                if (side == 1 || side == 5){
                    if (this.y > 0){nbor.quadrant = this.quadrant;
                        nbor.x = this.x;
                        nbor.y = this.y --;
                    }
                    else{nbor.quadrant = 1;
                        nbor.x = this.x;
                        nbor.y = this.y;
                    }
                    if (side == 5){nbor.x ++;}
                }
                if (side == 2 || side == 6 || side == 3){
                    nbor.quadrant = this.quadrant;
                    if (side == 2){nbor.y = this.y; nbor.x = this.x ++;}
                    else if (side == 6){nbor.y = this.y ++; nbor.x = this.x ++;}
                    else {nbor.x = this.x; nbor.y = this.y ++;}
                }
                if (side == 4 || side == 7){
                    if (this.x > 0){nbor.quadrant = this.quadrant;
                        nbor.x = this.x --;
                        nbor.y = this.y;
                    }
                    else{nbor.quadrant = 3;
                        nbor.x = this.x;
                        nbor.y = this.y;
                    }
                    if (side == 7){nbor.y ++;}
                }
                if (side == 8){
                    if (this.x == 0 && this.y == 0){nbor.quadrant = 2;
                        nbor.x = this.x;
                        nbor.y = this.y;
                    }
                    else if (this.x > 0 && this.y == 0){nbor.quadrant = 1;
                        nbor.x = this.x --;
                        nbor.y = this.y;
                    }
                    else if (this.y > 0 && this.x == 0){nbor.quadrant = 3;
                        nbor.x = this.x;
                        nbor.y = this.y --;
                    }
                    else{nbor.quadrant = this.quadrant;
                        nbor.x = this.x --;
                        nbor.y = this.y --;
                    }
                }
                neighbors.add(nbor);
            }
        }
        return neighbors;
    }

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
        if (this.quadrant == comp.quadrant && this.x == comp.x && this.y == comp.y){
            return true;
        }
        return false;
    }

    @Override
    public String toString(){
        return("X-COORDINATE: " + Integer.toString(this.x) + "        Y-COORDINATE: " + Integer.toString(this.y));
    }
}

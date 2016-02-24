package GameBoard;

import java.util.ArrayList;

/**
 * Created by Chloe on 1/28/2016.
 * Cells are the individual automata in the world
 * The quadrant signifies where in relation to "the origin" the direction of X and Y values are
 */
public class Cell {

    //horizontal absolute cartesian position
    private int x;
    //vertical absolute cartesian position
    private int y;

    public Cell(){
        setX(x);
        setY(y);
    }

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
                neighbor.setX(getX());
                neighbor.setY(getY()+1);
            }
            //if diagonally up + right of the cell
            else if (side == 2){
                neighbor.setX(getX()+1);
                neighbor.setY(getY()+1);
            }

            //if adjacently right to the cell
            else if (side == 3){
                neighbor.setX(getX()+1);
                neighbor.setY(getY());
            }
            //if diagonally down + right of the cell
            else if (side == 4){
                neighbor.setX(getX()+1);
                neighbor.setY(getY()-1);
            }
            //if below the cell
            else if (side == 5){
                neighbor.setX(getX());
                neighbor.setY(getY()-1);
            }
            //if diagonally down + left of the cell
            else if (side == 6){
                neighbor.setX(getX()-1);
                neighbor.setY(getY()-1);
            }
            //if adjacently left to the cell
            else if (side == 7){
                neighbor.setX(getX()-1);
                neighbor.setY(getY());
            }
            //if diagonally up + left of the cell
            else if (side == 8){
                neighbor.setX(getX()-1);
                neighbor.setY(getY()+1);
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
            ArrayList<Cell> nbors = getNeighbors();
            for (Cell curr_nbor : nbors) {
                if (curr_cell.getX() == curr_nbor.getX() && curr_cell.getY() == curr_nbor.getY()){nbor_count ++;}
            }
        }
        return nbor_count;
    }

    /**
     * Method for comparing if two cells occupy the same space
     * @param comp
     * @return
     */
    public boolean sameCell(Cell comp){
        if (getX() == comp.getX() && getY() == comp.getY()){
            return true;
        }
        return false;
    }

    /**
     * Getter method for x-coordinate
     * @return
     */
    public int getX() {
        return x;
    }

    /**
     * Getter method for y-coordinate
     * @return
     */
    public int getY(){
        return y;
    }

    /**
     * Setter method for x-coordinate
     * @param x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Setter method for y-coordinate
     * @param y
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * toString method for a cell
     * @return
     */
    @Override
    public String toString(){
        return("X-COORDINATE: " + Integer.toString(getX()) + "                          Y-COORDINATE: " + Integer.toString(getY()));
    }
}

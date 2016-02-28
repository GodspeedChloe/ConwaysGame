package Game.GameBoard;

import java.util.ArrayList;

/**
 * Created by Chloe on 1/28/2016.
 * Cells are the individual automata in the world
 */
public class Cell {

    //horizontal cartesian position
    private int x;
    //vertical cartesian position
    private int y;


    /**
     * Constructor for the cell
     */
    public Cell(){
        setX(x);
        setY(y);
    }


    /**
     * This method fetches all neighboring cells of an alive cell, either dead or alive
     * @return list of neighboring cells regardless of living status
     */
    public ArrayList<Cell> getNeighbors(){

        //List for storing the neighbors of a cell
        ArrayList<Cell> friends = new ArrayList<>();
        Cell neighbor = new Cell();

        neighbor.setX(getX());
        neighbor.setY(getY() + 1);
        friends.add(neighbor);
        neighbor.setX(getX() + 1);
        friends.add(neighbor);
        neighbor.setY(getY());
        friends.add(neighbor);
        neighbor.setY(getY() - 1);
        friends.add(neighbor);
        neighbor.setX(getX());
        friends.add(neighbor);
        neighbor.setX(getX() - 1);
        friends.add(neighbor);
        neighbor.setY(getY());
        friends.add(neighbor);
        neighbor.setY(getY() + 1);
        friends.add(neighbor);
        return friends;
    }


    /**
     * This method counts how many neighboring cells are alive
     * @param World the board
     * @return how many neighbors of a cell are alive
     */
    public int neighborCount(Board World){
        int nbor_count = 0;
        for (Cell neighbor : getNeighbors()){
            if (World.containsCell(neighbor, World.getCells()) != -1){
                nbor_count++;
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
        return("X-COORDINATE: " + Integer.toString(getX()) +
                "                          Y-COORDINATE: " + Integer.toString(getY()));
    }
}

package Game.GameBoard;

import java.util.ArrayList;

/**
 * Created by Chloe on 1/28/2016.
 * This file defines what a Cell is and methods that they can access to provide information on themselves
 * Cells are the cellular automata that are what is "alive" in the Game of Life
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

        Cell neighbor1 = new Cell();
        neighbor1.setX(getX());
        neighbor1.setY(getY() + 1);
        friends.add(neighbor1);

        Cell neighbor2 = new Cell();
        neighbor2.setX(getX() + 1);
        neighbor2.setY(getY() + 1);
        friends.add(neighbor2);

        Cell neighbor3 = new Cell();
        neighbor3.setX(getX() + 1);
        neighbor3.setY(getY());
        friends.add(neighbor3);

        Cell neighbor4 = new Cell();
        neighbor4.setX(getX() + 1);
        neighbor4.setY(getY() - 1);
        friends.add(neighbor4);

        Cell neighbor5 = new Cell();
        neighbor5.setY(getY() - 1);
        neighbor5.setX(getX());
        friends.add(neighbor5);

        Cell neighbor6 = new Cell();
        neighbor6.setX(getX() - 1);
        neighbor6.setY(getY() - 1);
        friends.add(neighbor6);

        Cell neighbor7 = new Cell();
        neighbor7.setX(getX() - 1);
        neighbor7.setY(getY());
        friends.add(neighbor7);

        Cell neighbor8 = new Cell();
        neighbor8.setX(getX() - 1);
        neighbor8.setY(getY() + 1);
        friends.add(neighbor8);
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

        System.out.printf("%-30.30s  %-30.30s%n", "X-COORDINATE: " +
                        Integer.toString(getX()), "Y-COORDINATE: " + Integer.toString(getY()));
        return "";
    }
}

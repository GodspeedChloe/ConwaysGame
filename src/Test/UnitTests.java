package Test;

import GameBoard.Cell;

import java.util.ArrayList;

/**
 * Created by Chloe on 2/24/2016.
 */
public class UnitTests{

    /**
     * Check whether or not the game runs the r-pentimento correctly for 5 iterations
     * input to start the program should be the cells {(-1,1),(0,0),(0,1),(0,2),(1,2)}
     * # of ticks should be 5
     * @param liveCells
     * @return
     */
    public static boolean Test1(ArrayList<Cell> liveCells){

        if (liveCells.size() != 9){
            return false;
        }

        for (Cell alive : liveCells){
            if (alive.getX()==0 && alive.getY()==0){
                continue;
            }
            else if(alive.getX()==-1 && alive.getY()==0){
                continue;
            }
            else if(alive.getX()==0 && alive.getY()==3){
                continue;
            }
            else if(alive.getX()==1 && alive.getY()==1){
                continue;
            }
            else if(alive.getX()==1 && alive.getY()==2){
                continue;
            }
            else if(alive.getX()==2 && alive.getY()==2){
                continue;
            }
            else if(alive.getX()==-1 && alive.getY()==2){
                continue;
            }
            else if(alive.getX()==-2 && alive.getY()==1){
                continue;
            }
            else if(alive.getX()==-2 && alive.getY()==2){
                continue;
            }
            else{
                return false;
            }
        }
        return true;
    }

    /**
     * Check whether or not the game runs the r-pentimento correctly for 5 iterations
     * input to start the program should be the cells {(-1,1),(0,0),(0,1),(0,2),(1,2)}
     * # of ticks should be 10
     * @param liveCells
     * @return
     */
    public static boolean Test2(ArrayList<Cell> liveCells){

        if (liveCells.size() != 11){
            return false;
        }

        for (Cell alive : liveCells){

            if (alive.getX()==0 && alive.getY()==0){
                continue;
            }
            else if (alive.getX()==0 && alive.getY()==-1){
                continue;
            }
            else if (alive.getX()==0 && alive.getY()==-2){
                continue;
            }
            else if (alive.getX()==-1 && alive.getY()==0){
                continue;
            }
            else if (alive.getX()==-2 && alive.getY()==0){
                continue;
            }
            else if (alive.getX()==-2 && alive.getY()==1){
                continue;
            }
            else if (alive.getX()==-2 && alive.getY()==3){
                continue;
            }
            else if (alive.getX()==-3 && alive.getY()==1){
                continue;
            }
            else if (alive.getX()==-3 && alive.getY()==2){
                continue;
            }
            else if (alive.getX()==-3 && alive.getY()==3){
                continue;
            }
            else if (alive.getX()==-4 && alive.getY()==2){
                continue;
            }
            else{
                return false;
            }
        }
        return true;
    }
}

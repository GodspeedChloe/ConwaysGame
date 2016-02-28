package TestSuite;

import Game.GameBoard.Board;
import Game.GameBoard.Cell;

import java.util.ArrayList;


/**
 * Created by Chloe on 2/26/2016.
 * This file Runs all the tests on the game.
 * The testing is done by unit testing with black box focus.
 * We monitor what goes and in and we check the result.
 * All results checking is cross-checked with bitstorm.org's implementation of the game.
 * Their game can be found at http://www.bitstorm.org/gameoflife/
 */
public class RunTests {


    /**
     * Main class to run all the tests that are written
     */
    public static void main(String[] args){

        Board testWorld = new Board();
        System.out.println("Starting tests");
        //fill for test 1
        rPentomino(testWorld);
        UnitTests.Test1(testWorld);
        //fill for test 2
        rPentomino(testWorld);
        UnitTests.Test2(testWorld);
        //fill for test 3
        rPentomino(testWorld);
        UnitTests.Test3(testWorld);
        //fill for test 4
        insertBlock(testWorld);
        UnitTests.Test4(testWorld);
        //fill for test 5
        insertBlock(testWorld);
        UnitTests.Test5(testWorld);
        //fill for test 6
        insertBoat(testWorld);
        UnitTests.Test6(testWorld);
        //fill for test 7
        insertBoat(testWorld);
        UnitTests.Test7(testWorld);
        //fill for test 8
        insertBlinker(testWorld);
        UnitTests.Test8(testWorld);
        //fill for test 9
        insertBlinker(testWorld);
        UnitTests.Test9(testWorld);
        //fill for test 10
        insertBeacon(testWorld);
        UnitTests.Test10(testWorld);
        //fill for test 11
        insertBeacon(testWorld);
        UnitTests.Test11(testWorld);
    }


    /**
     * Function for inserting the R-Pentomino into the board
     * Fills the board for tests 1 through 3
     * @param World the Board we're filling
     */
    public static void rPentomino(Board World){

        ArrayList<Cell> rPent = new ArrayList<>();
        Cell input = new Cell();
        input.setX(-1);
        input.setY(1);
        rPent.add(input);
        input.setX(0);
        input.setY(0);
        rPent.add(input);
        input.setY(1);
        rPent.add(input);
        input.setY(2);
        rPent.add(input);
        input.setX(1);
        rPent.add(input);
        World.setCells(rPent);
    }


    /**
     * Function for inserting a block still life into the board
     * Fills the board for tests 4 and 5
     * @param World
     */
    public static void insertBlock(Board World){

        ArrayList<Cell> block = new ArrayList<>();
        Cell input = new Cell();
        input.setX(0);
        input.setY(0);
        block.add(input);
        input.setY(1);
        block.add(input);
        input.setX(1);
        block.add(input);
        input.setY(0);
        block.add(input);
        World.setCells(block);
    }


    /**
     * Function for inserting a boat still life into the board
     * Fills the board for tests 6 and 7
     * @param World
     */
    public static void insertBoat(Board World){

        ArrayList<Cell> boat = new ArrayList<>();
        Cell input = new Cell();
        input.setX(0);
        input.setY(0);
        boat.add(input);
        input.setY(2);
        boat.add(input);
        input.setX(-1);
        boat.add(input);
        input.setY(1);
        boat.add(input);
        input.setX(1);
        boat.add(input);
        World.setCells(boat);
    }


    /**
     * Function for inserting a blinker oscillator into the board
     * Fills the board for tests 8 and 9
     * @param World
     */
    public static void insertBlinker(Board World){

        ArrayList<Cell> blinker = new ArrayList<>();
        Cell input = new Cell();
        input.setX(0);
        input.setY(0);
        blinker.add(input);
        input.setY(-1);
        blinker.add(input);
        input.setY(1);
        blinker.add(input);
        World.setCells(blinker);
    }


    /**
     * Function for inserting a beacon oscillator into the board
     * Fills the board for tests 10 and 11
     * @param World
     */
    public static void insertBeacon(Board World){

        ArrayList<Cell> beacon = new ArrayList<>();
        Cell input = new Cell();
        input.setX(0);
        input.setY(0);
        beacon.add(input);
        input.setY(1);
        beacon.add(input);
        input.setX(1);
        beacon.add(input);
        input.setY(0);
        beacon.add(input);
        input.setX(2);
        input.setY(2);
        beacon.add(input);
        input.setY(3);
        beacon.add(input);
        input.setX(3);
        beacon.add(input);
        input.setY(2);
        beacon.add(input);
    }
}

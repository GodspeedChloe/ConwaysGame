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
        System.out.println("Starting tests\n");

        //fill for test 1
        testWorld.setCells(rPentomino());
        UnitTests.Test1(testWorld);

        //fill for test 2
        testWorld.setCells(rPentomino());
        UnitTests.Test2(testWorld);

        //fill for test 3
        testWorld.setCells(rPentomino());
        UnitTests.Test3(testWorld);

        //fill for test 4
        testWorld.setCells(insertBlock());
        UnitTests.Test4(testWorld);

        //fill for test 5
        testWorld.setCells(insertBlock());
        UnitTests.Test5(testWorld);

        //fill for test 6
        testWorld.setCells(insertBoat());
        UnitTests.Test6(testWorld);

        //fill for test 7
        testWorld.setCells(insertBoat());
        UnitTests.Test7(testWorld);

        //fill for test 8
        testWorld.setCells(insertBlinker());
        UnitTests.Test8(testWorld);

        //fill for test 9
        testWorld.setCells(insertBlinker());
        UnitTests.Test9(testWorld);

        //fill for test 10
        testWorld.setCells(insertBeacon());
        UnitTests.Test10(testWorld);

        //fill for test 11
        testWorld.setCells(insertBeacon());
        UnitTests.Test11(testWorld);
    }


    /**
     * Function for inserting the R-Pentomino into the board
     * Fills the board for tests 1 through 3
     * @param
     */
    public static ArrayList<Cell> rPentomino(){

        ArrayList<Cell> rPent = new ArrayList<>();

        Cell input1 = new Cell();
        input1.setX(0);
        input1.setY(0);
        rPent.add(input1);

        Cell input2 = new Cell();
        input2.setX(0);
        input2.setY(1);
        rPent.add(input2);

        Cell input3 = new Cell();
        input3.setX(-1);
        input3.setY(1);
        rPent.add(input3);

        Cell input4 = new Cell();
        input4.setX(1);
        input4.setY(2);
        rPent.add(input4);

        Cell input5 = new Cell();
        input5.setX(0);
        input5.setY(2);
        rPent.add(input5);

        return rPent;
    }


    /**
     * Function for inserting a block still life into the board
     * Fills the board for tests 4 and 5
     */
    public static ArrayList<Cell> insertBlock(){

        ArrayList<Cell> block = new ArrayList<>();

        Cell input1 = new Cell();
        input1.setX(0);
        input1.setY(0);
        block.add(input1);

        Cell input2 = new Cell();
        input2.setX(0);
        input2.setY(1);
        block.add(input2);

        Cell input3 = new Cell();
        input3.setX(1);
        input3.setY(1);
        block.add(input3);

        Cell input4 = new Cell();
        input4.setX(1);
        input4.setY(0);
        block.add(input4);

        return block;
    }


    /**
     * Function for inserting a boat still life into the board
     * Fills the board for tests 6 and 7
     */
    public static ArrayList<Cell> insertBoat(){

        ArrayList<Cell> boat = new ArrayList<>();

        Cell input1 = new Cell();
        input1.setX(0);
        input1.setY(0);
        boat.add(input1);

        Cell input2 = new Cell();
        input2.setX(0);
        input2.setY(2);
        boat.add(input2);

        Cell input3 = new Cell();
        input3.setX(-1);
        input3.setY(2);
        boat.add(input3);

        Cell input4 = new Cell();
        input4.setX(-1);
        input4.setY(1);
        boat.add(input4);

        Cell input5 = new Cell();
        input5.setX(1);
        input5.setY(1);
        boat.add(input5);

        return boat;
    }


    /**
     * Function for inserting a blinker oscillator into the board
     * Fills the board for tests 8 and 9
     */
    public static ArrayList<Cell> insertBlinker(){

        ArrayList<Cell> blinker = new ArrayList<>();

        Cell input1 = new Cell();
        input1.setX(0);
        input1.setY(0);
        blinker.add(input1);

        Cell input2 = new Cell();
        input2.setX(0);
        input2.setY(-1);
        blinker.add(input2);

        Cell input3 = new Cell();
        input3.setX(0);
        input3.setY(1);
        blinker.add(input3);

        return blinker;
    }


    /**
     * Function for inserting a beacon oscillator into the board
     * Fills the board for tests 10 and 11
     */
    public static ArrayList<Cell> insertBeacon(){

        ArrayList<Cell> beacon = new ArrayList<>();

        Cell input1 = new Cell();
        input1.setX(0);
        input1.setY(0);
        beacon.add(input1);

        Cell input2 = new Cell();
        input2.setX(0);
        input2.setY(1);
        beacon.add(input2);

        Cell input3 = new Cell();
        input3.setX(1);
        input3.setY(0);
        beacon.add(input3);

        Cell input4 = new Cell();
        input4.setX(1);
        input4.setY(1);
        beacon.add(input4);

        Cell input5 = new Cell();
        input5.setX(2);
        input5.setY(2);
        beacon.add(input5);

        Cell input6 = new Cell();
        input6.setX(2);
        input6.setY(3);
        beacon.add(input6);

        Cell input7 = new Cell();
        input7.setX(3);
        input7.setY(2);
        beacon.add(input7);

        Cell input8 = new Cell();
        input8.setX(3);
        input8.setY(3);
        beacon.add(input8);

        return beacon;
    }
}

package TestSuite;

import Game.GameBoard.Board;
import Game.GameBoard.Cell;

/**
 * Created by Chloe on 2/24/2016.
 */
public class UnitTests {


    /* TESTS 1 - 3 TAKE THE R-PENTOMINO AS INPUT */

    /**
     * Check whether or not the game runs the r-pentomino correctly for 5 iterations
     * input to start the program should be the cells {(-1,1),(0,0),(0,1),(0,2),(1,2)}
     * # of ticks should be 5
     * @param World the board for which we'll test
     * @return
     */
    public static void Test1(Board World){

        for(int runs = 0; runs < 5; runs++) World.executeTick();

        if (World.getCells().size() < 9){
            System.out.println("\nTest 1 Failure");
            System.out.println("Too few cells alive; Cells alive: " + Integer.toString(World.getCells().size()));
            System.out.println("Board at tick 5: ");
            World.displayBoard(5);
            return;
        }

        if (World.getCells().size() > 9){
            System.out.println("\nTest 1 Failure");
            System.out.println("Too many cells alive; Cells alive: " + Integer.toString(World.getCells().size()));
            System.out.println("Board at tick 5: ");
            World.displayBoard(5);
            return;
        }

        for (Cell alive : World.getCells()){
            //if cell is expected
            if ((alive.getX()==0 && alive.getY()==0) ||
            (alive.getX()==-1 && alive.getY()==0) ||
            (alive.getX()==0 && alive.getY()==3) ||
            (alive.getX()==1 && alive.getY()==1) ||
            (alive.getX()==1 && alive.getY()==2) ||
            (alive.getX()==2 && alive.getY()==2) ||
            (alive.getX()==-1 && alive.getY()==2) ||
            (alive.getX()==-2 && alive.getY()==1) ||
            (alive.getX()==-2 && alive.getY()==2)){ /* do nothing */}
            else{
                System.out.println("\nTest 1 Failure");
                System.out.println("Incorrect board.  Cells out of place/incorrect \n");
                System.out.println("Board at tick 5: ");
                World.displayBoard(5);
                return;
            }
        }
        //if our board's cells are the right quantity and they equal an expected cell
        System.out.println("\nTest1 passing completely");
    }


    /**
     * Check whether or not the game runs the r-pentomino correctly for 10 iterations
     * input to start the program should be the cells {(-1,1),(0,0),(0,1),(0,2),(1,2)}
     * # of ticks should be 10
     * @param World the board for which we'll test
     */
    public static void Test2(Board World){

        for(int runs = 0; runs < 10; runs++) World.executeTick();

        if (World.getCells().size() < 11){
            System.out.println("\nTest 2 Failure");
            System.out.println("Too few cells alive; Cells alive: " + Integer.toString(World.getCells().size()));
            System.out.println("Board at tick 10: ");
            World.displayBoard(10);
            return;
        }
        if (World.getCells().size() > 11){
            System.out.println("\nTest 2 Failure");
            System.out.println("Too many cells alive; Cells alive: " + Integer.toString(World.getCells().size()));
            System.out.println("Board at tick 10: ");
            World.displayBoard(10);
            return;
        }

        for (Cell alive : World.getCells()){
            //if cell is expected
            if ((alive.getX()==0 && alive.getY()==0) ||
            (alive.getX()==0 && alive.getY()==-1) ||
            (alive.getX()==0 && alive.getY()==-2) ||
            (alive.getX()==-1 && alive.getY()==0) ||
            (alive.getX()==-2 && alive.getY()==0) ||
            (alive.getX()==-2 && alive.getY()==1) ||
            (alive.getX()==-2 && alive.getY()==3) ||
            (alive.getX()==-3 && alive.getY()==1) ||
            (alive.getX()==-3 && alive.getY()==2) ||
            (alive.getX()==-3 && alive.getY()==3) ||
            (alive.getX()==-4 && alive.getY()==2)) {/* do nothing */}
            else{
                System.out.println("\nTest 2 Failure");
                System.out.println("Incorrect board.  Cells out of place/incorrect \n");
                System.out.println("Board at tick 10: ");
                World.displayBoard(10);
                return;
            }
        }
        //if our board's cells are the right quantity and they equal an expected cell
        System.out.println("\nTest2 passing completely");
    }


    /**
     * Check whether or not the game runs the r-pentomino correctly for 15 iterations
     * input to start the program should be the cells {(-1,1),(0,0),(0,1),(0,2),(1,2)}
     * # of ticks should be 15
     * @param World the board for which we'll test
     */
    public static void Test3(Board World){

        for(int runs = 0; runs < 15; runs++) World.executeTick();

        if (World.getCells().size() < 19){
            System.out.println("\nTest 3 Failure");
            System.out.println("Too few cells alive; Cells alive: " + Integer.toString(World.getCells().size()));
            System.out.println("Board at tick 10: ");
            World.displayBoard(15);
            return;
        }

        if (World.getCells().size() > 19){
            System.out.println("\nTest 3 Failure");
            System.out.println("Too many cells alive; Cells alive: " + Integer.toString(World.getCells().size()));
            System.out.println("Board at tick 10: ");
            World.displayBoard(15);
            return;
        }

        for (Cell alive : World.getCells()){
            //if cell is expected
            if ((alive.getX()==-6 && alive.getY()==1) ||
                (alive.getX()==-6 && alive.getY()==2) ||
                (alive.getX()==-6 && alive.getY()==3) ||
                (alive.getX()==-5 && alive.getY()==0) ||
                (alive.getX()==-5 && alive.getY()==3) ||
                (alive.getX()==-4 && alive.getY()==0) ||
                (alive.getX()==-4 && alive.getY()==4) ||
                (alive.getX()==-3 && alive.getY()==3) ||
                (alive.getX()==-3 && alive.getY()==4) ||
                (alive.getX()==-2 && alive.getY()==1) ||
                (alive.getX()==-2 && alive.getY()==3) ||
                (alive.getX()==-1 && alive.getY()==1) ||
                (alive.getX()==-1 && alive.getY()==2) ||
                (alive.getX()==-1 && alive.getY()==-2) ||
                (alive.getX()==-1 && alive.getY()==-1) ||
                (alive.getX()==0 && alive.getY()==1) ||
                (alive.getX()==0 && alive.getY()==-2) ||
                (alive.getX()==1 && alive.getY()==0) ||
                (alive.getX()==1 && alive.getY()==-1)){/* do nothing */}
            else{
                System.out.println("\nTest 3 Failure");
                System.out.println("Incorrect board.  Cells out of place/incorrect \n");
                System.out.println("Board at tick 15: ");
                World.displayBoard(15);
                return;
            }
        }
        //if our board's cells are the right quantity and they equal an expected cell
        System.out.println("\nTest3 passing completely");
    }

    /* TESTS 4 - 5 TAKE THE BLOCK STILL LIFE AS INPUT */

    /**
     * Check whether or not the game runs the block still life correctly for 5 iterations
     * input to start the program should be the cells {(0,0),(0,1),(1,0),(1,1)}
     * # of ticks should be 5
     * @param World
     */
    public static void Test4(Board World){

        for(int runs = 0; runs < 5; runs++) World.executeTick();

        if (World.getCells().size() < 4){
            System.out.println("\nTest 4 Failure");
            System.out.println("Too few cells alive; Cells alive: " + Integer.toString(World.getCells().size()));
            System.out.println("Board at tick 5: ");
            World.displayBoard(5);
            return;
        }

        if (World.getCells().size() > 4){
            System.out.println("\nTest 4 Failure");
            System.out.println("Too many cells alive; Cells alive: " + Integer.toString(World.getCells().size()));
            System.out.println("Board at tick 5: ");
            World.displayBoard(5);
            return;
        }

        for (Cell alive : World.getCells()){

            if ((alive.getX()==0 && alive.getY()==0) ||
                    (alive.getX()==0 && alive.getY()==1) ||
                    (alive.getX()==1 && alive.getY()==0) ||
                    (alive.getX()==1 && alive.getY()==1)){/* do nothing */}
            else{
                System.out.println("\nTest 4 Failure");
                System.out.println("Incorrect board.  Cells out of place/incorrect \n");
                System.out.println("Board at tick 5: ");
                World.displayBoard(5);
                return;
            }
        }
        //if our board's cells are the right quantity and they equal an expected cell
        System.out.println("\nTest4 passing completely");
    }


    /**
     * Check whether or not the game runs the block still life correctly for 5 iterations
     * input to start the program should be the cells {(0,0),(0,1),(1,0),(1,1)}
     * # of ticks should be 30
     * @param World
     */
    public static void Test5(Board World){

        for(int runs = 0; runs < 30; runs++) World.executeTick();

        if (World.getCells().size() < 4){
            System.out.println("\nTest 5 Failure");
            System.out.println("Too few cells alive; Cells alive: " + Integer.toString(World.getCells().size()));
            System.out.println("Board at tick 30: ");
            World.displayBoard(30);
            return;
        }

        if (World.getCells().size() > 4){
            System.out.println("\nTest 5 Failure");
            System.out.println("Too many cells alive; Cells alive: " + Integer.toString(World.getCells().size()));
            System.out.println("Board at tick 30: ");
            World.displayBoard(30);
            return;
        }

        for (Cell alive : World.getCells()){

            if ((alive.getX()==0 && alive.getY()==0) ||
                    (alive.getX()==0 && alive.getY()==1) ||
                    (alive.getX()==1 && alive.getY()==0) ||
                    (alive.getX()==1 && alive.getY()==1)){/* do nothing */}
            else{
                System.out.println("\nTest 5 Failure");
                System.out.println("Incorrect board.  Cells out of place/incorrect \n");
                System.out.println("Board at tick 30: ");
                World.displayBoard(30);
                return;
            }
        }
        //if our board's cells are the right quantity and they equal an expected cell
        System.out.println("\nTest5 passing completely");
    }

    /* TESTS 6 - 7 TAKE THE BOAT STILL LIFE AS INPUT */


    /**
     * Check whether or not the game runs the boat still life correctly for 5 iterations
     * input to start the program should be the cells {(0,0),(0,2),(-1,1),(-1,2),(1,1)}
     * # of ticks should be 5
     * @param World
     */
    public static void Test6(Board World){

        for(int runs = 0; runs < 5; runs++) World.executeTick();

        if (World.getCells().size() < 5){
            System.out.println("\nTest 6 Failure");
            System.out.println("Too few cells alive; Cells alive: " + Integer.toString(World.getCells().size()));
            System.out.println("Board at tick 5: ");
            World.displayBoard(5);
            return;
        }

        if (World.getCells().size() > 5){
            System.out.println("\nTest 6 Failure");
            System.out.println("Too many cells alive; Cells alive: " + Integer.toString(World.getCells().size()));
            System.out.println("Board at tick 5: ");
            World.displayBoard(5);
            return;
        }

        for (Cell alive : World.getCells()){

            if ((alive.getX()==0 && alive.getY()==0) ||
                    (alive.getX()==0 && alive.getY()==2) ||
                    (alive.getX()==-1 && alive.getY()==1) ||
                    (alive.getX()==-1 && alive.getY()==2) ||
                    (alive.getX()==1 && alive.getY()==1)){/* do nothing */}
            else{
                System.out.println("\nTest 6 Failure");
                System.out.println("Incorrect board.  Cells out of place/incorrect \n");
                System.out.println("Board at tick 5: ");
                World.displayBoard(5);
                return;
            }
        }
        //if our board's cells are the right quantity and they equal an expected cell
        System.out.println("\nTest6 passing completely");
    }


    /**
     * Check whether or not the game runs the boat still life correctly for 5 iterations
     * input to start the program should be the cells {(0,0),(0,2),(-1,1),(-1,2),(1,1)}
     * # of ticks should be 30
     * @param World
     */
    public static void Test7(Board World){

        for(int runs = 0; runs < 30; runs++) World.executeTick();

        if (World.getCells().size() < 5){
            System.out.println("\nTest 7 Failure");
            System.out.println("Too few cells alive; Cells alive: " + Integer.toString(World.getCells().size()));
            System.out.println("Board at tick 30: ");
            World.displayBoard(30);
            return;
        }

        if (World.getCells().size() > 5){
            System.out.println("\nTest 7 Failure");
            System.out.println("Too many cells alive; Cells alive: " + Integer.toString(World.getCells().size()));
            System.out.println("Board at tick 30: ");
            World.displayBoard(30);
            return;
        }

        for (Cell alive : World.getCells()){

            if ((alive.getX()==0 && alive.getY()==0) ||
                    (alive.getX()==0 && alive.getY()==2) ||
                    (alive.getX()==-1 && alive.getY()==1) ||
                    (alive.getX()==-1 && alive.getY()==2) ||
                    (alive.getX()==1 && alive.getY()==1)){/* do nothing */}
            else{
                System.out.println("\nTest 7 Failure");
                System.out.println("Incorrect board.  Cells out of place/incorrect \n");
                System.out.println("Board at tick 30: ");
                World.displayBoard(30);
                return;
            }
        }
        //if our board's cells are the right quantity and they equal an expected cell
        System.out.println("\nTest7 passing completely");
    }

    /* TESTS 8 - 9 TAKE THE BLINKER OSCILLATOR AS INPUT */

    /**
     * Check whether or not the game runs the blinker oscillator correctly for 1 iterations
     * input to start the program should be the cells {(0,0),(0,-1),(0,1)}
     * # of ticks should be 1
     * @param World
     */
    public static void Test8(Board World){

        World.executeTick();

        if (World.getCells().size() < 3) {
            System.out.println("\nTest 8 Failure");
            System.out.println("Too few cells alive; Cells alive: " + Integer.toString(World.getCells().size()));
            System.out.println("Board at tick 1: ");
            World.displayBoard(1);
            return;
        }

        if (World.getCells().size() > 3){
            System.out.println("\nTest 8 Failure");
            System.out.println("Too many cells alive; Cells alive: " + Integer.toString(World.getCells().size()));
            System.out.println("Board at tick 1: ");
            World.displayBoard(1);
            return;
        }

        for (Cell alive : World.getCells()){

            if ((alive.getY()==0 && (alive.getX()==-1 || alive.getX()==0 || alive.getX()==1))){/* do nothing */}
            else{
                System.out.println("\nTest 8 Failure");
                System.out.println("Incorrect board.  Cells out of place/incorrect \n");
                System.out.println("Board at tick 1: ");
                World.displayBoard(1);
                return;
            }
        }
        //if our board's cells are the right quantity and they equal an expected cell
        System.out.println("\nTest8 passing completely");
    }


    /**
     * Check whether or not the game runs the blinker oscillator correctly for 1 iterations
     * input to start the program should be the cells {(0,0),(0,-1),(0,1)}
     * # of ticks should be 30
     * @param World
     */
    public static void Test9(Board World){

        for (int runs = 0; runs < 30; runs++) World.executeTick();

        if (World.getCells().size() < 3) {
            System.out.println("\nTest 9 Failure");
            System.out.println("Too few cells alive; Cells alive: " + Integer.toString(World.getCells().size()));
            System.out.println("Board at tick 30: ");
            World.displayBoard(30);
            return;
        }

        if (World.getCells().size() > 3){
            System.out.println("\nTest 9 Failure");
            System.out.println("Too many cells alive; Cells alive: " + Integer.toString(World.getCells().size()));
            System.out.println("Board at tick 30: ");
            World.displayBoard(30);
            return;
        }

        for (Cell alive : World.getCells()){

            if ((alive.getX()==0 && (alive.getY()==-1 || alive.getY()==0 || alive.getY()==1))){/* do nothing */}
            else{
                System.out.println("\nTest 9 Failure");
                System.out.println("Incorrect board.  Cells out of place/incorrect \n");
                System.out.println("Board at tick 30: ");
                World.displayBoard(30);
                return;
            }
        }
        //if our board's cells are the right quantity and they equal an expected cell
        System.out.println("\nTest9 passing completely");
    }

    /* TESTS 10 - 11 TAKE THE BEACON OSCILLATOR AS INPUT */

    /**
     * Check whether or not the game runs the beacon oscillator correctly for 1 iterations
     * input to start the program should be the cells {(0,0),(0,1),(1,0),(1,1),(2,2),(2,3),(3,2),(3,3)}
     * # of ticks should be 1
     * @param World
     */
    public static void Test10(Board World){

        World.executeTick();

        if (World.getCells().size() < 6) {
            System.out.println("\nTest 10 Failure");
            System.out.println("Too few cells alive; Cells alive: " + Integer.toString(World.getCells().size()));
            System.out.println("Board at tick 1: ");
            World.displayBoard(1);
            return;
        }

        if (World.getCells().size() > 6){
            System.out.println("\nTest 10 Failure");
            System.out.println("Too many cells alive; Cells alive: " + Integer.toString(World.getCells().size()));
            System.out.println("Board at tick 1: ");
            World.displayBoard(1);
            return;
        }

        for (Cell alive : World.getCells()){

            if ((alive.getX()==0 && alive.getY()==0) ||
                    (alive.getX()==0 && alive.getY()==1) ||
                    (alive.getX()==1 && alive.getY()==0) ||
                    (alive.getX()==2 && alive.getY()==3) ||
                    (alive.getX()==3 && alive.getY()==2) ||
                    (alive.getX()==3 && alive.getY()==3)){/* do nothing */}
            else{
                System.out.println("\nTest 10 Failure");
                System.out.println("Incorrect board.  Cells out of place/incorrect \n");
                System.out.println("Board at tick 1: ");
                World.displayBoard(1);
                return;
            }
        }
        //if our board's cells are the right quantity and they equal an expected cell
        System.out.println("\nTest10 passing completely");
    }


    /**
     * Check whether or not the game runs the beacon oscillator correctly for 1 iterations
     * input to start the program should be the cells {(0,0),(0,1),(1,0),(1,1),(2,2),(2,3),(3,2),(3,3)}
     * # of ticks should be 30
     * @param World
     */
    public static void Test11(Board World){

        for (int runs = 0; runs < 30; runs++) World.executeTick();

        if (World.getCells().size() < 8) {
            System.out.println("\nTest 11 Failure");
            System.out.println("Too few cells alive; Cells alive: " + Integer.toString(World.getCells().size()));
            System.out.println("Board at tick 30: ");
            World.displayBoard(30);
            return;
        }

        if (World.getCells().size() > 8){
            System.out.println("\nTest 11 Failure");
            System.out.println("Too many cells alive; Cells alive: " + Integer.toString(World.getCells().size()));
            System.out.println("Board at tick 30: ");
            World.displayBoard(30);
            return;
        }

        for (Cell alive : World.getCells()){

            if ((alive.getX()==0 && alive.getY()==0) ||
                    (alive.getX()==0 && alive.getY()==1) ||
                    (alive.getX()==1 && alive.getY()==0) ||
                    (alive.getX()==1 && alive.getY()==1) ||
                    (alive.getX()==2 && alive.getY()==2) ||
                    (alive.getX()==2 && alive.getY()==3) ||
                    (alive.getX()==3 && alive.getY()==2) ||
                    (alive.getX()==3 && alive.getY()==3)){/* do nothing */}
            else{
                System.out.println("\nTest 11 Failure");
                System.out.println("Incorrect board.  Cells out of place/incorrect \n");
                System.out.println("Board at tick 30: ");
                World.displayBoard(30);
                return;
            }
        }
        //if our board's cells are the right quantity and they equal an expected cell
        System.out.println("\nTest11 passing completely");
    }

}

package Game;

import GameBoard.Board;
import GameBoard.Cell;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Chloe on 1/28/2016.
 * This file runs Conway's Game, taking input from console and manipulating it
 */
public class GameOfLife {

    /**
     * This is the main function for the program.  It communicates with the user
     * and handles the inputs, valid or invalid.  It also stores the information and
     * runs the Game.
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException{

        //Let user know what inputs are valid
        System.out.println("Enter three numbers separated by commas");
        System.out.println("The first digit is the quadrant {1,2,3,4};");
        System.out.println("the second digit is the x coordinate;");
        System.out.println("the third digit is the y coordinate");
        System.out.println("     Example: 1,2,3");
        System.out.println("Enter the word START to begin the game");

        //create the world
        Board myBoard = new Board();

        //Take from stream
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //Simple boolean to keep accepting inputs
        boolean go = false;
        //Integer to save how many iterations of the Game the user wants to play
        int runs = 0;

        //while loop for while START hasn't been entered
        while (!go){

            String in = br.readLine();

            //0 -> user wants to make a cell
            //1 -> user wants to start the simulation
            //2 -> user entered invalid inputs
            int input_type = parseInput(in);

            if (input_type == 0){

                //create a new cell
                Cell new_cell = makeCell(in);

                //if user input has invalid quadrant
                if (new_cell == null){
                    System.out.println("Wrong quadrant field entered, try again pl0x");
                }
                else {

                    boolean add = true;

                    //iterate through existing live cells
                    for (Cell curr : myBoard.Cells){
                        //if our cell to add is equal to an existing cell
                        if (curr.sameCell(new_cell)) {
                            add = false;
                            System.out.println("Cell already exists");
                        }
                    }
                    //if the cell to add is original and not already entered
                    if (add) {
                        System.out.println("Live cell created");
                        //add to alive cells
                        myBoard.Cells.add(new_cell);
                        //add to relevant quadrant
                        if (new_cell.quadrant == 1) {
                            myBoard.Quadrant1.add(new_cell);
                        } else if (new_cell.quadrant == 2) {
                            myBoard.Quadrant2.add(new_cell);
                        } else if (new_cell.quadrant == 3) {
                            myBoard.Quadrant3.add(new_cell);
                        } else {
                            myBoard.Quadrant4.add(new_cell);}
                    }
                }
            }
            //if user entered START input
            else if (input_type == 1){
                System.out.println("Enter a positive integer for how many iterations you want to run");
                String inp = br.readLine();
                //if our user entered a valid integer
                if (isInteger(inp)){
                    //and if the integer is positive
                    if (Integer.parseInt(inp) > 0){
                        //save the integer as our runs value
                        runs = Integer.parseInt(inp);
                        //change boolean to begin simulation
                        go = true;
                        System.out.println("The Game is starting");
                    }
                }
                //handle invalid input
                else {
                    System.out.println("Please try again, not a valid positive integer");
                }
            }
            //if user entered anything that is invalid
            else if (input_type == 2){
                System.out.println("Invalid input, try again pl0x");
            }
        }

        //same boolean concept as before
        //simulation loops until the user doesn't want to play anymore
        boolean simulation = true;

        //while we're still playing
        while (simulation) {

            //for every tick the user wants to do
            for (int i = 0; i < runs; i++) {
                //apply rules 1-4 to the entire game
                myBoard.playBall();
                //print out what's on our board by quadrants 1-4
                myBoard.toDisplay(i+1);
            }

            //Are we still playing?
            System.out.println("Continue? Y/N");
            String in = br.readLine();

            //if we're still playing
            if (in.equals("Y")){

                //Ask how many more ticks to do
                System.out.println("Enter a positive integer for how many iterations you want to run");
                String inp = br.readLine();

                //if our input is valid
                if (isInteger(inp)){
                    //and if it is positive
                    if (Integer.parseInt(inp) > 0){
                        //reset our ticks to do here
                        runs = Integer.parseInt(inp);
                        System.out.println("Continuing the Game");
                    }
                }
                //if user input is garbage
                else {
                    System.out.println("Please try again, not a valid positive integer");
                }
            }
            //if we're not going to continue
            else if (in.equals("N")){
                System.out.println("Thanks for playing!!!!");
                simulation = false;
                //quit the program
                System.exit(0);
            }
            //if user entered garbage
            else{
                System.out.println("Invalid input, try again");
            }
        }
    }

    /**
     * This program takes our user input and returns what type of input it is
     * @param in is our input from buffered reader
     * @return 0 to create a cell
     * @return 1 to start the game
     * @return 2 to tell user input was garbage
     */
    public static int parseInput(String in){

        int num_count = 0;
        if (in.equals("START")){
            return 1;
        }
        for (int i = 0; i < in.length(); i++) {
            if (Character.isDigit(in.charAt(i))){
                continue;
            }
            else if (in.charAt(i) == ','){
                num_count ++;
                continue;
            }
            else if (in.charAt(i) == '-'){
                System.out.println("Positive inputs only pl0x");
                return 2;
            }
            else{
                return 2;
            }
        }
        if (num_count == 2){
            return 0;
        }
        return 2;
    }

    /**
     * Takes a string and tells whether or not it is an integer
     * @param s is string
     * @return
     */
    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch(NumberFormatException e) {
            return false;
        } catch(NullPointerException e) {
            return false;
        }
        // only got here if we didn't return false
        return true;
    }

    /**
     * Takes a string and constructs a Cell object
     * @param in
     * @return a new Cell object
     */
    private static Cell makeCell(String in) {
        Cell new_cell = new Cell();
        int quad = Integer.parseInt(in.substring(0, 1));
        if ( quad > 0 && quad < 5){
            new_cell.quadrant = quad;
        }
        else{
            return null;
        }
        new_cell.x = Math.abs(Integer.parseInt(in.substring(2,3)));
        new_cell.y = Math.abs(Integer.parseInt(in.substring(4, 5)));
        return new_cell;
    }
}


package Game;

import GameBoard.Board;
import GameBoard.Cell;
import Test.UnitTests;

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
     * @param args default arguments
     * @throws IOException
     */
    public static void main(String[] args) throws IOException{

        //Let user know what inputs are valid
        System.out.println("Enter two numbers separated by commas");
        System.out.println("the first digit is the x coordinate;");
        System.out.println("the second digit is the y coordinate");
        System.out.println("     Example: 4,2");
        System.out.println("Enter the word START to begin the game");

        //create the world
        Board World = new Board();

        //Take from stream
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //Simple boolean to keep accepting inputs
        boolean go = false;
        //Integer to save how many iterations of the Game the user wants to play
        int runs = 0;

        //while loop for while START hasn't been entered
        while (!go){

            String in = br.readLine();

            //positive int -> user wants to make a cell
            //0 -> user wants to start the simulation
            //-1 -> user entered invalid inputs
            int input_type = parseInput(in);

            //if user entered two comma separated integers
            if (input_type > 0){

                //create a new cell
                Cell new_cell = makeCell(in, input_type);

                //if we don't already have this cell
                if (World.containsCell(new_cell, World.getCells()) == -1){
                    System.out.println("Live cell created");
                    //add to alive cells
                    World.getCells().add(new_cell);
                }
                else{
                    System.out.println("Cell already exists");
                }
            }

            //if user entered START input
            else if (input_type == 0){
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
            else if (input_type == -1){
                System.out.println("Invalid input, try again pl0x");
            }
        }

        //same boolean concept as before
        //simulation loops until the user doesn't want to play anymore
        boolean simulation = true;

        //while we're still playing
        int prev = 0;
        while (simulation) {

            //save how many times we've reiterated

            //for every tick the user wants to do
            World.toDisplay(0);
            for (int i = 0; i < runs; i++) {
                //apply rules 1-4 to the entire game
                World.playBall();
                //print out what's on our board
                World.toDisplay(prev + i + 1);
            }
            prev = prev + runs;
           /* if(!UnitTests.Test2(World.getCells())){
                System.out.println("R-Pentimento incorrect at tick 10, Fail Test2");
            }
            else {
                System.out.println("R-Pentimento correct at tick 10");
            }*/


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
     * @return 0 to start the game
     * -1 to tell user input was garbage
     *  i to save where input splits coordinates
     */
    public static int parseInput(String in){

        if (in.equals("START")){
            return 0;
        }
        for (int i = 0; i < in.length(); i++) {
            if (Character.isDigit(in.charAt(i)) || in.charAt(i) == '-'){
                continue;
            }
            else if (in.charAt(i) == ','){
                if (isInteger(in.substring(0,i))){
                    if (isInteger(in.substring(i+1,in.length()))){
                        return i;
                    }
                }
            }
            else if (isInteger(in.substring(i,i+1))){
                continue;
            }
            else{
                return -1;
            }
        }

        return -1;
    }

    /**
     * Takes a string and tells whether or not it is an integer
     * @param s is string
     * @return whether or not a string can be passed into 'parseInt()'
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
     * @param in the input entered by the user
     * @return a new Cell object
     */
    private static Cell makeCell(String in, int index){
        Cell new_cell = new Cell();
        new_cell.setX(Integer.parseInt(in.substring(0,index)));
        new_cell.setY(Integer.parseInt(in.substring(index + 1, in.length())));
        return new_cell;
    }
}


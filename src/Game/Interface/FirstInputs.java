package Game.Interface;

import Game.GameBoard.Board;
import Game.GameBoard.Cell;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by Chloe on 2/29/2016.
 */
public class FirstInputs {


    /**
     * This method takes our user input and returns what type of input it is
     * @param input is our input from buffered reader
     * @return 0 to start the game
     * -1 to tell user input was garbage
     *  i to save where input splits coordinates
     */
    public static int parseInput(String input){

        if (input.equals("START")){return 0;}

        for (int curr_char = 0; curr_char < input.length(); curr_char++) {

            if (Character.isDigit(input.charAt(curr_char)) || input.charAt(curr_char) == '-'){/* do nothing */}
            else if (input.charAt(curr_char) == ','){
                if (isInteger(input.substring(0,curr_char))){
                    if (isInteger(input.substring(curr_char+1,input.length()))){
                        return curr_char;
                    }
                }
            }
            else{
                return -1;
            }
        }
        return -1;
    }


    /**
     * This method takes a string and tells whether or not it is an integer
     * @param s string to convert
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
     * This method exists to take user inputs and place them on the game board, thus creating the world for the Game
     * @param World the Board we're manipulating
     * @param my_reader the reader that we're using to take from the console
     * @return the number of ticks we want to execute
     * @throws IOException
     */
    public static int placeOnBoard(Board World, BufferedReader my_reader) throws IOException {

        //Simple boolean to keep accepting inputs
        boolean go = false;

        //Integer to save how many iterations of the Game the user wants to play
        int runs = 0;

        //while loop for while START hasn't been entered
        while (!go){

            String input = my_reader.readLine();

            //positive int -> user wants to make a cell
            //0 -> user wants to start the simulation
            //-1 -> user entered invalid inputs
            int input_type = parseInput(input);

            //if user entered two comma separated integers
            if (input_type > 0){

                //create a new cell
                Cell new_cell = makeCell(input, input_type);

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
                String inp = my_reader.readLine();
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
        return runs;
    }


    /**
     * This method takes a string and constructs a Cell object
     * @param input the input entered by the user
     * @param index the index at which the comma lies in the input
     * @return a new Cell object
     */
    private static Cell makeCell(String input, int index){
        Cell new_cell = new Cell();
        new_cell.setX(Integer.parseInt(input.substring(0, index)));
        new_cell.setY(Integer.parseInt(input.substring(index + 1, input.length())));
        return new_cell;
    }
}

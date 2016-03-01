package Game.GameLogic;

import Game.GameBoard.Board;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by Chloe on 2/29/2016.
 * This class houses the method that can apply rules 1-4 to the Board at a single tick
 */
public class ApplyRules {


    /**
     * This method runs the game for how many runs there are and either quits or continues
     * @param World the board we're manipulating for this game
     * @param my_reader the reader we're using to take from the console
     * @param runs the number of ticks we want to execute
     * @throws IOException
     */
    public static void runTicks(Board World, BufferedReader my_reader, int runs) throws IOException {


        //while we're still playing
        int previous_count = 0;
        while (runs > 0) {

            //if we haven't started yet print the inputs
            if (previous_count == 0) World.displayBoard(0);

            //for every tick the user wants to do
            for (int tick = 0; tick < runs; tick++) {

                //apply rules 1-4 to the entire game
                World.executeTick();
                //print out what's on our board
                World.displayBoard(previous_count + tick + 1);
            }

            previous_count = previous_count + runs;
            runs = toContinue(my_reader);
        }
    }


    /**
     * This method considers whether or not a user wants to continue
     * If a user continues we return the extra runs they want to run
     * If a user discontinues we exit the program and thank the user.
     * @param my_reader
     * @return the number of extra runs we want to run
     * @throws IOException
     */
    public static int toContinue(BufferedReader my_reader) throws IOException {

        //assume we don't want to continue
        boolean run_again = false;
        while (!run_again){

            //Are we still playing?
            System.out.println("\nContinue? Y/N");
            String input1 = my_reader.readLine();
            //if we're still playing
            if (input1.equals("Y")) {

                //break out of this input loop
                run_again = true;
                //we wanna run the Game again

                //Ask how many more ticks to do
                System.out.println("Enter a positive integer for how many iterations you want to run");
                String input2 = my_reader.readLine();

                //if our input is valid and it is positive
                if (isInteger(input2) && (Integer.parseInt(input2) > 0)) {

                    //reset our ticks to do here
                    int runs = Integer.parseInt(input2);
                    System.out.println("Continuing the Game");
                    return runs;
                }

                //if our input is the ENTER key
                else if (input2.equals("")) {
                    System.out.println("Please try again with a positive integer");
                }

                //if user input is garbage
                else {
                    System.out.println("Please try again, not a valid positive integer");
                }
            }

            //if we're not going to continue
            else if (input1.equals("N")) {

                System.out.println("Thanks for playing!!!!");
                //quit the program
                System.exit(0);
            }

            //if user entered garbage
            else {

                System.out.println("Invalid input, try again");
                run_again = false;
            }
        }
        return 0;
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
}

package Game;

import Game.GameBoard.*;
import Game.Interface.FirstInputs;
import Game.GameLogic.ApplyRules;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Chloe on 1/28/2016.
 * This is the main class that subsequently brings all the parts together to run the game
 */
public class GameOfLife {


    /**
     * This is the main method for the program.  It communicates with the user
     * and handles the inputs, valid or invalid.  It also stores the information and
     * runs the Game.
     * @throws IOException
     */
    public static void main(String[] args) throws IOException{

        //Let user know what inputs are valid
        System.out.println("Enter two numbers separated by commas \n" + " The first digit is the " +
                "x coordinate; \n" + " The second digit is the y coordinate \n" + "   Example1: 4,2 \n" +
                "   Example2: -5,9 \n" + "Enter the word START to begin Conway's Game of Life");

        //create the world
        Board World = new Board();

        //Take from stream
        BufferedReader my_reader = new BufferedReader(new InputStreamReader(System.in));

        int runs = FirstInputs.placeOnBoard(World, my_reader);

        ApplyRules.runTicks(World, my_reader, runs);
    }



}


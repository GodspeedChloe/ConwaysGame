GameOfLife written by Chloe Jackson (chloexxyzz@gmail.com) Winter 2016

CONWAY'S GAME OF LIFE

DESCRIPTION:
    According to Wikipedia, "The Game of Life, also known simply as Life, is a cellular automaton devised
    by the British mathematician John Horton Conway in 1970.
    The "game" is a zero-player game, meaning that its evolution is determined by its initial state,
    requiring no further input. One interacts with the Game of Life by creating an initial configuration
    and observing how it evolves or, for advanced players, by creating patterns with particular properties."

RULES:
    1. Any live cell with fewer than two live neighbours dies, as if caused by under-population.
    2. Any live cell with two or three live neighbours lives on to the next generation.
    3. Any live cell with more than three live neighbours dies, as if by over-population.
    4. Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.

INPUTS:
    The game takes input from console and uses logic to display the ticks of a world.
        Input to start: START
        Input to create a cell: {quadrant},{x-coordinate},{y-coordinate}
            where {quadrant} is an integer in the set {1,2,3,4},
            where {x-coordinate} is a positive integer,
            where {y-coordinate} is a positive integer

            Rationale:
                The world in the Game can be described as an infinite x-y plane.  More accurately,
            the world is akin to a 2 dimensional Turing Machine (T.M.) tape, as the world is in itself a
            Turing complete computer.  We can call the read and write pen the origin, as everything can be
            described through its relation to the (0,0) point.  However it is also convenient to not use
            this (0,0) origin as I'll explain.

                The issue with normal cartesian points is that it becomes more nuanced to plot live cells
            on lines in the plain, rather than in the spaces /between/ the lines.  This allows our origin
            to be infinitely small, and we can now treat every quadrant as equal.

                The quadrants are defined as four individual two-dimensional arrays.  This way, you only
            have to append to the array rather than prepending with negative input.  In addition, our world
            is easier to parse, because we now have built in chunks.

                The cell defined by the input "1,0,0" will be read as the first cell in the first quadrant.
            Visually, "2,0,0", "3,0,0", and "4,0,0" will complete a square 'still life' cluster of live
            cells.  Notice that these cells are in every quadrant, yet have an 'x,y' of (0,0).  This is the
            modified cartesian system that is intended to allow the same logic to be applied to all the
            quadrants.

                The inputs "1,0,0", "4,0,0", and "4,0,1" will create a rectangular oscillator cluster.



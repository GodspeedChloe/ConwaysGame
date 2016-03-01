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
        Input to create a cell: {x-coordinate},{y-coordinate}
            where {x-coordinate} is an integer,
            where {y-coordinate} is an integer

            Rationale:
               Our world is a cartesian (x,y) plane to keep our Game Turing complete.  Cells can be visualized
               as taking up 0.5 units left, right, up, and down from their center (x,y) point.  This allows us to
               relate every Cell together.  Although the Game of Life does not need a specific origin, (0,0) makes
               sense for our relational plotting/neighbor checking.

# Conway's Game of Life in Java

This repository contains an implementation of Conway's Game of Life in Java. The Game of Life is a cellular automaton devised by the mathematician John Conway, and it provides an interesting demonstration of how simple rules can give rise to complex patterns.

## How the Game Works

The Game of Life is played on a grid of cells, where each cell can be in one of two states: alive or dead. The game progresses in discrete time steps, and at each step, the following rules are applied simultaneously to every cell:

1. Any live cell with fewer than two live neighbors dies (underpopulation).
2. Any live cell with two or three live neighbors survives.
3. Any live cell with more than three live neighbors dies (overpopulation).
4. Any dead cell with exactly three live neighbors becomes alive (reproduction).

By applying these rules repeatedly, various patterns can emerge, including stable patterns, oscillators, and glider-like patterns that move across the grid.

## How to Use the Program

To run the Game of Life program, you need to have Java Development Kit (JDK) installed on your system. Follow these steps to get started:

1. Clone this repository to your local machine or download the source code as a ZIP file.
2. Open a terminal or command prompt and navigate to the project directory.
3. Compile the Java source files by running the following command:

"javac App.java"

4. Once the compilation is successful, you can run the program using the following command:

"java App"

5. The program will prompt you to enter the size of the grid and the number of generations to simulate.
6. After providing the input, the Game of Life simulation will start, and you will see the grid being updated at each generation.

Feel free to modify the source code to experiment with different initial configurations or tweak the program behavior to your liking.

## Contributing

If you find any issues or have suggestions for improvements, please feel free to open an issue or submit a pull request. Contributions are welcome!

**Happy coding!**

![Alt Text](img/example.gif)




/* Homework 3 - Analyzing a Random TSP
 * CS 4500 - 02
 * February 28, 2020
 * Authors: Jared Hunsaker - jthp73@mail.umsl.edu
 *          Jordan Lanius  - jwlq89@mail.umsl.edu
 *          Charles Wyatt  - cwdh4@mail.umsl.edu
 *
 * - Grid.java -
 * This object contains a grid of variable size. Cities can be added to this grid in order
 * to output a representation of their relative locations.
 *
 * Project Files: Main.java, PathFinder.java, Order.java, > Grid.java <, City.java
 */
public class Grid {
    private int sideLength;
    private char[][] grid;

    /* Constructor */
    Grid(int length) {
        this.sideLength = length;
        this.grid = new char[this.sideLength][this.sideLength];

        this.reset();
    }

    /* Getter */
    public int getLength() {
        return this.sideLength;
    }

    /* Test if there is a city at the coordinates. */
    public boolean isCity(int xCoord, int yCoord) {
        return this.grid[xCoord][yCoord] != ' '; // Return true if there is a city at the location.
    }

    /* Create a city at the given location. */
    public void createCity(char city, int xCoord, int yCoord) {
        grid[xCoord][yCoord] = city;
    }

    /* Output the grid. */
    public void output() {
        for(int topIter = 0; topIter < this.sideLength; topIter++) {
            System.out.print("+     ");
        }
        System.out.println("+");
        for(int rowIter = 0; rowIter < this.sideLength; rowIter++) {
            for(int columnIter = 0; columnIter < this.sideLength; columnIter++) {
                System.out.print("   " + this.grid[columnIter][rowIter] + "  ");
            }
            System.out.println();
            for(int lineIter = 0; lineIter < this.sideLength; lineIter++) {
                System.out.print("+     ");
            }
            System.out.println("+");
        }
    }

    /* Reset to a blank grid. */
    public void reset() {
        for(int i = 0; i < this.sideLength; i++) {
            for(int j = 0; j < this.sideLength; j++) {
                this.grid[i][j] = ' ';
            }
        }
    }
}

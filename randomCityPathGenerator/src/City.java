/* Homework 3 - Analyzing a Random TSP
 * CS 4500 - 02
 * February 28, 2020
 * Authors: Jared Hunsaker - jthp73@mail.umsl.edu
 *          Jordan Lanius  - jwlq89@mail.umsl.edu
 *          Charles Wyatt  - cwdh4@mail.umsl.edu
 *
 * - City.java -
 * This object contains the location of one city and a function that can calculate
 * the distance between this city and another city.
 *
 * Project Files: Main.java, PathFinder.java, Order.java, Grid.java, > City.java <
 */
import java.lang.Math;

public class City {
    private int x; // X-coordinate
    private int y; // Y-coordinate

    /* Constructor */
    City( int inX, int inY ) {
        this.x = inX;
        this.y = inY;
    }

    /* Getters */
    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }

    /* Calculate distance between two cities using the Distance Formula */
    public double distance( City city ) {
        return Math.pow(Math.pow(city.getX() - this.x, 2) + Math.pow(city.getY() - this.y, 2), .5 );
    }
}

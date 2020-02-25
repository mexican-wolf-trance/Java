package src;

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

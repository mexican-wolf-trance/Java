package src;

public class Grid {
    private int xLength;
    private int yLength;
    private char[][] grid;

    /* Constructor */
    Grid(int x, int y) {
        this.xLength = x;
        this.yLength = y;
        this.grid = new char[this.xLength][this.yLength];

        this.reset();
    }

    /* Getters */
    public int getXLength() {
        return this.xLength;
    }
    public int getYLength() {
        return this.yLength;
    }

    /* Test if there is a city at the coordinates. */
    public boolean isCity(int xCoord, int yCoord) {
        return this.grid[xCoord][yCoord] != ' '; // Return true if there is a city at the location.
    }

    /* Place a city at the given location. */
    public void placeCity(char city, int xCoord, int yCoord) {
        grid[xCoord][yCoord] = city;
    }

    /* Output the grid. */
    public void output() {
        // TODO finish output...
    }

    /* Reset to a blank grid. */
    public void reset() {
        for(int i = 0; i < this.xLength; i++) {
            for(int j = 0; j < this.yLength; j++) {
                this.grid[i][j] = ' ';
            }
        }
    }
}

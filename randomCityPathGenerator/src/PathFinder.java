/* Homework 3 - Analyzing a Random TSP
 * CS 4500 - 02
 * February 28, 2020
 * Authors: Jared Hunsaker - jthp73@mail.umsl.edu
 *          Jordan Lanius  - jwlq89@mail.umsl.edu
 *          Charles Wyatt  - cwdh4@mail.umsl.edu
 *
 * - PathFinder.java -
 * This object contains the cities the salesperson must visit and calculates the distances
 * between them. It also finds the shortest path for the salesperson to tour every city.
 *
 * Project Files: Main.java, > PathFinder.java <, Order.java, Grid.java, City.java
 */

package src;
import java.util.Random;

public class PathFinder
{
    private Random random;
    private int kCities; // Number of cities
    private int nLength; // Side length of the grid
    private City[] cities; // Array of all the cities
    private Grid grid; // Grid that shows a map of the cities
    private Order pathways; // Handles Permutations
    private double[][] distances; // Matrix of the distances between each city

    /* Constructor */
    PathFinder( int kPar, int nPar )
    {
        this.random = new Random();
        this.kCities = kPar;
        this.nLength = nPar;
        this.cities = new City[this.kCities];
        this.grid = new Grid(this.nLength);
        this.pathways = new Order(kCities);
        this.distances = new double[this.kCities][this.kCities];

        this.buildCities();
        this.calcDistances();
    }

    /* Getters */
    public int getkCities()
    {
        return this.kCities;
    }
    public int getnLength()
    {
        return this.nLength;
    }

    /* Create k cities, filling both cities[] and grid */
    public void buildCities() {
        int x, y;
        for(int index = 0; index < this.kCities; index++) {
            do {
                x = random.nextInt(this.nLength);
                y = random.nextInt(this.nLength);
            } while(grid.isCity(x, y));

            cities[index] = new City(x, y);
            grid.createCity((char) (48 + index), x, y);
        }
    }

    /* Create a matrix of the distances between each city */
    public void calcDistances(){
        for (int i = 0; i < cities.length; i++){
            for (int j = 0; j < cities.length; j++){
                distances[i][j] = cities[i].distance(cities[j]);
            }
        }
    }

    /* Output the distances matrix */
    public void outputDistances(){
        System.out.println();
        for(int i = 0; i < cities.length; i++) {
            System.out.print("==========");
        }
        System.out.println();

        System.out.print("\t");
        for(int i = 0; i < cities.length; i++) {
            System.out.print("    " + i + "\t");
        }
        System.out.println();

        System.out.print("\t");
        for(int i = 0; i < cities.length; i++) {
            System.out.print("+\t");
        }
        System.out.println("+");

        for(int j = 0; j < cities.length; j++) {
            System.out.print(j + "\t");
            for(int k = 0; k < cities.length; k++) {
                String distance2D = String.format("%.2f", distances[j][k]);
                System.out.print("  " + distance2D + "\t");
            }
            System.out.println();
            System.out.print("\t");
            for(int l = 0; l < cities.length; l++) {
                System.out.print("+\t");
            }
            System.out.println("+");
        }
    }

    /* Find the path with the shortest distance */
    public double pathDistances() {
        double distance = 0;

        System.out.println("\nDifferent city orders:");
        for (int i = 0; i < this.kCities; i++){
            System.out.print(this.pathways.getOrder()[i]);
        }
        System.out.println();

        //runs through the following code for every iteration of the order of cities
        //checks against both the expected number of iterations and if it reaches the actual last iteration, just in case
        int count = 1;
        boolean end = false;
        while (count < this.pathways.getNumPermutations() && end == false){
            end = this.pathways.nextOrder(this.pathways.getOrder(), end);               //returns true if the last iteration is found, auto updates order since arrays are passed by ref
            for (int i = 0; i < this.pathways.getOrder().length; i++){    //more testing output
                System.out.print(this.pathways.getOrder()[i]);
            }
            //*call to calculate distance of path based on order here
            //*call to compare against lowest found so far here
            System.out.println();
            count++;
        }
        System.out.println("Permutations: " + count);

        return distance;
    }

    /* Output the newly found quickest path */
    public void quickOutput(int array[] , double totalDist)
    {
        System.out.println("********************");
        for (int i = 0; i < array.length; i++)
        {
            String string = array[i];
        }
        System.out.println("Permutation - " + string + ": " + totalDist);
        System.out.println("********************");
    }

    /* Object the grid, showing city locations */
    public void outputGrid() {
        System.out.println("A map of all " + this.kCities + " cities in a " + this.nLength + "x" + this.nLength + " grid:");
        this.grid.output();
    }
}

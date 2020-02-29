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

    double min_distance;
    int[] min_order;
    int[] cur_order;

    /* Constructor */
    PathFinder( int kPar, int nPar )
    {
        this.random = new Random();
        this.kCities = kPar;
        this.nLength = nPar;
        this.cities = new City[this.kCities];
        this.min_order = new int[this.kCities+1];
        this.grid = new Grid(this.nLength);
        this.pathways = new Order(kCities);
        this.distances = new double[this.kCities][this.kCities];

        this.buildCities();
        this.calcAllDistances();
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
    public void calcAllDistances(){
        for (int i = 0; i < cities.length; i++){
            for (int j = 0; j < cities.length; j++){
                distances[i][j] = cities[i].distance(cities[j]);
            }
        }
    }

    /* Output the distances matrix */
    public void outputDistances(){
        System.out.println();
        System.out.println("Distances between all of the cities");
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
        for(int i = 0; i < cities.length-1; i++) {
            System.out.print("+\t");
        }
        System.out.println("+       +");

        for(int j = 0; j < cities.length; j++) {
            System.out.print(j + "\t");
            for(int k = 0; k < cities.length; k++) {
                String distance2D = String.format("%.2f", distances[j][k]);
                System.out.print("  " + distance2D + "\t");
            }
            System.out.println();
            System.out.print("\t");
            for(int l = 0; l < cities.length-1; l++) {
                System.out.print("+\t");
            }
            System.out.println("+       +");
        }
    }

    /* Find the path with the shortest distance */
    public double pathDistances() {
        double distance = 0;
        cur_order = pathways.getOrder();
        int count = 1;
        boolean end = false;
        
        distance = findDistance(cur_order);
        min_distance = distance;
        quickOutput(cur_order, distance);
        while (count < this.pathways.getNumPermutations() && end == false){
            
            end = this.pathways.nextOrder(cur_order, end);               //returns true if the last iteration is found, auto updates order since arrays are passed by ref
            distance = findDistance(cur_order);
            
            if (distance < min_distance){
                min_distance = distance;
                for (int j = 0; j < cur_order.length; j++){
                    min_order[j] = cur_order[j];
                }
                quickOutput(min_order, distance);
            }           
            count++;
        }
        
        System.out.println("Permutations: " + count);
        return distance;
    }

    public double findDistance(int[] order){
        double distance = 0;
        for (int i = 0; i < order.length - 1; i++){
            int index = order[i];
            int next = order[i+1];
            distance += distances[index][next];
        }
        return distance;
    }

    /* Output the newly found quickest path */
    public void quickOutput(int[] array, double totalDist)
    {
        System.out.print("New Lowest Distance Found - Order: ");
        for (int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
        System.out.print(" - Distance: " + totalDist);
        System.out.println();
    }

    /* Object the grid, showing city locations */
    public void outputGrid() {
        System.out.println("A map of all " + this.kCities + " cities in a " + this.nLength + "x" + this.nLength + " grid:");
        this.grid.output();
    }
}

package src;
import java.util.Random;

public class PathFinder
{
    private Random random;
    private int k; // Number of cities
    private int n; // Side length of the grid
    private City[] cities; // Array of all the cities
    private Grid grid; // Grid that shows a map of the cities
    private Order pathways;
    private double[][] distances; // Matrix of the distances between each city

    /* Constructor */
    PathFinder( int kPar, int nPar )
    {
        this.random = new Random();
        this.k = kPar;
        this.n = nPar;
        this.cities = new City[this.k];
        this.grid = new Grid(this.n);
        this.pathways = new Order(k);
        this.distances = new double[this.k][this.k];

        this.buildCities();
    }

    /* Getters */
    public int getK()
    {
        return this.k;
    }
    public int getN()
    {
        return this.n;
    }

    /* Create k cities, filling both cities[] and grid */
    public void buildCities() {
        int x, y;
        for(int index = 0; index < this.k; index++) {
            do {
                x = random.nextInt(this.n);
                y = random.nextInt(this.n);
            } while(grid.isCity(x, y));

            cities[index] = new City(x, y);
            grid.createCity((char) (48 + index), x, y);
        }
    }

    public void calcDistances(){
        for (int i = 0; i < cities.length; i++){
            for (int j = 0; j < cities.length; j++){
                distances[i][j] = cities[i].distance(cities[j]);
            }
        }
    }

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

    /* Object Outputs */
    public void outputGrid() {
        System.out.println("A map of all " + this.k + " cities in a " + this.n + "x" + this.n + " grid:");
        this.grid.output();
    }
    public void outputPathways() {
        this.pathways.output();
    }

    /*
    public int setK()
    {
        //Input validation time!!
        System.out.println("Enter the number of cities between 4 and 9:");

        do
        {
            //Check if the user entered a string and then throw an error
            //If it is a string, try again
            while (!cityInput.hasNextInt())
            {
                String input = cityInput.next();
                System.out.println("Must be an integer between 4 and 9");
            }
            //Check if the integer the user finally entered is within the parameters
            //Try again if not
            k = cityInput.nextInt();
            if (k < 4 || k > 9)
            {
                System.out.println("Must be an integer between 4 and 9");
            }
        } while (k < 4 || k > 9);

        //cityInput.close();
        System.out.println("k = " + k);
        return this.k;
    }

    public int setN()
    {
        System.out.println("Enter the length of one side of the square grid between 10 and 30:");

        do
        {
           //Same as above except for the grid dimension
           while (!cityInput.hasNextInt())
           {
               String input = cityInput.next();
               System.out.println("Must be an integer between 10 and 30");
           }
           n = cityInput.nextInt();
           if (n < 10 || n > 30 )
           {
               System.out.println("Must be an integer between 10 and 30");
           }
       } while (n < 10 || n > 30);

       //cityInput.close();
       System.out.println("n = " + n);
       return this.n;
    }
     */
}

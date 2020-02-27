package src;
import java.util.*;


public class Main
{
    public static void main (String[] args)
    {
        
        System.out.println("I'm made it at least here...");
        
        PathFinder Pathfinder1 = new PathFinder(0,0);
        Pathfinder1.setK(); 
        Pathfinder1.setN();
        Grid Grid1 = new Grid(Pathfinder1.getN());

        System.out.println("Incredible! the grid is " + Grid1.getLength() + " x " + Grid1.getLength());
        System.out.println("Number of cities: " + Pathfinder1.getK());

        Grid1.output();


    }
}
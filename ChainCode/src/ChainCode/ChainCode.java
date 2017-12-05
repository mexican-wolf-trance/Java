package ChainCode;
import java.util.*;

public class ChainCode 
{

	public static void main(String[] args) 
	{
		int col, row, startRow, startCol, i = 0;
		int[] comp = new int[20];
		int[][] chain = new int[][]
				{
					{0,0,0,0,0,0,0,0},
					{0,1,1,1,1,0,1,0},
					{0,0,0,0,1,0,1,0},
					{0,0,1,1,1,0,1,0},
					{0,0,1,0,0,0,1,0},
					{0,0,1,0,0,0,1,0},
					{0,0,0,0,0,0,1,1},
					{0,0,0,0,0,0,0,0}
				};
		System.out.println("chain.length = " + chain.length + "\nchain[0].length = " + chain[0].length);
		for(row = 0; row < chain.length; row++)
		{
			System.out.println("row: " + row);
			for(col = 0; col < chain[0].length; col++)
			{
				System.out.println("col: " + col);
				if (chain[row][col] == 1)
				{
					startRow = row;
					startCol = col;
					System.out.println("startCol: " + startRow + "\nstartRow: " + startCol);
					
					while(true)
					{
						System.out.println("WHILE LOOP");
						System.out.println((startRow + 1) + " " + (startCol + 1));
						//DOWN
						if (chain[startRow + 1][startCol] == 1)
						{
							System.out.println("startCol: " + startRow + "\nstartRow: " + startCol);
							chain[startRow + 1][startCol] = 0;
							System.out.println("GOTCHA");
							comp[i] = 6;
							System.out.println("comp" + i +": " + comp[i]);
							i++;
							startRow += 1;
						}
						//RIGHT
						else if (chain[startRow][startCol + 1] == 1)
						{
							System.out.println("startCol: " + startRow + "\nstartRow: " + startCol);
							chain[startRow][startCol + 1] = 0;
							System.out.println("GOTCHA");
							comp[i] = 0;
							System.out.println("comp" + i +": " + comp[i]);
							i++;
							startCol += 1;
						}
						//LEFT
						else if (chain[startRow][startCol - 1] == 1)
						{
							System.out.println("startCol: " + startRow + "\nstartRow: " + startCol);
							chain[startRow][startCol - 1] = 0;
							System.out.println("GOTCHA");
							comp[i] = 4;
							System.out.println("comp" + i +": " + comp[i]);
							i++;
							startCol -= 1;
						}
						//TOP
						else if (chain[startRow - 1][startCol] == 1)
						{
							System.out.println("startCol: " + startRow + "\nstartRow: " + startCol);
							chain[startRow - 1][startCol] = 0;
							System.out.println("GOTCHA");
							comp[i] = 2;
							System.out.println("comp" + i +": " + comp[i]);
							i++;
							startRow -= 1;
						}
						//DOWN RIGHT
						else if (chain[startRow + 1][startCol + 1] == 1)
						{
							System.out.println("startCol: " + startRow + "\nstartRow: " + startCol);
							chain[startRow + 1][startCol + 1] = 0;
							System.out.println("GOTCHA");
							System.out.println("comp" + i +": " + comp[i]);
							comp[i] = 7;
							i++;
							startRow += 1;
							startCol +=1;
						}
						//DOWN LEFT
						else if (chain[startRow + 1][startCol - 1] == 1)
						{
							System.out.println("startCol: " + startRow + "\nstartRow: " + startCol);
							chain[startRow + 1][startCol - 1] = 0;
							System.out.println("GOTCHA");
							comp[i] = 5;
							System.out.println("comp" + i +": " + comp[i]);
							i++;
							startRow += 1;
							startCol -= 1;
						}
						//TOP LEFT
						else if (chain[startRow - 1][startCol - 1] == 1)
						{
							System.out.println("startCol: " + startRow + "\nstartRow: " + startCol);
							chain[startRow - 1][startCol - 1] = 0;
							System.out.println("GOTCHA");
							comp[i] = 3;
							System.out.println("comp" + i +": " + comp[i]);
							i++;
							startRow -= 1;
							startCol -= 1;
						}
						//TOP RIGHT
						else if (chain[startRow - 1][startCol + 1] == 1)
						{
							System.out.println("startCol: " + startRow + "\nstartRow: " + startCol);
							chain[startRow - 1][startCol + 1] = 0;
							System.out.println("GOTCHA");
							comp[i] = 1;
							System.out.println("comp" + i +": " + comp[i]);
							i++;
							startRow -= 1;
							startCol += 1;
						}
						else
						{
							for(i = 0; i < comp.length; i++)
								System.out.print(comp[i] + ", ");
							System.out.println("First ");
							comp = new int[20];
							i = 0;
							break;
						}
						if ((startRow + 1) != (chain.length - 1) || (startCol + 1) != (chain[0].length - 1))
						{
							for(i = 0; i < comp.length; i++)
								System.out.print(comp[i] + ", ");
							System.out.println("\nSecond ");
							break;
						}
					}
				}
			}
		}
	}
}

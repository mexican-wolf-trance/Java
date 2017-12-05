package ChainCode;
import java.util.*;

public class ChainCode 
{
	public static void main(String[] args) 
	{
		int[][] chain1 = new int[][]
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
		int[][] chain2 = new int[][]
				{
					{0,1,0,0,0,0,0,0},
					{0,1,0,0,0,1,0,0},
					{0,1,1,1,0,0,1,0},
					{0,0,0,1,1,0,0,1},
					{0,0,0,0,1,0,0,1},
					{0,0,0,0,0,1,0,0},
					{0,0,0,0,0,0,1,0},
				};
				
		imageComp(chain1);
		
		imageComp(chain2);
	}
	public static void imageComp(int[][] chain)
	{
		int col, row, startRow, startCol, i = 0;
		int[] comp = new int[20];
		int[] check = new int[20];
		//System.out.println("chain.length = " + chain.length + "\nchain[0].length = " + chain[0].length);
		for(row = 0; row < chain.length; row++)
		{
			//System.out.println("ROW: " + row);
			for(col = 0; col < chain[0].length; col++)
			{
				//System.out.println("col: " + col);
				if (chain[row][col] == 1)
				{
					startRow = row;
					startCol = col;
					//System.out.println("startCol: " + startRow + "\nstartRow: " + startCol);
					
					while(true)
					{
						//System.out.println("WHILE LOOP");
						//DOWN
						if (chain[startRow + 1][startCol] == 1)
						{
							//System.out.println("startRow: " + startRow + "\nstartCol: " + startCol);
							chain[startRow][startCol] = 0;
							//System.out.println("GOTCHA");
							comp[i] = 6;
							//System.out.println("comp" + i +": " + comp[i]);
							i++;
							startRow += 1;
						}
						//RIGHT
						else if (chain[startRow][startCol + 1] == 1)
						{
							//System.out.println("startRow: " + startRow + "\nstartCol: " + startCol);
							chain[startRow][startCol] = 0;
							//System.out.println("GOTCHA");
							comp[i] = 0;
							//System.out.println("comp" + i +": " + comp[i]);
							i++;
							startCol += 1;
						}
						//LEFT
						else if (chain[startRow][startCol - 1] == 1)
						{
							//System.out.println("startRow: " + startRow + "\nstartCol: " + startCol);
							chain[startRow][startCol] = 0;
							//System.out.println("GOTCHA");
							comp[i] = 4;
							//System.out.println("comp" + i +": " + comp[i]);
							i++;
							startCol -= 1;
						}
						//TOP
						else if (chain[startRow - 1][startCol] == 1)
						{
							//System.out.println("startRow: " + startRow + "\nstartCol: " + startCol);
							chain[startRow][startCol] = 0;
							//System.out.println("GOTCHA");
							comp[i] = 2;
							//System.out.println("comp" + i +": " + comp[i]);
							i++;
							startRow -= 1;
						}
						//DOWN RIGHT
						else if (chain[startRow + 1][startCol + 1] == 1)
						{
							//System.out.println("startRow: " + startRow + "\nstartCol: " + startCol);
							chain[startRow][startCol] = 0;
							//System.out.println("GOTCHA");
							//System.out.println("comp" + i +": " + comp[i]);
							comp[i] = 7;
							i++;
							startRow += 1;
							startCol +=1;
						}
						//DOWN LEFT
						else if (chain[startRow + 1][startCol - 1] == 1)
						{
							//System.out.println("startRow: " + startRow + "\nstartCol: " + startCol);
							chain[startRow][startCol] = 0;
							//System.out.println("GOTCHA");
							comp[i] = 5;
							//System.out.println("comp" + i +": " + comp[i]);
							i++;
							startRow += 1;
							startCol -= 1;
						}
						//TOP LEFT
						else if (chain[startRow - 1][startCol - 1] == 1)
						{
							//System.out.println("startRow: " + startRow + "\nstartCol: " + startCol);
							chain[startRow][startCol] = 0;
							//System.out.println("GOTCHA");
							comp[i] = 3;
							//System.out.println("comp" + i +": " + comp[i]);
							i++;
							startRow -= 1;
							startCol -= 1;
						}
						//TOP RIGHT
						else if (chain[startRow - 1][startCol + 1] == 1)
						{
							//System.out.println("startRow: " + startRow + "\nstartCol: " + startCol);
							chain[startRow][startCol] = 0;
							//System.out.println("GOTCHA");
							comp[i] = 1;
							//System.out.println("comp" + i +": " + comp[i]);
							i++;
							startRow -= 1;
							startCol += 1;
						}
						else
						{
							chain[startRow][startCol] = 0;
							check[i] = 10;
							for(i = 0; check[i] != 10; i++)
								System.out.print(comp[i] + ", ");
							System.out.println("\nNotFirst");
							comp = new int[20];
							i = 0;
							break;
						}
						
						/if ((startRow + 1) == (chain.length) || (startCol + 1) == (chain[0].length) || (startRow - 1) < 0 || (startCol - 1) < 0)
						{
							chain[startRow][startCol] = 0;
							check[i] = 10;
							for(i = 0; check[i] != 10; i++)
								System.out.print(comp[i] + ", ");
							System.out.println("\nFirst");
							comp = new int[20];
							i = 0;
							break;
						}
					}
				}
			}
		}
	}
}

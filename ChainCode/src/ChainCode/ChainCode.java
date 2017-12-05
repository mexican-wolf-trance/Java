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
				
		imageComp(chain2);
		
		imageComp(chain1);
	}
	public static void imageComp(int[][] chain)
	{
		int col, row, startRow, startCol, i = 0;
		int[] comp = new int[20];
		int[] check = new int[20];
		for(row = 0; row < chain.length; row++)
		{
			for(col = 0; col < chain[0].length; col++)
			{
				if (chain[row][col] == 1)
				{
					startRow = row;
					startCol = col;
					
					while(true)
					{
						//DOWN
						if ((startRow + 1) < chain.length && chain[startRow + 1][startCol] == 1)
							{
								chain[startRow][startCol] = 0;
								comp[i] = 6;
								i++;
								startRow += 1;
							}
						//RIGHT
						else if ((startCol + 1) < chain[0].length && chain[startRow][startCol + 1] == 1)
							{
								chain[startRow][startCol] = 0;
								comp[i] = 0;
								i++;
								startCol += 1;
							}
						//LEFT
						else if ((startCol - 1) >= 0 && chain[startRow][startCol - 1] == 1)
							{
								chain[startRow][startCol] = 0;
								comp[i] = 4;
								i++;
								startCol -= 1;
							}
						//TOP
						else if ((startRow - 1) >= 0 && chain[startRow - 1][startCol] == 1)
							{
								chain[startRow][startCol] = 0;
								comp[i] = 2;
								i++;
								startRow -= 1;
							}
						//DOWN RIGHT
						else if ((startRow + 1) < chain.length && (startCol + 1) < chain[0].length && chain[startRow + 1][startCol + 1] == 1)
							{
								chain[startRow][startCol] = 0;
								comp[i] = 7;
								i++;
								startRow += 1;
								startCol +=1;
							}
						//DOWN LEFT
						else if ((startRow + 1) < chain.length && (startCol - 1) >= 0 && chain[startRow + 1][startCol - 1] == 1)
							{
								chain[startRow][startCol] = 0;
								comp[i] = 5;
								i++;
								startRow += 1;
								startCol -= 1;
							}
						//TOP LEFT
						else if ((startRow - 1) >= 0 && (startCol - 1) >= 0 && chain[startRow - 1][startCol - 1] == 1)
							{
								chain[startRow][startCol] = 0;
								comp[i] = 3;
								i++;
								startRow -= 1;
								startCol -= 1;
							}
						//TOP RIGHT
						else if ((startRow - 1) >= 0 && (startCol + 1) < chain[0].length && chain[startRow - 1][startCol + 1] == 1)
							{
								chain[startRow][startCol] = 0;
								comp[i] = 1;
								i++;
								startRow -= 1;
								startCol += 1;
							}
						else
						{
							chain[startRow][startCol] = 0;
							check[i] = 10;
							System.out.print(comp[0]);
							for(i = 1; check[i] != 10; i++)
								System.out.print(", " + comp[i]);
							System.out.println("\n");
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

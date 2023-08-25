
import java.io.*;
import java.util.Scanner;
public class KnapsackDP {
	
		int[] weights;
		int[] values;
		int objects, W;
		int[][] table;
		int i, j;
		int[][] keep;
		
		KnapsackDP(Scanner sc)
		{ //reading number of objects and capacity of knapsack
			System.out.println("Enter no. of objects and total Weights");
			objects = sc.nextInt();
			W = sc.nextInt();
			values = new int[objects+1];
			weights = new int[objects+1];
			table = new int[objects+1][W+1];
			keep = new int[objects+1][W+1];
			//reading each objects value and weight
			for(i = 1; i <= objects; i++)
			{
				System.out.printf("Enter %d object value and weight", i);
				values[i] = sc.nextInt();
				weights[i] = sc.nextInt();
			}
			value();			
		}
		
		void value()
		{//find the knapsack value and objects selected
			for(i = 0; i<W; i++)
			{
				table[0][i] = 0;
				keep[0][i] = 0;
			}
			for(i=0; i<objects+1;i++)
			{
				keep[0][i]=0;
				table[i][i]=0;
			}
			//Let's fill the values row by row
			for(i=1; i<objects+1; i++)
			{
				for(j = 1; j<W+1;j++) 
				{
					//Given a weight, check if the value of the current item + value of the item that we coudl afford with the remaining weight
					//is greater than the value without the current item itself
					if(weights[i]<=j && (table[i-1][j])<(table[i-1][j-weights[i]] +values[i]))
					{
						table[i][j] = table[i-1][j-weights[i]] +values[i];
						keep[i][j] = 1;
					}
					else
					{//if the current item's weight is more than the running weight,
						//just carry forward the value without the current item
						table[i][j] = table[i-1][j];
						keep[i][j] = 0;						
					}
				}
			}
			
			System.out.printf("Value = %d\n", table[objects][W]);
			for(i = 0; i<objects + 1; i++)
			{
				for(j=0;j<W+1; j++) {
					System.out.printf("%d\t", table[i][j]);
				}
				System.out.printf("\n");
			}
			System.out.println("Selected objects are: ");
			int n = objects;
			int Wt =W;
			for(i=n;i>0;i--)
			{	
				if(keep[i][Wt]==1) {
				System.out.println(i);
				
				Wt = Wt - weights[i];
				}
			}	
	   }
}
 class MyClass
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		KnapsackDP obj = new KnapsackDP(sc);
	}
}




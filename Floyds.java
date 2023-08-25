import java.util.Scanner;
public class Floyd {
	//distance matrix declaration
	private int dmatrix[][];
	//number of vertices
	private int n;
	//parameter if there is no edge or path between 2 vertices
	public static final int INFINITY = 999;
	//constructor to initialize number of vertices
	public Floyd(int n) {
		dmatrix = new int[n+1][n+1];
		this.n = n;
		
	}
	//function that calculates shortest path
	public void floydwarshall(int amatrix[][])
	{
		for(int i = 1; i<=n;i++) 
		{
			for(int j =1; j<=n; j++)
			{//assigning the value of entered weighted matrix to distance matrix
				dmatrix[i][j]=amatrix[i][j];
				
			}
		}
		for(int k =1; k <=n; k++)
		{
			for(int i =1; i<=n;i++) 
			{
				for(int j =1; j<=n; j++)
				{
					//calculating shortest distance
					if(dmatrix[i][k] + dmatrix[k][j]< dmatrix[i][j]) {
						dmatrix[i][j] = dmatrix[i][k] + dmatrix[k][j];
					}
				}
			}
		}
		for(int source = 1; source <=n; source++)
			System.out.print("\t"+source);
		System.out.println();
		
		for(int source =1; source<=n; source++)
		{
			System.out.print(source + "\t");
			for(int destination =1; destination <= n; destination++)
			{
				System.out.print(dmatrix[source][destination] + "\t");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		int wmatrix[][];
		int n;
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the number of vertices");
		n = scan.nextInt();
		wmatrix = new int[n+1][n+1];
		System.out.println("Enter the Weighted Matrix for the graph");
		for(int source = 1; source <=n; source++) {
			for(int destination =1; destination <=n; destination++)
			{
				wmatrix[source][destination] = scan.nextInt();
				if(source == destination)
				{
					wmatrix[source][destination] = 0;
					continue;
				}
				if(wmatrix[source][destination] == 0)
				{
					wmatrix[source][destination] = INFINITY;
				}
			}
		}
		System.out.println("Following matrix shows the shortest distances between every pair of vertices");
		Floyd floydwarshall = new Floyd(n);
		//calculating and printing the shortest distance by invoking the function 
		floydwarshall.floydwarshall(wmatrix);
		scan.close();		
	}
}

import java.util.Scanner;
public class prims {
	public static void my_prim(int[][] adj, int N) {
		int i,j,min,min_cost=0,u=0,v=0,nv;
		int[] visit=new int[N];
		for(i=0;i<N;i++) {
			visit[i]=0;
		}
		visit[0]=1;
		nv=1;
		while(nv<N) {
				min=999;
				for(i=0;i<N;i++) {
					if(visit[i]==1) {
						for(j=0;j<N;j++) {
							if(adj[i][j]<min) {
								min=adj[i][j];
								adj[i][j]=999;
								u=i;
								v=j;
							}
						}
					}
				}
				if(visit[u]==1 && visit[v]==0) {
					visit[v]=1;
					min_cost+=min;
					nv++;
					System.out.print("Edge="+u+"-"+v+"\tmin_cost="+min+"\n");
				}
		}
		System.out.print("total minimum cost"+min_cost);
	}
	public static void main(String[] args) {
	// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number of vertices: ");
		int n = sc.nextInt();
		int i, j, k = 0;
		int [][] a = new int [n][n];
		System.out.println("Enter the adjacency matrix(0-no connection):");
		for(i = 0; i < n; i++) {
			for(j=0;j<n;j++) {
				a[i][j] = sc.nextInt();
				if(a[i][j]==0) {
					a[i][j]=999;
				}
			}
		}
		for(i = 0; i < n; i++) {
			for(j=0;j<n;j++) {
				if(a[i][j]==999) {
					System.out.print(0+"\t");
				}
				else {
					System.out.print(a[i][j]+"\t");
				}
			}
			System.out.print("\n");
		}
	my_prim(a,n);
	}
}


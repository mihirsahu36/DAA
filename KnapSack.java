package DAA_internal;
import java.util.Scanner;
public class knapsack {
	public static void main(String [] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the no. of object: ");
		int object=sc.nextInt();
		int[]profit=new int[object];
		int[]weight=new int[object];
		double[]p_w=new double[object];
		System.out.println("Enter the capacity: ");
		int m=sc.nextInt();
		System.out.println("Enter the profit: ");
		for(int i=0;i<object;i++) {
			profit[i]=sc.nextInt();
		}
		System.out.println("Enter the weight");
		for(int i=0;i<object;i++) {
			weight[i]=sc.nextInt();
		}
		for(int i=0;i<object;i++) {
			p_w[i]=(double)profit[i]/(double)weight[i];
		}
		System.out.println("Unarranged datas");
		System.out.println();
		for(int i=0;i<object;i++) {
			System.out.println(i);
		}
		for(int i=0;i<object;i++) {
			System.out.println(profit[i]);
		}
		for(int i=0;i<object;i++) {
			System.out.println(weight[i]);
		}
		for(int i=0;i<object;i++) {
			System.out.println(p_w[i]);
		}
		for(int i=0;i<object-1;i++) {
			for(int j=i+1;j<object;j++) {
				if(p_w[i]<p_w[j]) {
					int temp=profit[i];
					profit[i]=profit[j];
					profit[j]=temp;
					int temp1=weight[i];
					weight[i]=weight[j];
					weight[j]=temp1;
					double temp2=p_w[i];
					p_w[i]=p_w[j];
					p_w[j]=temp2;
				}
			}
		}
		System.out.println("Arranged datas");
		System.out.println();
		System.out.println("Objects");
		for(int i=0;i<object;i++) {
			System.out.println(i);
		}
		System.out.println("Profits");
		for(int i=0;i<object;i++) {
			System.out.println(profit[i]);
		}
		System.out.println("Weights");
		for(int i=0;i<object;i++) {
			System.out.println(weight[i]);
		}
		System.out.println("P_Ws");
		for(int i=0;i<object;i++) {
			System.out.println(p_w[i]);
		}
		double sum=0;
		int k=0;
		while(m>0) {
			if(weight[k]<m) {
				sum+=profit[k];
				m-=weight[k];
				k++;
			}
			else {
				double x1=m*profit[k];
				double x2=weight[k];
				double x3=x1/x2;
				sum=sum+x3;
				m=0;
			}
		}
		System.out.println("The profit is: "+sum);
	}

}

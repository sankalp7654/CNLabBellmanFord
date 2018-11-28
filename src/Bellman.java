import java.util.Scanner;

public class Bellman {
	
	public static int n;
	public static final int MAX_VALUE = 999;
	
	public void compute(int A[][], int source) {
		int D[] = new int[n + 1];
		
		for(int i = 1; i <= n; i++) {
			D[i] = MAX_VALUE;
		}
		
		D[source] = 0;
		
		for(int k = 1; k <= n-1; k++) {
			for(int i = 1; i<= n; i++) {
				for(int j = 1; j <= n; j++) {
					if(A[i][j] != MAX_VALUE) {
						if(D[j] > D[i] + A[i][j]) {
							D[j] = D[i] + A[i][j];
						}
					}
				}
			}
		}
		
		for(int i = 1; i <=n; i++) {
			System.out.println("The distance from source " + source + " to " + i + " is " + D[i]);
		}
	} 
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the number of vertices");
		n = scanner.nextInt();
		
		int A[][] = new int[n + 1][n + 1];
		
		//Entering the matrix
		System.out.println("Enter the adjacency matrix");
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				A[i][j] = scanner.nextInt();
				
				if(i == j) {
					A[i][j] = 0;
					continue;
				}
				
				if(A[i][j] == 0) {
					A[i][j] = MAX_VALUE;
				}
			}
		}
		
		//Displaying the adjacency matrix
		System.out.println("The matrix you entered");
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				System.out.print(A[i][j] + " ");
			}
			System.out.println();
		}
		//Input the source
		System.out.println("Enter the source vertex");
		int source = scanner.nextInt();
		
		new Bellman().compute(A, source);
		scanner.close();
	}

}

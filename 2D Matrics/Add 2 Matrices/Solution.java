import java.lang.*;
import java.util.*;

class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[][] a = new int[n][m];
		int[][] b = new int[n][m];
		
		for(int i=0;i<n;i++)         // input for first matrix
		{
		    for(int j = 0;j<m;j++)
		    {
		        a[i][j] = sc.nextInt();
		    }
		    
		}
		
		
		for(int i=0;i<n;i++)        // input for second matrix
		{
		    for(int j = 0;j<m;j++)
		    {
		        b[i][j] = sc.nextInt();
		    }
		    
		}
		
		for(int i=0;i<n;i++)        // Adding two matrices
		{
		    for(int j = 0;j<m;j++)
		    {
		        System.out.print(b[i][j] + a[i][j] + " ");
		    }
		    System.out.println();
		    
		}
		

		
		
		

	}
}

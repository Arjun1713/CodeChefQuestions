import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0)
		{
		    int n = sc.nextInt();
		    int[] a = new int[n];
		    int[] b = new int[n];
		    int[] c = new int[2*n];
		    for(int i=0;i<n;i++)
		    {
		        a[i] = sc.nextInt();
		        c[i] = a[i];
		        
		    }
		    
		    for(int i=n;i<2*n;i++)
		    {
		        b[i-n] = sc.nextInt();
		        c[i] = b[i-n];
		    }
		    
		    
		    Arrays.sort(c);
		    
		    int minimumDifference = Integer.MAX_VALUE;
		    for(int i=n-1;i<2*n;i++)
		    {
		        minimumDifference = Math.min(minimumDifference, c[i] - c[i-(n-1)]); // Checking the difference of maximum and minimum element of each sorted subarray of length n
		    }
		    System.out.println(minimumDifference);
		    
		    
		    
		    
		}
		
		

	}
}

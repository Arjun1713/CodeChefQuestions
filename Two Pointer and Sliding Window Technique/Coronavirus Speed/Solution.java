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
		    for(int i=0;i<n;i++)
		    {
		        a[i] = sc.nextInt();
		    }
		    
		    int maxInfected = 1, minInfected =n, currentInfected = 1;
		    
		    for(int i=0;i<n-1;i++)
		    {
		        if(Math.abs(a[i] - a[i+1]) <=2)
		        {
		            currentInfected++;
		        }
		        else
		        {
		            maxInfected = Math.max(maxInfected, currentInfected);
		            minInfected = Math.min(minInfected, currentInfected);
		            currentInfected = 1;
		        }
		    }
		    
		    //Handling the last segment
		    maxInfected = Math.max(maxInfected, currentInfected);
		    minInfected = Math.min(minInfected, currentInfected);
		    
		    //Handling the case where all are disjoint(no adjacent elements have difference less than 3)
		    if(maxInfected == 1 && minInfected > 1)
		    {
		        minInfected = 1;
		    }
		    
		    System.out.println(minInfected + " " + maxInfected);
		    
		    
		}

	}
}

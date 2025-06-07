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
		    int[] c = new int[n];
		    int[] w = new int[n];
		    
		    for(int i =0;i<n;i++)
		    {
		        c[i] = sc.nextInt();
		    }
		    for(int i=0;i<n;i++)
		    {
		        w[i] = sc.nextInt();
		    }
		    
		    Map<Integer, Integer> frequency = new HashMap<>();
		    long globalMax = Integer.MIN_VALUE;
		    long maxSum = 0;
		    
		    int left = 0;
		    for(int right=0;right<n;right++)
		    {
		        
		        frequency.put(c[right], frequency.getOrDefault(c[right],0) + 1);
		        maxSum += w[right];
		        
		        while(frequency.get(c[right]) > 1)
		        {
		            frequency.put(c[left], frequency.get(c[left])-1);
		            maxSum -= w[left];
		            left++;
		        }
		        globalMax = Math.max(globalMax, maxSum);
		        
		    }
		    
		    System.out.println(globalMax);
		}

	}
}

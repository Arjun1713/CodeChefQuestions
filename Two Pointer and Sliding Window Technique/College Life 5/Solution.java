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
		    int m = sc.nextInt();
		    
		    int[] f = new int[n];
		    int[] c = new int[m];
		    
		    for(int i=0;i<n;i++)
		    {
		        f[i] = sc.nextInt();
		    }
		    for(int j=0;j<m;j++)
		    {
		        c[j] = sc.nextInt();
		    }
		    
		    char currentlyOnTV = 'f';
		    int changes = 0;
		    
		    int  i= 0, j=0;
		    if(m>0 && n>0 && c[0] < f[0])
		    {
		        changes++;
		        currentlyOnTV = 'c';
		    }
		    while(i<n && j<m)
		    {
		        if(currentlyOnTV == 'f' && c[j]<f[i])
		        {
		            changes++;
		            j++;
		            currentlyOnTV = 'c';
		        }
		        else if(currentlyOnTV == 'c' && f[i]<c[j])
		        {
		            changes++;
		            i++;
		            currentlyOnTV = 'f';
		        }
		        else if(currentlyOnTV == 'c')
		        {
		            j++;
		        }
		        else
		        {
		            i++;
		        }
		        
		    }
		    
		    if(i<n && currentlyOnTV == 'c')
		    {
		        currentlyOnTV = 'f';
		        changes++;
		    }
		    else if(j<m && currentlyOnTV == 'f')
		    {
		        currentlyOnTV = 'c';
		        changes++;
		    }
		    
		    System.out.println(changes);
		    
		}

	}
}

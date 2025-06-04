import java.util.*;
import java.lang.*;
import java.io.*;




class Codechef
{
    
    public static boolean checkIfSubsequence(String a, String b)
    {
        int i =0, j= 0;
        while(i<a.length() && j<b.length())
        {
            if(a.charAt(i) == b.charAt(j))
            {
                i++;
            }
            j++;
        }
        
        return i==a.length();
    }
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		while(t-- > 0)
		{
		    String M = sc.next();
		    String W = sc.next();
		    
		    if(checkIfSubsequence(M,W) || checkIfSubsequence(W,M))
		    {
		        System.out.println("YES");
		    }
		    else
		    {
		        System.out.println("NO");
		    }
		}

	}
}

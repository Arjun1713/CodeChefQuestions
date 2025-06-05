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
		    String s = sc.next();
		
		
		int[] count = new int[26];
	    int left = 0, maxLen = 0;
	    for(int right = 0;right<n;right++)
	    {
	        char c = s.charAt(right);
	        count[c-'a']++;
	        
	        while(count[c-'a'] > (c - 'a' + 1))
	        {
	            count[s.charAt(left) - 'a']--;
	            left++;
	        }
	        
	        maxLen = Math.max(maxLen, right - left + 1);
	    }
	    
	    System.out.println(maxLen);
		}

	}
}

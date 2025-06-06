import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc = new Scanner(System.in);
		int sLength = sc.nextInt();
		int tLength = sc.nextInt();
		sc.nextLine();
		String s = sc.nextLine();
		String t = sc.nextLine();
		
		int[] frequency = new int[26];  //frequency array will have the frequency of all the characters of string t
		int[] window    = new int[26];  //window array will have the frequency of all the characters of the current sliding window
		
		int left = 0, right = 0;    //starting and ending positions of sliding window
		int startOfTheCurrentSubstring= -1, minLength = Integer.MAX_VALUE;
		int countOfElementsOfTinS = 0;
		
		for(char c : t.toCharArray())
		{
		    frequency[c-'a']++;
		}
		
		for(right = 0; right<sLength;right++)
		{
		    int index = s.charAt(right) - 'a';  //index pointing to the current element of s
		    window[index]++;                    //Incrementing the frequency of Current Element at index in the window array
		    
		    if(window[index]<=frequency[index])//If the current_element(element at index) is                                  also present in t, then its frequency 
		                                        //stored in frequency array will be >=1. Now     if the frequency of the same element in       window array
		                                        //is <= frequency of the same element in frequency array that means we have one element of t which
		                                        //is present in s. So we are a step closer to the solution. 
		    {
		        countOfElementsOfTinS++;   //If true, we will increment the count of encountered elements of T
		    }
		    
		    while(countOfElementsOfTinS == t.length()) //This will only be true when we have encountered all the elements of t
		    {
		        if(right-left+1  < minLength)     // If this new length less than the current minimum length
		        {
		            minLength = right-left+1;
		            startOfTheCurrentSubstring = left;  // storing the start of the current subString
		        }
		        
		        //Now we will shrink the sliding window from the left side
		        
		        index = s.charAt(left) - 'a';
		        window[index]--;  // In window we are maintaining the count of elements in the current Sliding Window. So when we shrink the window, we also decrement the count of the element at index.
		        
		        if(window[index] < frequency[index])  //If we removed an elment of t, we are decreasing the count.
		        {
		            countOfElementsOfTinS--;
		        }
		        left++;
		    }
		}
		
		if(startOfTheCurrentSubstring == -1)
		{
		    System.out.println("IMPOSSIBLE");
		}
		else
		{
		    System.out.println(minLength);
		    System.out.println(s.substring(startOfTheCurrentSubstring, startOfTheCurrentSubstring+minLength));
		}
		
		

	}
}

import java.lang.*;
import java.util.*;

class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
		//Taking Input and creating the HashMap
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] A = new int[n][m];
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
		for(int i=0;i<n;i++)
		{
		    for(int j=0;j<m;j++)
		    {
		        A[i][j] = sc.nextInt();
		        ArrayList<Integer> list = map.getOrDefault(i-j, new ArrayList<>());
		        list.add(A[i][j]);
		        map.put(i-j, list);
		    }
		}
		
		//Now Sort all the ArrayLists using Collections.sort()
		for(int key : map.keySet())
		{
		    Collections.sort(map.get(key));
		}
		
		//Now put back the sorted values to the Diagonals and Displaying the array
		for(int i=0;i<n;i++)
		{
		    for(int j=0;j<m;j++)
		    {
		        A[i][j] = map.get(i-j).get(0);
		        map.get(i-j).remove(0);
		        System.out.print(A[i][j] + " ");
		    }
		    System.out.println();
		}
		
	}
}

import java.lang.*;
import java.util.*;

class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// Taking Input
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] A = new int[n][m];
		for(int i=0;i<n;i++)
		{
		    for(int j=0;j<m;j++)
		    {
		        A[i][j] = sc.nextInt();
		    }
		}
		
		//Initializng queue and filling it with the coordinates of Rotten Apples
		Queue<int[]> queue = new LinkedList<>();
		for(int i=0;i<n;i++)
		{
		    for(int j=0;j<m;j++)
		    {
		        if(A[i][j] == 2)
		        {
		            queue.offer(new int[]{i,j});
		        }
		    }
		}
		
		//For each coordinate of infected apples, we can infect the adjacent apples in the directions
		//(i+1,j), (i-1,j), (i,j+1), (i,j-1)
		
		int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
		int timer = 0; //Timer to count the minutes
		while(!queue.isEmpty())
		{
		    
		    int queueSize = queue.size();
		    boolean rottenThisMinute = false;
		    while(queueSize-- > 0)
		    {
    		    int[] cell = queue.poll();
    		    int i = cell[0];
    		    int j = cell[1];
    		    //Going in each direction one by one
    		    for(int[] dir : directions)
    		    {
    		        int newI = i + dir[0];
    		        int newJ = j + dir[1];
    		        if(newI >= 0 && newI < n && newJ >=0 && newJ < m)
    		        {
    		            if(A[newI][newJ] == 1)  // If the adjacent apple is fresh, it will become rotten
    		            {
    		                rottenThisMinute = true;
    		                A[newI][newJ] = 2;
    		                queue.offer(new int[]{newI,newJ});  //Adding the newly rotten apple to the queue, as this will rot its adjacent apples
    		            }
    		        }
    		    }
		    }
		    
		    if(rottenThisMinute)
		    {
		        timer++;
		    }
		}
		
		//Checking if any apple is not rotten
		for(int i=0;i<n;i++)
		{
		    boolean didBreak = false;
		    for(int j=0;j<m;j++)
		    {
		        if(A[i][j] == 1)
		        {
		            timer = -1;
		            didBreak = true;
		            break;
		        }
		    }
		    if(didBreak)
		    {
		        break;
		    }
		}
		System.out.println(timer);
		

	}
}

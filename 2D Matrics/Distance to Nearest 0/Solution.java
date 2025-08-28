import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
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
		
		//Step 1 - Initializtion of the queue and updating the non-zero elements of the array to -1
		Queue<int[]> queue = new LinkedList<>();
		for(int i=0;i<n;i++)
		{
		    for(int j=0;j<m;j++)
		    {
		        if(A[i][j] == 0)
		        {
		            queue.offer(new int[]{i,j});
		        }
		        else
		        {
		            A[i][j] = -1;
		        }
		    }
		}
		
		//Step 2 - BFS Traversal
		while(!queue.isEmpty())
		{
		    int[] cell = queue.poll();
		    int i = cell[0];
		    int j = cell[1];
		    
		    //Now we have to check for all the adjacent elements.
		    //The possible directions are (i+1, j), (i,j+1), (i-1, j), (i,j-1)
		    int[][] directions = {{1,0}, {0,1}, {-1,0}, {0,-1}};
		    
		    //For each cell in the queue, we have to check in all the directions
		    
		    for(int[] dir : directions)
		    {
		        int newI = i + dir[0];
		        int newJ = j + dir[1];
		        
		        //Now we check the boundaries and the status of adjacent cells
		        if(newI >=0 && newI < n && newJ >= 0 && newJ < m)
		        {
		            if(A[newI][newJ] == -1)
		            {
		                A[newI][newJ] = A[i][j] + 1;
		                queue.offer(new int[]{newI, newJ});
		            }
		            else if(A[newI][newJ] > A[i][j]+1)
		            {
		                A[newI][newJ] = A[i][j] + 1;
		                queue.offer(new int[]{newI, newJ});
		            }
		        }
		    }
		    
		}
		
		for(int i=0;i<n;i++)
		{
		    for(int j = 0;j<m;j++)
		    {
		        System.out.print(A[i][j] + " ");
		    }
		    System.out.println();
		}
		

	}
}

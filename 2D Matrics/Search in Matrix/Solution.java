import java.lang.*;
import java.util.*;
//The core idea is to treat the 2D matrix as if it were a flattened 1D array. This allows us to apply binary search, which is inherently a 1D algorithm. We need a way to convert the 1D mid index (calculated during binary search) back into the corresponding row and column indices in the 2D matrix. 

//The row and column indices are calculates as follows - 
//  * row = mid / numCols - This gives us the row number because it tells us how many full rows we have to skip to get to the row containing the mid element. Integer division discards the remainder, giving us the correct row Index
//  * col = mid % numCols - This gives us the column number because it represents teh offset within the row. It's the reminder after dividing by the number of columns, indicating how many positions to move from the beginning of that row. 
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int x = sc.nextInt();
		int[][] A = new int[n][m];
		for(int i=0;i<n;i++)
		{
		    for(int j=0;j<m;j++)
		    {
		        A[i][j] = sc.nextInt();
		    }
		}
		
		boolean isPresent = false;
		int low = 0, high = m*n-1;
		while(low<=high)
		{
		    int mid = low + (high-low)/2;
		    int rowIndex = mid/m;
		    int colIndex = mid%m;
		    if(A[rowIndex][colIndex] == x)
		    {
		        isPresent = true;
		        break;
		    }
		    else if(x > A[rowIndex][colIndex])
		    {
		        low = mid+1;
		    }
		    else
		    {
		        high = mid-1;
		    }
		}
		
		System.out.println(isPresent?"Yes":"No");

	}
}

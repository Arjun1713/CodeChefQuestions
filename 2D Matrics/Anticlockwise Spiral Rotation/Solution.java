import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] matrix = new int[n][n];

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        int[] result = spiralOrderAnticlockwise(matrix);

        for (int num : result) {
            System.out.print(num + " ");
        }
    }

    public static int[] spiralOrderAnticlockwise(int[][] matrix) {
        // Write your code here
        int start = 0 , end = matrix.length-1;
        int i = 0, j = 0;
        int[] result = new int[matrix.length * matrix[0].length];
        int index = 0;
        
        while(start<=end)
        {
            //Traverse Down
            while(i < end)
            {
                
                result[index] = matrix[i][j];
                index++;
                i++;
            }
            
            //Traverse Right
            while(j < end)
            {
                result[index] = matrix[i][j];
                index++;
                j++;

            }
            
            //Traverse up
            while(i>start)
            {
                result[index] = matrix[i][j];
                index++;
                i--;

            }
            
            //Traverse left
            while(j>start)
            {
                result[index] = matrix[i][j];
                index++;
                j--;
            }
            
            start++;
            end--;
            i++;
            j++;
        }
        
        if(matrix.length%2 == 1)
        {
            result[index] = matrix[matrix.length/2][matrix.length/2];
        }
        
        return result;
    }
}
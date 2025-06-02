import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static int largestCommonElement(int[] arr1, int[] arr2) {
        // Write your code here
        
        
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        
        int i =arr1.length-1, j = arr2.length-1;
        while(i>=0 && j>=0)
        {
            if(arr1[i] == arr2[j])
            {
                return arr1[i];
            }
            else if(arr1[i] < arr2[j])
            {
                j--;
            }
            else
            {
                i--;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr1 = new int[n];
        int[] arr2 = new int[m];
        for (int i = 0; i < n; i++) arr1[i] = sc.nextInt();
        for (int i = 0; i < m; i++) arr2[i] = sc.nextInt();
        System.out.println(largestCommonElement(arr1, arr2));
    }
}
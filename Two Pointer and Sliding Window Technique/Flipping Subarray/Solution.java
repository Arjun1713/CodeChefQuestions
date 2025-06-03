import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0;i<n;i++)
        {
            a[i]  = sc.nextInt();
        }
        
        int listOfPreviousOnes = 0, listOfCurrentZeros = 0, listofNextOnes = 0;
        
        int i =0, answer = 0, totalZeros = 0;
        
        while(i<n)
        {
            while(i<n && a[i]==0)   // Loop to check continous current set of zeros 
            {
                totalZeros++;
                listOfCurrentZeros++;
                i++;
            }
            
            while(i<n && a[i]==1)
            {
                listofNextOnes++;
                i++;
            }
            answer = Math.max(answer, listOfPreviousOnes + listOfCurrentZeros + listofNextOnes);
            listOfPreviousOnes = listofNextOnes;
            listOfCurrentZeros = 0;
            listofNextOnes = 0;
        }
        
        
        if(answer == n && totalZeros==0) // The array was all 1s
        {
            System.out.println(answer-1); // Since we have to do a flip, it's best we just make one 1 as 0, and therefore the answer will become n-1
        }
        else
        {
            System.out.println(answer);
        }
    }
}

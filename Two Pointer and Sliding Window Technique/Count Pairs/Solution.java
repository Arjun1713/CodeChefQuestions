/* 
The core idea is that since the array is sorted, if arr[left] + arr[right] < x, 
then for the current left, all elements between left + 1 and right will also satisfy the condition when paired with arr[left].

Example 1 - arr = [1, 2, 3, 4, 5], x = 7

left = 0, right = 4: arr[0] + arr[4] = 1 + 5 = 6 < 7. This means arr[0] (which is 1) can form a valid pair with arr[1], arr[2], arr[3], and arr[4]. The number of such elements is right - left = 4 - 0 = 4. These pairs are (1, 2), (1, 3), (1, 4), and (1, 5).

left = 1, right = 4: arr[1] + arr[4] = 2 + 5 = 7. The condition arr[left] + arr[right] < x is not satisfied, so we decrement right.

left = 1, right = 3: arr[1] + arr[3] = 2 + 4 = 6 < 7. This means arr[1] (which is 2) can form a valid pair with arr[2] and arr[3]. The number of such elements is right - left = 3 - 1 = 2. These pairs are (2, 3) and (2, 4).

left = 2, right = 3: arr[2] + arr[3] = 3 + 4 = 7. The condition arr[left] + arr[right] < x is not satisfied, so we decrement right.

*/


import java.util.*;

public class Main {
    public static long countPairsLessThanX(int[] arr, int x) {
        // Write your code here
        int left = 0, right = arr.length - 1;
        long countOfPairs =0;
        while(left<right)
        {
            if((arr[left]+arr[right]) < x)
            {
                countOfPairs += right-left;
                left++;
            }
            else
            {
                right--;
            }
        }
        
        return countOfPairs;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int x = sc.nextInt();
        System.out.println(countPairsLessThanX(arr, x));
    }
}




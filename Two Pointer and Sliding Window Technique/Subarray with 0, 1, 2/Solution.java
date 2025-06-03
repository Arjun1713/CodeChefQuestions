import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static long countSubarrays(long[] arr) {
        // Write your code here
        long n = arr.length;
        Map<Long, Long> countMap = new HashMap<>();
        long i = 0, j = 0;
        long count = 0;
        
        while(j<n)
        {
            countMap.put(arr[(int)j], countMap.getOrDefault(arr[(int)j], 0L) + 1);
            while(countMap.size() == 3)
            {
                count += (n-j);
                countMap.put(arr[(int)i], countMap.get(arr[(int)i]) - 1);
                if(countMap.get(arr[(int)i]) == 0)
                {
                    countMap.remove(arr[(int)i]);
                }
                i++;
            }
            j++;
        }
        
        return count;
        
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();

        long[] arr = new long[(int)n];
        for (long i = 0; i < n; i++) {
            arr[(int)i] = scanner.nextLong();
        }

        System.out.println(countSubarrays(arr));

        scanner.close();
    }
}


/*EXPLANATION -->
===================

The base logic of what we are doing is, we are creating a Map, and storing the frequency of 0, 1 and 2. As soon as the
length of the map becomes 3, i.e we have all 0, 1 and 2 present in the map, we can say that from this point forward, any
array which contains this subarray(from i to j) will be a valid subarray. So if we have the array [0,1,2,0,1] and i is at 0 and
j is at 2, so our Map will look like this - {0:1, 1:1, 2:1}. Now [i,...,j], [i,....,j+1], [i,....,j+2], [i,....,n-1] all will be valid
subarrays because they all contain atleast one 0, 1 and 2(from i to j). 

There number of valid subarrays for these positions of i and j ---> 
    [i,...,j]    = 1     // j = 2
    [i,....,j+1] = 2     // j = 3
    [i,....,j+2] = 3     // j = 4

    i.e 3 sub arrays. And this is equal to n-j. Therefore we are incrementing it in the count. 

Now we will move i pointer to the right, and decrement the elements frequency that it was holding by 1. Then we check in the map, 
if the element's frequency becomes 0, we remove it from the element, and move j pointer to the right. 


/*
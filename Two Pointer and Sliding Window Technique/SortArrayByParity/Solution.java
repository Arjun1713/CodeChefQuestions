import java.util.*;

public class Main {
    public static void sortArrayByParity(int[] nums) {
        // Write your code here
        int[] result = new int[nums.length];
        int countOfOdd = 0;
        for(int num : nums)
        {
            if(num%2 !=0)
            {
                countOfOdd++;
            }
            
        }
        int evenIndex = countOfOdd, oddIndex = 0;
        for(int num: nums)
        {
            if(num%2==0)
            {
                result[evenIndex++] = num;
            }
            else
            {
                result[oddIndex++] = num;
            }
            
        }
        
        System.arraycopy(result, 0, nums, 0, nums.length);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = scanner.nextInt();
        }

        sortArrayByParity(nums);

        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
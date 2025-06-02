import java.util.*;

public class Main {
    public static void sortArrayByParity(int[] nums) {
        // Write your code here
        int[] result = new int[nums.length];
        int left = 0, right = nums.length-1;
        for(int num : nums)
        {
            if(num%2 == 0)
            {
                result[right--] = num;
            }
            else
            {
                result[left++] = num;
            }
            
        }
        
        //reversing the even part of the array as we copied the even elements from right to left
        for(int i=left, j=nums.length-1;i<j;i++, j--)
        {
            int temp = result[i];
            result[i] = result[j];
            result[j] = temp;
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
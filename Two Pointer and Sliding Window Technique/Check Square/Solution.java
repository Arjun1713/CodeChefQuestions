import java.util.*;

class Main {
    public static boolean checkSquareSum(long c) {
        // Write your code here
        long left = 0, right = (long)Math.sqrt(c);
        
        while(left <= right)
        {
            long sum = left*left + right*right;
            if(sum == c)
            {
                return true;
            }
            else if(sum < c)
            {
                left++;
            }
            else
            {
                right--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long c = scanner.nextLong();

        if (checkSquareSum(c)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}

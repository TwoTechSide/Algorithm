import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nums = br.readLine().split(" ");

        BigDecimal num1 = new BigDecimal(nums[0]);
        BigDecimal num2 = new BigDecimal(nums[1]);

        System.out.println(num1.add(num2));
    }
}
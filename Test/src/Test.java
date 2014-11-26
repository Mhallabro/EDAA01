import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Jonathan on 2014-11-17.
 */
public class Test {

    private static boolean isPrime(int nbr, boolean[] numbers) {
        return numbers[nbr];
    }

    public static List<Integer> getPrimes(int max){
        boolean[] numbers = new boolean[max + 1];
        Arrays.fill(numbers, true);
        numbers[0] = numbers[1] = false;
        for(int i = 2; i<max; i++){
            if(isPrime(i, numbers)){
                for(int j = 2; j*i < numbers.length; j++) numbers[j*i] = false;
            }
        }
        List<Integer> primes = new ArrayList<Integer>();
        for(int i = 2; i<=max; i++){
            if(numbers[i]) primes.add(i);
        }
        return primes;
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println(getPrimes(100000).size());
        System.out.println("Runtime: " + (System.currentTimeMillis() - startTime));
    }
}

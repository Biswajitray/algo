package hr.primality;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class PrimeNumberMain {


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int lines = Integer.parseInt(bufferedReader.readLine().trim());

        int[] number = new int[lines];
        for (int i = 0; i < lines; i++) {
            number[i] = Integer.parseInt(bufferedReader.readLine().trim());
        }
        bufferedReader.close();

        isPrime(number);



    }

    private static void isPrime(int[] numbers) throws IOException {
        long time1 = System.nanoTime();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        String prime = "Prime";
        String notPrime = "Not prime";

        List<Integer> primeNumbers = new ArrayList<>();
        primeNumbers.add(1);
        primeNumbers.add(2);
        primeNumbers.add(3);
        primeNumbers.add(5);
        primeNumbers.add(7);
        primeNumbers.add(11);

        int lastLargestNumber = -1;
        int lastLargestStartCounter = 13;
        int lastLargestUpperLimit = -1;
        for (int i = 0; i < numbers.length; i++) {
            boolean isPrime = false;
            if(primeNumbers.contains(numbers[i]))
            {
                isPrime = true;

                if(numbers[i] == 1)
                    isPrime = false;
            } else {

                int primalityFactor = numbers[i] % 10 ;

                if( (primalityFactor == 1) || (primalityFactor == 3) || (primalityFactor == 7) || (primalityFactor == 9)) {

                    int count = 0;

                    for(int k = (primeNumbers.size() - 1) ; k > -1 ; k--)
                    {
                        int primeNum = primeNumbers.get(k);
                        if(numbers[i] > primeNum) {
                            int res = numbers[i] % primeNum;
                            if (res == 0)
                                count++;

                            if (count == 3) {
                                isPrime = false;
                                break;
                            }
                        }
                    }
                    if( count == 2 )
                        count++;
                    if (count < 3) {

                        int upperLimit = (numbers[i] / 3) ;
                        int remainder = (numbers[i] % 3);
                        if(remainder == 0)
                            count++;
                        upperLimit += remainder;
                        int startCount = 13;

                        if(numbers[i] > lastLargestNumber) {
                            startCount = lastLargestStartCounter;
                            if(lastLargestUpperLimit != -1) {
                                lastLargestUpperLimit += ((numbers[i] - lastLargestNumber ) / 3 );
                                upperLimit = lastLargestUpperLimit;
                            }
                        }

                        int counterValue = startCount;
                        for (int j = startCount; j <= upperLimit; j += 2) {
                            if ( ((j % 5) != 0 ) && !primeNumbers.contains(j) ) {
                                int res = numbers[i] % j;
                                if (res == 0) {
                                    count++;
                                    counterValue = j;

                                    int quotient = numbers[i] / j;

                                    if(quotient > counterValue)
                                        lastLargestUpperLimit = counterValue;
                                    else
                                        lastLargestUpperLimit = upperLimit;
                                }

                                if (count == 3) {
                                    isPrime = false;
                                    break;
                                }
                            }
                        }

                        if(numbers[i] >= lastLargestNumber) {
                            lastLargestNumber = numbers[i];
                            lastLargestStartCounter = counterValue;
                        }

                        count++;
                    }

                    if (count == 2) {
                        isPrime = true;
                    }
                }
            }

            if(isPrime) {

                primeNumbers.add(numbers[i]);
                bufferedWriter.write(prime);
            }
            else
                bufferedWriter.write(notPrime);

            bufferedWriter.newLine();
        }
        long time2 = System.nanoTime();

        bufferedWriter.write( "" + (time2 - time1) + " milli  secs" );
        bufferedWriter.close();
    }
}

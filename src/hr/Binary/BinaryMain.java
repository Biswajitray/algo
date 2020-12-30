package hr.Binary;

import java.util.Scanner;

public class BinaryMain {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        System.out.println(count1(n));

        scanner.close();
    }
    private static int count1(int n) {
        int count =0;

        String binary = toBinary(n);
        char prev = '0';

        int maxCount = 0;
        for (int i = 0; i < binary.length(); i++) {
            char curr = binary.charAt(i);

            if(curr == '1') {
                if(prev == '0')
                    count = 0;
                count++;
            } else {
                if(prev == '1'){
                    if(count > maxCount)
                        maxCount = count;
                }
            }

            prev = curr;
        }
        if(count > maxCount)
            maxCount = count;
        return maxCount;
    }

    private static String toBinary(int n) {
        int rem = n %2;
        int quotient = n /2 ;
        if(quotient == 0 )
            return "" + rem;
        String retValue =  toBinary(quotient) + rem;
        return retValue;
    }

}

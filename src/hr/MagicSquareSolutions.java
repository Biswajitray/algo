package hr;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MagicSquareSolutions {
    // Complete the formingMagicSquare function below.
    static int formingMagicSquare(int[][] s) {
        int retVal = 0;

        /**
         * Now middle element is finalised.
         * There can be only 8 matrix combinations that satisfy the conditions for Magic Square :
         *
         *  2 9 4     2 7 6
         *  7 5 3     9 5 1
         *  6 1 8     4 3 8
         *
         *  6 7 2     4 9 2
         *  1 5 9     3 5 7
         *  8 3 4     8 1 6
         *
         *  8 1 6     8 3 4
         *  3 5 7     1 5 9
         *  4 9 2     6 7 2
         *
         *  4 3 8     6 1 8
         *  9 5 1     7 5 3
         *  2 7 6     2 9 4
         */

        int[][] magicSquare = {
                {2, 9, 4},
                {7, 5, 3},
                {6, 1, 8}
        };

        /**
         * There will be two methods flip and rotate they both call each do the flip and rotate and then compare
         *
         * flip should be done diagonally between 2 , 1 , 8
         */

        retVal = flip(magicSquare ,s);

        return retVal;
    }

    private static int flip(int[][] magicSquare , int[][] s)
    {
        int retVal = 0 ;
        // flip
        boolean breakLoop = false;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(magicSquare[i][j] == 2) {
                    if( i == j) {
                        int temp = magicSquare[0][2];
                        // swap 02 <==> 20
                        magicSquare[0][2] = magicSquare[2][0];
                        magicSquare[2][0] = temp;

                        // swap 12 <==> 21
                        temp = magicSquare[1][2];
                        magicSquare[1][2] = magicSquare[2][1];
                        magicSquare[2][1] = temp;

                        // swap 10 <==> 01
                        temp = magicSquare[1][0];
                        magicSquare[1][0] = magicSquare[0][1];
                        magicSquare[0][1] = temp;

                    } else {

                        int temp = magicSquare[0][0];
                        // swap 00 <==> 22
                        magicSquare[0][0] = magicSquare[2][2];
                        magicSquare[2][2] = temp;

                        // swap 10 <==> 21
                        temp = magicSquare[1][0];
                        magicSquare[1][0] = magicSquare[2][1];
                        magicSquare[2][1] = temp;

                        // swap 01 <==> 12
                        temp = magicSquare[0][1];
                        magicSquare[0][1] = magicSquare[1][2];
                        magicSquare[1][2] = temp;

                    }
                    breakLoop = true;
                    break;
                }
            }

            if(breakLoop)
                break;
        }

        retVal = getDifference(magicSquare ,s );

        if( (magicSquare[0][0] == 2) && (magicSquare[0][2] == 4)
                && (magicSquare[2][0] == 6) && (magicSquare[2][2] == 8)) // terminal State
        {
            int diff =  getDifference(magicSquare , s);
            retVal = diff < retVal ? diff : retVal ;

        } else {
            // rotate
            int afterRotate = rotate(magicSquare, s);

            retVal = afterRotate < retVal ? afterRotate : retVal;
        }
        return retVal;
    }

    private static int rotate(int[][] magicSquare , int[][] s)
    {
        int retVal = 0 ;
        // rotate

        // even number rotation
        int temp1 = magicSquare[0][2];
        int temp2 = magicSquare[2][2];
        magicSquare[0][2] = magicSquare[0][0]; // 00 ==> 02
        magicSquare[2][2] = temp1; // 02 ==> 22

        temp1 = temp2;
        temp2 = magicSquare[2][0];
        magicSquare[2][0] = temp1; // 22 ==> 20
        magicSquare[0][0] = temp2; // 20 ==> 00


        // odd number rotation
        temp1 = magicSquare[1][2];
        temp2 = magicSquare[2][1];
        magicSquare[1][2] = magicSquare[0][1]; // 01 ==> 12
        magicSquare[2][1] = temp1; // 12 ==> 21

        temp1 = temp2;
        temp2 = magicSquare[1][0];
        magicSquare[1][0] = temp1; // 21 ==> 10
        magicSquare[0][1] = temp2; // 10 ==> 01

        retVal = getDifference(magicSquare ,s);

        if( (magicSquare[0][0] == 2) && (magicSquare[0][2] == 4)
                && (magicSquare[2][0] == 6) && (magicSquare[2][2] == 8)) // terminal State
        {
            int diff =  getDifference(magicSquare , s);
            retVal = diff < retVal ? diff : retVal ;
        } else {
            // flip
            int afterFlip = flip(magicSquare, s);
            retVal = afterFlip < retVal ? afterFlip : retVal;
        }
        return retVal;
    }

    private static int getDifference(int[][] magicSquare, int s[][]) {
        int retVal = 0 ;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int value = magicSquare[i][j] - s[i][j];
                value = value < 0 ? value * -1 : value;

                retVal += value;
            }
        }

        return retVal;
    }
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[][] s = {
                { 4 , 9 , 2},
                { 3 , 5 , 7},
                { 8 , 1 , 5}
        };
        int result = formingMagicSquare(s);
        System.out.println("" + result);
    }
   /* public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] s = new int[3][3];

        for (int i = 0; i < 3; i++) {
            String[] sRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int sItem = Integer.parseInt(sRowItems[j]);
                s[i][j] = sItem;
            }
        }

        int result = formingMagicSquare(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }*/
}

package coursera.inversion;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FindInversionsMain {

    public static void main(String[] s)
    {

       int[] a = new int[100000];
        try {
            BufferedReader br = new BufferedReader(new FileReader("IntegerArray.txt"));
            String line= null;
            int i = 0;
            while( ( line = br.readLine()) != null )
            {
                    a[i] = Integer.parseInt(line);
                    i++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Array of length " + a.length);
       // int[] a = {9 , 3 , 1 , 2 , 8 , 7 , 6 ,4};
        long count = mergeSort(a );


        System.out.println("Inversion count " + count);
    }

    private static long mergeSort(int[] a)
    {
        long inversionCount = 0;
        if(a.length == 1)
            return inversionCount;

        if(a.length == 2) {
            if(a[0] > a[1]) {
                int temp = a[0];
                a[0] = a[1];
                a[1] = temp;
                inversionCount++;
            }
            return inversionCount;
        }

        int pivot = (a.length / 2 ) ;

        int[] firstHalf = new int[pivot];
        int[] secondHalf = new int[ a.length - pivot ];

        for (int i = 0; i < pivot; i++) {
            firstHalf[i] = a[i];
        }
         inversionCount += mergeSort(firstHalf);

        for (int j = pivot, k = 0; j < a.length; j++, k++) {
            secondHalf[k] = a[j];
        }
         inversionCount += mergeSort(secondHalf);

        int tempFromFirst = 0;
        int tempFromSecond = 0;
       // int temoInversionCountJ = 0;
        for( int i = 0, j =0 , k = 0; i < a.length ;   ) {
            if(j < firstHalf.length)
                tempFromFirst = firstHalf[j];

            if(k < secondHalf.length)
                tempFromSecond = secondHalf[k];

            if(tempFromFirst == tempFromSecond ) {
                a[i] = tempFromFirst;
                i++;
                j++;
            } else {
                if (tempFromFirst < tempFromSecond ) {
                    a[i] = tempFromFirst;
                    i++;
                    j++;
                } else  {
                    a[i] = tempFromSecond;
                    i++;
                    k++;
                    inversionCount += firstHalf.length - j;
                }
            }
            if( j == firstHalf.length) {
                for ( ; k < secondHalf.length ; k++ , i++)
                    a[i] = secondHalf[k];
                break;
            }

            if(k == secondHalf.length) {
                for ( ; j < firstHalf.length ; j++ , i++)
                    a[i] = firstHalf[j];
                break;
            }
        }
        return inversionCount;
    }
}

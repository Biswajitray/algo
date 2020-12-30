package coursera.quicksort;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class QuickSortMain {
    public static void main(String[] s)
    {

        int[] a = new int[10000];
        int[] b = new int[10000];
        int[] c = new int[10000];
        try {
            BufferedReader br = new BufferedReader(new FileReader("QuickSort.txt"));
            String line= null;
            int i = 0;
            while( ( line = br.readLine()) != null )
            {
                a[i] = Integer.parseInt(line);
                b[i] = Integer.parseInt(line);
                c[i] = Integer.parseInt(line);
                i++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Array of length " + a.length);
    //    int[] a = {3,3,9 , 3,1,2 , 2,8,7 , 6,4,2, 2,0,0, 1,1,1};
        long countA = quickSort(a , 0 , a.length  );
        countA += a.length -1;
        long countB = finalElementQuickSort(b , 0 , b.length - 1  );
        countB += b.length -1;
        long countC = medianQuickSort(c , 0 , c.length  );
        countC += c.length -1;
      /*  System.out.println();
        for (int i = 0; i < a.length; i++) {
            System.out.print(" "+ a[i] );
        }
*/
        System.out.println();
        System.out.println("Inversion count A : " + countA);
        System.out.println("Inversion count B : " + countB);
        System.out.println("Inversion count C : " + countC);
/*
        System.out.println();
        long finalEleCount = finalElementQuickSort(a , 0 , a.length  );
        System.out.println();
        System.out.println("Final Element Inversion count " + finalEleCount);*/
    }

    private static long quickSort(int[] a , int start , int end){
        long count = end -start -1;

        if(end <= start)
            return 0;

        int pivot = start;

        int i = pivot + 1;
        int j;

        for ( j = i ; j < end ; j++)
        {
                if(a[j] <= a[pivot] ) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                    i++;
                }
        }
        int temp = a[i - 1];
        a[ i - 1 ] = a[pivot];
        a[pivot] = temp;

        count += quickSort(a,start , i - 1  );
        count += quickSort(a,i , end );

        return count;
    }

    private static long finalElementQuickSort(int[] a , int start , int end){
        long count = end - start -1;

        if(end <= start)
            return 0;

        int pivot =end;

        int i = start;
        int j;


        for ( j = i ; j < end ; j++)
        {
            if(a[j] <= a[pivot] ) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i++;
            }
        }
        int temp = a[i ];
        a[ i  ] = a[pivot];
        a[pivot] = temp;

        count += finalElementQuickSort(a,start , i - 1   );
        count += finalElementQuickSort(a,i  , end );

        return count;
    }

    private static long medianQuickSort(int[] a , int start , int end){
        long count = end - start -1 ;

        if(end <= start)
            return count;

        int pivot = getPivot(a,start,end);

        int i = pivot + 1;
        int j;

        for ( j = i ; j < end ; j++)
        {
            if(a[j] <= a[pivot] ) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i++;
            }
        }
        int temp = a[i - 1];
        a[ i - 1 ] = a[pivot];
        a[pivot] = temp;

        count += medianQuickSort(a,start , i - 1  );
        count += medianQuickSort(a,i , end );
        return count;
    }

    private static int getPivot(int[] a , int start , int end){
        int median = 0;
        median = start + ((end - start) / 2);

        int firstNum = a[start];
        int lastNum = a[end - 1];
        int midNum = a[median];

        if (firstNum < lastNum) {

            if(lastNum < midNum ) // firstNum < lastNum < MidNum
                median = (end -1);

            if(midNum < firstNum) // midNum < firstNum < lastNum
                median = start;

        } else if ( lastNum > firstNum) {

            if(firstNum < midNum) // lastNum < firstNum < midNum
                median = start;

            if(midNum < lastNum) // midNum < lastNum < firstNum
                median = (end - 1 );

        } else { // when element at start and end is same
            median = start;
        }

        return median;
    }
}

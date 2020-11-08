package coursera.merge;

public class MergeSortMain {

    public static void main(String[] s)
    {
        int[] a = {25 , 4 , 31 , 8 , 57 , 2 , 26 , 3};
        //int[] a = {5 , 5 , 5 , 5 , 5 , 5 , 5 , 5};
        mergeSort(a);

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]  + " ");
        }
    }

    private static void mergeSort(int[] a)
    {
        if(a.length == 1)
            return;

        if(a.length == 2)
        {
            if(a[0] > a[1]) {
                int temp = a[0];
                a[0] = a[1];
                a[1] = temp;
            }
            return;
        }

        int pivot = (a.length / 2 ) ;

        int[] firstHalf = new int[pivot];
        int[] secondHalf = new int[ a.length - pivot ];

        for (int i = 0; i < pivot; i++) {
            firstHalf[i] = a[i];
        }
        mergeSort(firstHalf);

        for (int j = pivot, k = 0; j < a.length; j++, k++) {
            secondHalf[k] = a[j];
        }
        mergeSort(secondHalf);

        int tempFromFirst = 0;
        int tempFromSecond = 0;
        for( int i = 0, j =0 , k = 0; i < a.length ;   )
        {
            if(j < firstHalf.length)
                tempFromFirst = firstHalf[j];

            if(k < secondHalf.length)
                tempFromSecond = secondHalf[k];

            if(tempFromFirst == tempFromSecond ) {
                a[i] = tempFromFirst;
                i++;
                j++;
               /* a[i] = tempFromSecond;
                k++;*/
            } else {
                if (tempFromFirst < tempFromSecond )
                {
                    a[i] = tempFromFirst;
                    i++;
                    j++;
                } else
                {
                    a[i] = tempFromSecond;
                    i++;
                    k++;
                }
            }
            if( j == firstHalf.length)
            {

                for ( ; k < secondHalf.length ; k++ , i++)
                    a[i] = secondHalf[k];

                break;
            }

            if(k == secondHalf.length)
            {
                for ( ; j < firstHalf.length ; j++ , i++)
                    a[i] = firstHalf[j];

                break;
            }
        }

    }
}
